package com.bidewu.web.common.exceptions;

/**
 * @author WuShoulei on 2017/12/7
 */
public class HousingProjectNotMatchException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HousingProjectNotMatchException() {

    }

    public HousingProjectNotMatchException(String message) {
        super(message);
    }
}
