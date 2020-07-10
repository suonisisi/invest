package com.invest.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * HttpClient发送GET、POST请求
 * @Author libin
 * @CreateDate 2018.5.28 16:56
 */
public class HttpClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientService.class);
    /**
     * 返回成功状态码
     */
    private static final int SUCCESS_CODE = 200;
    private static Object CloseableHttpResponse;

    /**
     * 发送GET请求
     * @param url   请求url
     * @param nameValuePairList    请求参数
     * @return JSON或者字符串
     * @throws Exception
     */
    public static Object sendGet(String url, List<NameValuePair> nameValuePairList) throws Exception{
        JSONObject jsonObject = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try{
            /**
             * 创建HttpClient对象
             */
            client = HttpClients.createDefault();
            /**
             * 创建URIBuilder
             */
            URIBuilder uriBuilder = new URIBuilder(url);
            /**
             * 设置参数
             */
            uriBuilder.addParameters(nameValuePairList);
            /**
             * 创建HttpGet
             */
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            /**
             * 设置请求头部编码
             */
            httpGet.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
            /**
             * 设置返回编码
             */
            httpGet.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
            /**
             * 请求服务
             */
            response = client.execute(httpGet);
            /**
             * 获取响应吗
             */
            int statusCode = response.getStatusLine().getStatusCode();

            if (SUCCESS_CODE == statusCode){
                /**
                 * 获取返回对象
                 */
                HttpEntity entity = response.getEntity();
                /**
                 * 通过EntityUitls获取返回内容
                 */
                String result = EntityUtils.toString(entity,"UTF-8");
                /**
                 * 转换成json,根据合法性返回json或者字符串
                 */
                try{
                    jsonObject = JSONObject.parseObject(result);
                    return jsonObject;
                }catch (Exception e){
                    return result;
                }
            }else{
                LOGGER.error("HttpClientService-line: {}, errorMsg{}", 97, "GET请求失败！");
            }
        }catch (Exception e){
            LOGGER.error("HttpClientService-line: {}, Exception: {}", 100, e);
        } finally {
            response.close();
            client.close();
        }
        return null;
    }

    public static String httpPostRequest(String url, JSONObject paramsJson) throws IOException {



        String result = "";
        try {
            // 创建httpClient实例
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 创建httpPost远程连接实例
            HttpPost httpPost = new HttpPost(url);
            // 配置请求参数实例
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000)// 设置连接主机服务超时时间
                    .setConnectionRequestTimeout(10000)// 设置连接请求超时时间
                    .setSocketTimeout(30000)// 设置读取数据连接超时时间
                    .build();
            // 为httpPost实例设置配置
            httpPost.setConfig(requestConfig);
            // 设置请求头
            httpPost.addHeader("content-type", "application/json;charset=utf-8");
            // 封装post请求参数
            httpPost.setEntity(new StringEntity(paramsJson.toString(),"utf-8"));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            // 从响应对象中获取响应内容
            result = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
        return result;
    }
}
