package com.bidewu.web.common.constant.proj;


import java.util.HashMap;
import java.util.Map;

/**
 * 物业类型对应名称
 */
public class PropertyTypeMap {
    private final static Map<Integer, String> propertyType2Name = new HashMap<>();

    static {
        propertyType2Name.put(1, "住宅");
        propertyType2Name.put(2, "别墅");
        propertyType2Name.put(3, "写字楼");
        propertyType2Name.put(4, "商铺");
        propertyType2Name.put(5, "底商");
        propertyType2Name.put(6, "住宅底商");
        propertyType2Name.put(7, "办公别墅");
        propertyType2Name.put(8, "标准写字楼");
        propertyType2Name.put(9, "酒店写字楼");
        propertyType2Name.put(10, "写字楼商铺");
        propertyType2Name.put(11, "市场类商铺");
        propertyType2Name.put(12, "商务型公寓");
        propertyType2Name.put(13, "购物中心");
        propertyType2Name.put(14, "企业独栋");
        propertyType2Name.put(15, "商业");
        propertyType2Name.put(16, "总部园区");
    }

    public static String getPropertyName(Integer propertyType) {
        return propertyType2Name.get(propertyType);
    }
}
