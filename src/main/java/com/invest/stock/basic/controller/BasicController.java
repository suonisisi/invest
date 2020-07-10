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

import java.io.IOException;
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
    public void CashFlow(String tsCodeParam,String annDateParam,String startDateParam,String endDateParam,String periodParam,String reportTypeParam,String compTypeParam) throws IOException {

        String startDate="";
        String endDate="";

        JSONObject param = new JSONObject();

        param.put("api_name","cashflow");
        param.put("token","cc90ca823298049934eb7a47e5146dba514fabcfca90d16a646265a4");
        param.put("fields","ts_code,ann_date,f_ann_date,end_date,comp_type,report_type,net_profit,finan_exp,c_fr_sale_sg,recp_tax_rends,n_depos_incr_fi,n_incr_loans_cb,n_inc_borr_oth_fi,prem_fr_orig_contr,n_incr_insured_dep,n_reinsur_prem,n_incr_disp_tfa,ifc_cash_incr,n_incr_disp_faas,n_incr_loans_oth_bank,n_cap_incr_repur,c_fr_oth_operate_a,c_inf_fr_operate_a,c_paid_goods_s,c_paid_to_for_empl,c_paid_for_taxes,n_incr_clt_loan_adv,n_incr_dep_cbob,c_pay_claims_orig_inco,pay_handling_chrg,pay_comm_insur_plcy,oth_cash_pay_oper_act,st_cash_out_act,n_cashflow_act,oth_recp_ral_inv_act,c_disp_withdrwl_invest,c_recp_return_invest,n_recp_disp_fiolta,n_recp_disp_sobu,stot_inflows_inv_act,c_pay_acq_const_fiolta,c_paid_invest,n_disp_subs_oth_biz,oth_pay_ral_inv_act,n_incr_pledge_loan,stot_out_inv_act,n_cashflow_inv_act,c_recp_borrow,proc_issue_bonds,oth_cash_recp_ral_fnc_act,stot_cash_in_fnc_act,free_cashflow,c_prepay_amt_borr,c_pay_dist_dpcp_int_exp,incl_dvd_profit_paid_sc_ms,oth_cashpay_ral_fnc_act,stot_cashout_fnc_act,n_cash_flows_fnc_act,eff_fx_flu_cash,n_incr_cash_cash_equ,c_cash_equ_beg_period,c_cash_equ_end_period,c_recp_cap_contrib,incl_cash_rec_saims,uncon_invest_loss,prov_depr_assets,depr_fa_coga_dpba,amort_intang_assets,lt_amort_deferred_exp,decr_deferred_exp,incr_acc_exp,loss_disp_fiolta,loss_scr_fa,loss_fv_chg,invest_loss,decr_def_inc_tax_assets,incr_def_inc_tax_liab,decr_inventories,decr_oper_payable,incr_oper_payable,others,im_net_cashflow_oper_act,conv_debt_into_cap,conv_copbonds_due_within_1y,fa_fnc_leases,end_bal_cash,beg_bal_cash,end_bal_cash_equ,beg_bal_cash_equ,im_n_incr_cash_equ,update_flag");

        JSONObject interfaceParam = new JSONObject();
        interfaceParam.put("start_date",startDate);
        interfaceParam.put("end_date",endDate);

        List<StockBasic> stockBasics = basicService.getStockBasic(null);

        for (StockBasic stockBasic:stockBasics) {
            interfaceParam.put("ts_code",stockBasic.getTsCode());
            param.put("params",interfaceParam);

            String result = HttpClientService.httpPostRequest(url, param);

            JSONObject stockJson = JSONObject.parseObject(result);

        }









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
