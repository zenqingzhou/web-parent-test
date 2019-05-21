package com.bidewu.web.common.exceptions;


import com.bidewu.web.common.constant.base.IntBaseType;
import com.bidewu.web.common.constant.sys.RestfulServiceErrorCodeEnum;
import lombok.Data;
import lombok.Getter;

/**
 * zhangjinglei 2017/9/5 上午11:58
 */
@Data
@Getter
public class BaseException extends RuntimeException {

    private String msg;
    private Integer code;

    public BaseException(Integer code, String msg) {

        super(msg);
        this.setCode(code);
        this.setMsg(msg);
    }

    /**
     * 服务级错误
     * @param
     */
    public <T extends IntBaseType> BaseException(T exceptionEnum) {

        super(exceptionEnum.getDesc());
        this.setCode(exceptionEnum.getValue());
        this.setMsg(exceptionEnum.getDesc());
    }

    public BaseException(RestfulServiceErrorCodeEnum serviceErrorCodeEnum, String msg) {

        super(msg);
        this.setCode(serviceErrorCodeEnum.getValue());
        this.setMsg(msg);
    }
}
