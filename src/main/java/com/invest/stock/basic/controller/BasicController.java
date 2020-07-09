package com.invest.stock.basic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.invest.stock.basic.dao.StockBasic;
import com.invest.stock.basic.service.BasicService;
import com.invest.utils.HttpClientService;
import org.apache.http.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: songkai
 * @Date: 2020/7/7
 */

@Controller
public class BasicController {

    @Autowired
    BasicService basicService;

    private String url ="http://api.tushare.pro";

    @RequestMapping("stocklist")
    @ResponseBody
    public  JSONObject StockList(String isHs, String status, String exchange) throws Exception {

        //请求的api


        //是否沪深港通标的，N否 H沪股通 S深股通
        String stockConnet[] = {"N","H","S"};

        //上市状态： L上市 D退市 P暂停上市，默认L
        String stockStatus[] = {"L","D","P"};

        //交易所 SSE上交所 SZSE深交所 HKEX港交所(未上线)
        String exchanges[] = {"SSE","SZSE","HKEX"};

        String fields = "ts_code,symbol,name,area,industry,fullname,enname,market,exchange,curr_type,list_status,list_date,delist_date,is_hs";

        JSONObject param = new JSONObject();

        JSONObject interfaceParam = new JSONObject();

        param.put("api_name","stock_basic");
        param.put("token","cc90ca823298049934eb7a47e5146dba514fabcfca90d16a646265a4");
        param.put("fields",fields);

        for (String connect:stockConnet) {
            if (connect.equals("N")){
                for (String stat:stockStatus) {
                    for (String exchangeItem:exchanges){
                        if(exchangeItem.equals("HKEX"))
                            continue;
                        interfaceParam.put("is_hs",connect);
                        interfaceParam.put("list_status",stat);
                        interfaceParam.put("exchange",exchangeItem);
                        param.put("params",interfaceParam);

                        String result = HttpClientService.httpPostRequest(url, param);

                        JSONObject stockJson = JSONObject.parseObject(result);

                        insertBasicStock(stockJson);

                    }

                }
            }else if (connect.equals("H")){
                for (String stat:stockStatus){
                    interfaceParam.put("is_hs",connect);
                    interfaceParam.put("list_status",stat);
                    interfaceParam.put("exchange","SSE");
                    param.put("params",interfaceParam);

                    String result = HttpClientService.httpPostRequest(url, param);

                    JSONObject stockJson = JSONObject.parseObject(result);

                    insertBasicStock(stockJson);
                }
            }else {
                for (String stat:stockStatus){
                    interfaceParam.put("is_hs",connect);
                    interfaceParam.put("list_status",stat);
                    interfaceParam.put("exchange","SZSE");
                    param.put("params",interfaceParam);

                    String result = HttpClientService.httpPostRequest(url, param);

                    JSONObject stockJson = JSONObject.parseObject(result);

                    insertBasicStock(stockJson);
                }

            }

        }

        return null;
    }


    @RequestMapping("/cashflow")
    public void CashFlow(String tsCode,String annDate,String startDate,String endDate,String period,String reportType,String compType){

    }

    public void insertBasicStock(JSONObject stockJson){

        JSONObject stockObject = new JSONObject();

        JSONArray fieldsList = (JSONArray)stockJson.getJSONObject("data").get("fields");

        JSONArray stockList = (JSONArray)stockJson.getJSONObject("data").get("items");

        for (int i = 0; i < stockList.size(); i++){
            JSONArray stock = (JSONArray)stockList.get(i);
            for(int j=0;j < fieldsList.size();j++){
                if(stock.get(j) == null){
                    stockObject.put(fieldsList.get(j).toString(),"");
                    continue;
                }

                stockObject.put(fieldsList.get(j).toString(),stock.get(j).toString());
            }

            StockBasic stockBasic = JSON.toJavaObject(stockObject, StockBasic.class);

            basicService.insertBasicStock(stockBasic);
        }

    }
}
