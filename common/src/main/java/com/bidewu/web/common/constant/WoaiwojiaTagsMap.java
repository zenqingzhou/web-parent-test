package com.bidewu.web.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuShoulei on 2017/12/26
 */
public class WoaiwojiaTagsMap {

    private static final Map<String, Integer> tagsMap;

    static {
        tagsMap = new HashMap<>();

        tagsMap.put("近地铁", 1);
        tagsMap.put("随时看", 3);
        tagsMap.put("满二年", 5);
        tagsMap.put("近公园", 2);
        tagsMap.put("满五年", 4);
        tagsMap.put("复式", 10);
        tagsMap.put("跃层", 11);
        tagsMap.put("loft", 12);
        tagsMap.put("隧道口", 13);
        tagsMap.put("单位房", 14);

        tagsMap.put("免佣", 15);
        tagsMap.put("可短租", 16);
        tagsMap.put("拎包入住", 17);
        tagsMap.put("集中供暖", 18);
    }

    public static Integer getHouseTagId(String name) {
        return tagsMap.get(name);
    }
}
