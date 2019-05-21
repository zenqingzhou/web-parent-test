package com.bidewu.web.common.exceptions;

/**
 * @author WuShoulei on 2017/12/6
 */
public class HouseNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HouseNotFoundException() {

    }

    public HouseNotFoundException(String message) {
        super(message);
    }
}
