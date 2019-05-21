//package com.bidewu.web.common.utils.mns;
//
//import com.aliyun.mns.client.CloudAccount;
//import com.aliyun.mns.client.MNSClient;
//import lombok.Data;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
///**
// * @author WuShoulei
// * @Date 2019/1/23 18:19
// */
//@Data
//@Configuration
//public class MnsConfig {
//
//    private static Logger logger = LoggerFactory.getLogger(MnsConfig.class);
//
//    @Value("${mns.accessId}")
//    private String accessId;
//
//    @Value("${mns.accessKey}")
//    private String accessKey;
//
//    @Value("${mns.endpoint}")
//    private String endPoint;
//
//    /**
//     * 获取MNSClient实例
//     * @return
//     */
//    @Bean(name = "client")
//    public MNSClient getClient() {
//        CloudAccount account = new CloudAccount(accessId, accessKey, endPoint);
//        // 在程序中，CloudAccount以及MNSClient单例实现即可，多线程安全
//        MNSClient client = account.getMNSClient();
//        return client;
//    }
//}
