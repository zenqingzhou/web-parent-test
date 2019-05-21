package com.bidewu.web.common.utils.IdCardAuth;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class IdCardConfig {
    @Value("${aliyun.idcardAuth.host}")
    private String host;
    @Value("${aliyun.idcardAuth.path}")
    private String path;
    @Value("${aliyun.idcardAuth.appcode}")
    private String appcode;

}
