//package com.bidewu.web.common.utils.message;
//
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Data
//@Component
//public class SendConfig {
//
//    //阿里云访问密钥
//    @Value("${send.AccessKeyID}")
//    private String accessKeyId;
//
//    //密钥
//    @Value("${send.AccessKey}")
//    private String accessKeySecret;
//
//    //短信签名，短信签名需要审核通过后才可以使用
////    @Value("${send.SignName}")
////    private String signName;
//
//    //短信模板，短信模板需要审核通过后才可以使用
//    @Value("${send.TemplateCode}")
//    private String templateCode;
//
//    //短信API产品名称（短信产品名固定，无需修改）
//    @Value("${send.product}")
//    private String product;
//
//    //短信API产品域名（接口地址固定，无需修改）
//    @Value("${send.domain}")
//    private String domain;
//
//    /**
//     * 云信sms
//     *
//     */
//    @Value("${yunpian.send.apikey}")
//    private String apiKey;
//
//    @Value("${yunpian.send.template}")
//    private String sendTemplate;
//}
