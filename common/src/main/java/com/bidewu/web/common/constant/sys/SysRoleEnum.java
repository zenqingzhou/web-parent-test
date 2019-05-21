package com.bidewu.web.common.constant.sys;


import com.bidewu.web.common.constant.base.IntBaseType;

/**
 * 用户角色枚举
 * @author WuShoulei on 2018/1/31
 */
public enum SysRoleEnum implements IntBaseType {

    COUNTRY_ADMINISTRATOR("全国管理员", 201),
    CITY_ADMINISTRATOR("城市管理员", 301),
    CORP_ADMINISTRATOR("经纪公司管理员", 401),
    AGENT_NO_PASS("免费版", 502),
//    AGENT_ID_PASS("身份认证通过和开通付费的经纪人", 504),
//    AGENT_ALL("全部认证都通过的经纪人",501),
    AGENT_SOLO("独立经纪人",505),
    AGENT_RENT("出租版", 508),
    AGENT_ORDINARY("普通版", 506),
    AGENT_STRENGTHEN("加强版", 507);


    private String desc;
    private int value;

    SysRoleEnum(String desc, int value) {
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