package com.bidewu.web.common.constant.datarule;


import com.bidewu.web.common.constant.base.IType;
import com.bidewu.web.common.constant.base.IntBaseType;

import java.util.Map;

public enum CustomerDataRuleEnum implements IntBaseType {
    Creator("自己创建的",0),
    Ltree("数据范围内的",1)
    ;

    private CustomerDataRuleEnum(String description, int value){

        this.desc = description;
        this.value = value;
    }


    private String desc;
    private int value;

    @Override
    public String getDesc() {
        return desc;
    }


    @Override
    public int getValue() {
        return value;
    }

    public static CustomerDataRuleEnum getEnum(int type) {
        return IType.get(type,CustomerDataRuleEnum.class);
    }
    public static CustomerDataRuleEnum getByStr(String desc) {
        return IType.get(desc,CustomerDataRuleEnum.class);
    }
    public static Map<String,Integer> getAll(){
        return IType.getAll(CustomerDataRuleEnum.class);
    }


}
