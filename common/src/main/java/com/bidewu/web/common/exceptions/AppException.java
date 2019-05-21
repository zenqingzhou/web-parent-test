package com.bidewu.web.common.exceptions;

/**
 * Created by wk on 2018/12/25.
 */
public class AppException extends BaseException {

    public AppException(Integer code, String msg) {
        super(code, msg);
    }
}
