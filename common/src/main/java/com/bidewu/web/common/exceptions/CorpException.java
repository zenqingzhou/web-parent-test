package com.bidewu.web.common.exceptions;


import com.bidewu.web.common.constant.citycustomer.corp.CorpExceptionEnum;

public class CorpException extends BaseException {

    public CorpException(Integer code, String msg) {
        super(code, msg);
    }

    public CorpException(CorpExceptionEnum corpExceptionEnum) {
        super(corpExceptionEnum);
    }
}
