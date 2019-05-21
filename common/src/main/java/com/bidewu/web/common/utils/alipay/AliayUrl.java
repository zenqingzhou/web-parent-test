package com.bidewu.web.common.utils.alipay;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class AliayUrl {
    @Value("{returnUrl}")
    private  String returnUrl = "";
    @Value("{aliayNotifyUrl}")
    private  String notifyUrl = "";

}
