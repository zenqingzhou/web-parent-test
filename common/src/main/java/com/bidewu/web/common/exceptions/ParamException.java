package com.bidewu.web.common.exceptions;


import com.bidewu.web.common.constant.sys.ParamErrorCodeEnum;

public class ParamException extends BaseException {
    public ParamException(Integer code, String msg) {
        super(code, msg);
    }

    public ParamException(ParamErrorCodeEnum paramErrorCodeEnum) {
        super(paramErrorCodeEnum);
    }
}
