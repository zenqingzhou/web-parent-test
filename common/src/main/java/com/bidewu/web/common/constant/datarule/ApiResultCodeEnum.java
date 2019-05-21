package com.bidewu.web.common.constant.datarule;


import com.bidewu.web.common.constant.base.IntBaseType;

/**
 * @author WuShoulei on 2017/12/5
 */
public enum ApiResultCodeEnum implements IntBaseType,CodeEnum{

    SUCCESS("成功", 200),
    VERIFY_FAIL_CODE("签名校验失败", 400),
    HOUSE_NOT_FOUND("待下架房源不存在", 401),
    HOUSING_PROJECT_NOT_MATCH("楼盘未匹配", 402),
    INVALID_IP("非法IP", 403),
    UNOPENED_CITY("未开放城市", 404),
    SERVER_INTERNAL_ERROR_CODE("服务器内部错误", 500),
    REQUEST_PARAM_ERROR("请求参数异常", 501),
    JSON_PARSE_ERROR("JSON解析异常，请检查参数名或参数类型是否正确", 502),
    UPDATE_HOUSE_PRICE_FAIL("更新房源价格失败", 601);

    private String desc;
    private int value;

    ApiResultCodeEnum(String desc, int value){

        this.desc = desc;
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}
