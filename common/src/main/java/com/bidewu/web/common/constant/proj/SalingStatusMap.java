package com.bidewu.web.common.constant.proj;

import java.util.HashMap;
import java.util.Map;

/**
 * 销售状态
 */
public class SalingStatusMap {
    private final static Map<Integer, String> Saling2Status = new HashMap<>();

    static {
        Saling2Status.put(0, "售完");
        Saling2Status.put(1, "在售");
        Saling2Status.put(2, "不在售");
        Saling2Status.put(3, "出租");
        Saling2Status.put(4, "租售");
        Saling2Status.put(5, "待售");
        Saling2Status.put(6, "待租");
    }

    public static String getSalingStatus(Integer saling) {
        return Saling2Status.get(saling);
    }
}
