package com.bidewu.web.common.utils.wxPay.ErrorCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述： 错误码封装
 *
 * @author zhw
 * @date 2018/3/23 15:41
 */
public class ErrorCodeMap {

    private final static Map<String, String> unifiedOrderErrorMap;

    private final static Map<String, String> orderQueryErrorMap;

    private final static Map<String, String> closeOrderErrorMap;

    private final static Map<String, String> reFundErrorMap;

    private final static Map<String, String> refundQueryErrorMap;

    private final static  Map<String,String> downLoadBillErrorMap;
    private final static  Map<String,String> downLoadFundFlowErrorMap;


    /**
     * 统一下单错误码
     */
    static {
        unifiedOrderErrorMap = new HashMap<>();
        unifiedOrderErrorMap.put("NOAUTH", "商户无此接口权限");
        unifiedOrderErrorMap.put("NOTENOUGH", "用户帐号余额不足");
        unifiedOrderErrorMap.put("ORDERPAID", "当前订单已关闭");
        unifiedOrderErrorMap.put("ORDERCLOSED", "商户无此接口权限");
        unifiedOrderErrorMap.put("SYSTEMERROR", "系统超时");
        unifiedOrderErrorMap.put("APPID_NOT_EXIST", "参数中缺少APPID");
        unifiedOrderErrorMap.put("MCHID_NOT_EXIST", "参数中缺少MCHID");
        unifiedOrderErrorMap.put("APPID_MCHID_NOT_MATCH", "appid和mch_id不匹配");
        unifiedOrderErrorMap.put("LACK_PARAMS", "同一笔交易不能多次提交");
        unifiedOrderErrorMap.put("SIGNERROR", "参数签名结果不正确");
        unifiedOrderErrorMap.put("XML_FORMAT_ERROR", "XML格式错误");
        unifiedOrderErrorMap.put("REQUIRE_POST_METHOD", "未使用post传递参数");
        unifiedOrderErrorMap.put("POST_DATA_EMPTY", "post数据不能为空");
        unifiedOrderErrorMap.put("NOT_UTF8", "未使用指定编码格式 请使用UTF-8编码格式");
    }

    /**
     * 查询订单
     */
    static {
        orderQueryErrorMap = new HashMap<>();
        orderQueryErrorMap.put("ORDERNOTEXIST", "此交易订单号不存在");
        orderQueryErrorMap.put("SYSTEMERROR", "系统异常，请再调用发起查询");
    }

    /**
     *关闭订单
     */
    static {
        closeOrderErrorMap = new HashMap<>();
        closeOrderErrorMap.put("ORDERPAID", "订单已支付，不能发起关单");
        closeOrderErrorMap.put("SYSTEMERROR", "系统异常，请重新调用该API");
        closeOrderErrorMap.put("ORDERCLOSED", "订单已关闭，无法重复关闭");
        closeOrderErrorMap.put("SIGNERROR", "参数签名结果不正确");
        closeOrderErrorMap.put("REQUIRE_POST_METHOD", "请使用post方法");
        closeOrderErrorMap.put("XML_FORMAT_ERROR", "XML格式错误");
    }


    /**
     * 退款
     */
    static {
        reFundErrorMap = new HashMap<>();
        reFundErrorMap.put("SYSTEMERROR", "系统超时等 请不要更换商户退款单号");
        reFundErrorMap.put("BIZERR_NEED_RETRY", "退款业务流程错误，需要商户触发重试来解决");
        reFundErrorMap.put("TRADE_OVERDUE", "订单已经超过退款期限");
        reFundErrorMap.put("ERROR", "申请退款业务发生错误");
        reFundErrorMap.put("USER_ACCOUNT_ABNORMAL", "退款请求失败");
        reFundErrorMap.put("INVALID_REQ_TOO_MUCH", "连续错误请求数过多被系统短暂屏蔽");
        reFundErrorMap.put("NOTENOUGH", "商户可用退款余额不足");
        reFundErrorMap.put("INVALID_TRANSACTIONID", "请求参数未按指引进行填写");
        reFundErrorMap.put("PARAM_ERROR", "参数错误");
        reFundErrorMap.put("APPID_NOT_EXIST", "参数中缺少APPID");
        reFundErrorMap.put("REQUIRE_POST_METHOD", "请使用post方法");
        reFundErrorMap.put("SIGNERROR", "参数签名结果不正确");
        reFundErrorMap.put("XML_FORMAT_ERROR", "XML格式错误");
        reFundErrorMap.put("FREQUENCY_LIMITED", "频率限制 2个月之前的订单申请退款有频率限制");
    }



    /**
     * 查询订单
     */
    static {
        refundQueryErrorMap = new HashMap<>();
        refundQueryErrorMap.put("SYSTEMERROR", "系统超时 请尝试再次掉调用");
        refundQueryErrorMap.put("REFUNDNOTEXIST", "退款订单查询失败");
        refundQueryErrorMap.put("INVALID_TRANSACTIONID", "请求参数未按指引进行填写");
        refundQueryErrorMap.put("APPID_NOT_EXIST", "参数中缺少APPID");
        refundQueryErrorMap.put("REQUIRE_POST_METHOD", "请使用post方法");
        refundQueryErrorMap.put("SIGNERROR", "参数签名结果不正确");
        refundQueryErrorMap.put("XML_FORMAT_ERROR", "XML格式错误");
        refundQueryErrorMap.put("MCHID_NOT_EXIST", "参数中缺少MCHID");
    }

    /**
     * 下载对账单
     */
    static {
        downLoadBillErrorMap = new HashMap<>();
        downLoadBillErrorMap.put("SYSTEMERROR", "下载失败 系统超时 请尝试再次查询");
        downLoadBillErrorMap.put("invalid bill_type", "检查账单类型");
        downLoadBillErrorMap.put("data format error", "日期格式有误");
        downLoadBillErrorMap.put("missing parameter", "丢失参数");
        downLoadBillErrorMap.put("SIGN ERROR", "签名错误");
        downLoadBillErrorMap.put("NO Bill Exist", "账单不存在");
        downLoadBillErrorMap.put("Bill Creating", "账单未生成");
        downLoadBillErrorMap.put("CompressGZip Error", "账单压缩失败");
        downLoadBillErrorMap.put("UnCompressGZip Error", "账单解压失败");
    }

    /**
     * 下载资金账单
     */
    static {
        downLoadFundFlowErrorMap = new HashMap<>();
        downLoadFundFlowErrorMap.put("SYSTEMERROR", "微信支付内部错误 请稍后重试。");
        downLoadFundFlowErrorMap.put("PARAM_ERROR", "请对照文档的请求参数说明检查参");
        downLoadFundFlowErrorMap.put("NO_BILL_EXIST", "请检查当前商户号在指定日期内是否有成功的交易");
        downLoadFundFlowErrorMap.put("BILL_CREATING", "丢失参数");
        downLoadFundFlowErrorMap.put("SIGN ERROR", "签名错误");
        downLoadFundFlowErrorMap.put("NO Bill Exist", "账单不存在");
        downLoadFundFlowErrorMap.put("Bill Creating", "请先检查当前商户号在指定日期内是否有成功的交易");
    }
    /**
     * 统一下单错误码
     *
     * @param id
     * @return
     */
    public static String getUnifiedOrderErrorMap(String id) {
        return unifiedOrderErrorMap.get(id);
    }

    /**
     * 查询订单
     *
     * @param id
     * @return
     */
    public static String getOrderQueryErrorMap(String id) {
        return orderQueryErrorMap.get(id);
    }

    /**
     * 关闭订单
     *
     * @param id
     * @return
     */
    public static String getCloseOrderErrorMap(String id) {
        return closeOrderErrorMap.get(id);
    }

    /**
     * 退款
     * @param id
     * @return
     */
    public static String getReFundErrorMap(String id) {
        return reFundErrorMap.get(id);
    }

    /**
     * 退款
     * @param id
     * @return
     */
    public static String getReFundQueryErrorMap(String id) {
        return refundQueryErrorMap.get(id);
    }

    /**
     * 下载对账单
     * @param id
     * @return
     */
    public static String getDownLoadBillErrorMap(String id) {
        return downLoadBillErrorMap.get(id);
    }

    /**
     * 下载资金账单
     * @param id
     * @return
     */
    public static String getDownLoadFundFlowErrorMap(String id) {
        return downLoadFundFlowErrorMap.get(id);
    }
}
