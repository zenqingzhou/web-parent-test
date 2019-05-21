package com.bidewu.web.common.utils.alipay;


import java.util.HashMap;
import java.util.Map;

public class AliayStatus {

    private final static Map<String, String> allayStatusMap;


    /**
     * 订单状态/**
     * 交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）
     * 、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款）
     */
    static {
        allayStatusMap = new HashMap<>();
        allayStatusMap.put("WAIT_BUYER_PAY", "交易创建，等待买家付款");
        allayStatusMap.put("TRADE_CLOSED", "未付款交易超时关闭");
        allayStatusMap.put("TRADE_SUCCESS", "交易支付成功");
        allayStatusMap.put("TRADE_FINISHED", "交易结束，不可退款");
    }

    public static String getllayStatusMap(String id) {
        return allayStatusMap.get(id);
    }

}
