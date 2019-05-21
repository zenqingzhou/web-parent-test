package com.bidewu.web.common.utils.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * 支付宝客户端自动配置
 */
@Configuration
public class ApilayAutoConfiguration {

    private final static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    @Autowired
    private AlipayConfig alipayConfig;

    private static final String ERROR_MSG_APPID_NULL = "alipay application's appid cann't be null";

    private static final String ERROR_MSG_PRIVATE_KEY_NULL = "alipay application's privateKey cann't be null";

    private static final String ERROR_MSG_ALIPAY_PUBLIC_KEY_NULL = "alipay's publicKey cann't be null";

    /**
     * 参数
     * @return 支付宝客户端
     */
    @Bean
    public AlipayClient alipayClient() {
        String appId = Objects.requireNonNull(alipayConfig.getAppId(), ERROR_MSG_APPID_NULL);
        String privateKey = Objects.requireNonNull(alipayConfig.getPrivateKey(), ERROR_MSG_PRIVATE_KEY_NULL);
        String format = AlipayConstants.FORMAT_JSON;
        String charset = AlipayConstants.CHARSET_UTF8;
        String alipayPublicKey = Objects.requireNonNull(alipayConfig.getAlipayPublicKey(), ERROR_MSG_ALIPAY_PUBLIC_KEY_NULL);
        String signType = AlipayConstants.SIGN_TYPE_RSA.equals(alipayConfig.getSignType()) ? AlipayConstants.SIGN_TYPE_RSA
                : AlipayConstants.SIGN_TYPE_RSA2;
        return new DefaultAlipayClient(gatewayUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
    }
}
