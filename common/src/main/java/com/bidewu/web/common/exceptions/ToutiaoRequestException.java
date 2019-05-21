package com.bidewu.web.common.exceptions;

import com.bidewu.web.common.constant.base.IntBaseType;
import com.bidewu.web.common.constant.sys.RestfulServiceErrorCodeEnum;

/**
 * Created by jyl on 17/9/8.
 * @author wushoulei
 */
public class ToutiaoRequestException extends BaseException{

    public ToutiaoRequestException(Integer code, String msg) {
        super(code, msg);
    }

    public <T extends IntBaseType> ToutiaoRequestException(T exceptionEnum) {
        super(exceptionEnum.getValue(), exceptionEnum.getDesc());
    }

    public ToutiaoRequestException(RestfulServiceErrorCodeEnum serviceErrorCodeEnum) {
        super(serviceErrorCodeEnum.getValue(), serviceErrorCodeEnum.getDesc());
    }
}
