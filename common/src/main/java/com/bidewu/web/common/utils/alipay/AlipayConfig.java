package com.bidewu.web.common.utils.alipay;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AlipayConfig {

    /**
     * 应用ID
     */
    @Value("{appId}")
    private String appId;

    /**
     * 私钥
     */
    @Value("{privateKey}")
    private String privateKey;

    /**
     * 支付宝公钥
     */
    @Value("{alipayPublicKey}")
    private String alipayPublicKey;

    /**
     * 签名模式
     */
    @Value("{signType}")
    private String signType;
    /**
     * 支付宝账号
     */
    @Value("{sellId}")
    private String sellId;
}
