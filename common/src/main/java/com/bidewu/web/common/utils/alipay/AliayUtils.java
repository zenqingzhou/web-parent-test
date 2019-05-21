package com.bidewu.web.common.utils.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AliayUtils {

    @Autowired
    private AlipayClient alipayClient;
    @Autowired
    private AliayUrl allayUrl;
    @Autowired
    private AlipayConfig alipayConfig;

    /**
     * 统一收单下单并支付页面接口alipay.trade.page.pay：
     *
     * @return
     */
    public String getAllayFormInfo(String json) {

        try {
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
            //通知地址
            alipayRequest.setReturnUrl(allayUrl.getReturnUrl());
            //回调地址
            alipayRequest.setNotifyUrl(allayUrl.getNotifyUrl());//在公共参数中设置回跳和通知地址
            alipayRequest.setBizContent(json);
            String form = "";
            AlipayTradePagePayResponse execute = alipayClient.pageExecute(alipayRequest);
            form = execute.getBody();
            return form;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从request中获得参数Map，并返回可读的Map
     *
     * @param request
     * @return
     */
    public Map getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        Map<String, String> returnMap = new HashMap<String, String>();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }

    /**
     * 验证签名
     */
    public boolean checkSign(Map paramsMap) {
        //调用SDK验证签名
        boolean checkV1 = false;
        try {
            checkV1 = AlipaySignature.rsaCheckV1(paramsMap, alipayConfig.getAlipayPublicKey(), AlipayConstants.CHARSET_UTF8, alipayConfig.getSignType());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return checkV1;

    }

    /**
     * 统一收单交易退款接口alipay.trade.refund：
     *
     * @param map
     * @return
     */
    public AlipayTradeRefundResponse refund(Map<String, Object> map) {
        AlipayTradeRefundResponse response = new AlipayTradeRefundResponse();
        try {
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            request.setBizContent(JSONObject.toJSONString(map));
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 退款查询 alipay.trade.fastpay.refund.query(统一收单交易退款查询)
     *
     * @param map
     * @return
     */
    public AlipayTradeFastpayRefundQueryResponse refundQuery(Map<String, Object> map) {
        AlipayTradeFastpayRefundQueryResponse response = new AlipayTradeFastpayRefundQueryResponse();
        try {
            AlipayTradeFastpayRefundQueryRequest request = new AlipayTradeFastpayRefundQueryRequest();
            request.setBizContent(JSONObject.toJSONString(map));
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 关闭订单
     *
     * @param map
     * @return
     */
    public AlipayTradeCloseResponse closeOrder(Map<String, Object> map) {
        AlipayTradeCloseResponse response = new AlipayTradeCloseResponse();
        try {
            AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
            request.setBizContent(JSONObject.toJSONString(map));
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 查询订单状态
     *
     * @param map
     * @return
     */
    public AlipayTradeQueryResponse queryOrderStatus(Map<String, Object> map) {
        AlipayTradeQueryResponse response = new AlipayTradeQueryResponse();
        try {
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            request.setBizContent(JSONObject.toJSONString(map));
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;

    }

    /**
     * 下载订单账单
     * @param map
     * @return
     */
    public AlipayDataDataserviceBillDownloadurlQueryResponse downloadurl(Map<String, Object> map) {

        AlipayDataDataserviceBillDownloadurlQueryResponse response = new AlipayDataDataserviceBillDownloadurlQueryResponse();
        try {
            AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();//创建API对应的request类
            request.setBizContent(JSONObject.toJSONString(map));//设置业务参数
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;
    }


}
