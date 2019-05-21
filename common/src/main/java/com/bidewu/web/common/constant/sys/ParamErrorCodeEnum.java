package com.bidewu.web.common.constant.sys;


import com.bidewu.web.common.constant.base.IntBaseType;

public enum ParamErrorCodeEnum implements IntBaseType {
    /**
     * 各种请求参数的错误类型
     */
    NOTNULL("参数不能为空",20101),
    ParaError("Argument-error|请求参数错误",10002),
    DATEPATTERN("日期格式不正确",20801),
    LACK_AGENT("该手机号无对应经纪人信息",20802),
    LACK_USER("该手机号无对应账户",20803),
    USER_IN_OPEN("该手机号已经开通付费",20804),
    OVER_LIMIT("超出推荐上限",20805),
    UPDATE_FAIL("修改失败",20806),
    STORE_NOT_EXIST("门店不存在",20807),
    STORE_NOT_BELONG("该门店不属于该经纪人所在的公司",20808),
    NO_IDCARDVERIFY("该经纪人未进行身份认证不能开通付费",20809),
    NO_PAYMENT("该经纪人未开通付费不能推优",20810),
    NEW_PHONE_EXIST("新手机号已存在",20811),
    NEW_PHONE_NOT_REGISTER("新手机号还未注册，请先注册",20814),
    NEW_PHONE_OPENED_PAY("新手机号已经开通付费了，请更换手机或关闭账户",20818),
    NEW_PHONE_PRE_OPEN("新手机号已申请预开通，请更换手机号",20816),
    OLD_PHONE_NOTEXIST("旧手机号不存在",20812),
    OLD_PHONE_XUFEE("原账户已开通续费，拒绝转移",20819),
    OLD_PHONE_NOT502("原账号未开通付费，不能转移",20815),
    NO_Reason("未定义的参数",20813),
    FICT_LOGIN_FAIL("虚拟能录失败",20817);
    private String desc;
    private int value;

    ParamErrorCodeEnum(String desc, int value) {
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
