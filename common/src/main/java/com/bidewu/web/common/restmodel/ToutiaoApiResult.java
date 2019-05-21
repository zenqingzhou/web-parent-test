package com.bidewu.web.common.restmodel;

import com.bidewu.web.common.constant.datarule.ApiResultCodeEnum;
import lombok.Data;

/**
 * @author WuShoulei on 2017/12/4
 */
@Data
public class ToutiaoApiResult {

    /**
     * 状态码
     */
    private Integer status = 200;

    /**
     * 错误信息
     */
    private String error = "";

    private Object res;

    public ToutiaoApiResult(){

    }

    public ToutiaoApiResult(Integer status, String error, Object object) {
        this.status = status;
        this.error = error;
        this.res = object;
    }

    public ToutiaoApiResult(ApiResultCodeEnum codeEnum) {
        this.status = codeEnum.getValue();
        this.error = codeEnum.getDesc();
    }

    public ToutiaoApiResult(ApiResultCodeEnum codeEnum, Object object) {
        this.status = codeEnum.getValue();
        this.error = codeEnum.getDesc();
        this.res = object;
    }

}