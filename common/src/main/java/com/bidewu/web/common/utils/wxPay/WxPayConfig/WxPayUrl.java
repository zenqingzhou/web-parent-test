package com.bidewu.web.common.utils.wxPay.WxPayConfig;

import lombok.Data;

@Data
public class WxPayUrl {

    //统一下单
    public final static String unifiedOrderUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //查询订单
    public final static String orderQueryUrl = "https://api.mch.weixin.qq.com/pay/orderquery";
    //关闭订单
    public final static String closeOrderUrl = "https://api.mch.weixin.qq.com/pay/closeorder";
    //申请退款
    public final static String refundUrl = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    //查询退款
    public final static String refundQueryUrl = "https://api.mch.weixin.qq.com/pay/refundquery";
    //下载对账单
    public final static String downLoadBillUrl = "https://api.mch.weixin.qq.com/pay/downloadbill";
    //下载资金账单
    public final static String downLoadFundFlowUrl = "https://api.mch.weixin.qq.com/pay/downloadfundflow";
    //交易保障
    public final static String reportUrl = "https://api.mch.weixin.qq.com/payitil/report";
    //转换短链接
    public final static String shortUrl = "https://api.mch.weixin.qq.com/tools/shorturl";
    //拉取订单评价数据
    public final static String batchQueryCommentUrl = "https://api.mch.weixin.qq.com/billcommentsp/batchquerycomment";

}
