package com.bidewu.web.common.utils.wxPay.WxPayConfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Data
public class WxPayConfig {

    //初始化
    @Value("{APP_ID}")
    private String APP_ID; //公众账号appid（改为自己实际的）
    @Value("{MCH_ID}")
    private String MCH_ID; //商户号（改为自己实际的）
    @Value("{MCH_PATH}")
    private String MCH_PATH; //证书路径
    @Value("{notifyUrl}")
    private String notifyUrl;
    /**
     * 商户密钥
     */
    @Value("{MCH_KEY}")
    private String MCH_KEY;



}
