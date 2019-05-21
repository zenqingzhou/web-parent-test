package com.bidewu.web.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 城市Map
 * @author WuShoulei on 2017/12/25
 */
public class CityMap {

    private static final Map<String, Integer> cityMap;

    static {
        cityMap = new HashMap<>();
        /**
         * 石家庄
         */
        cityMap.put("sjz", 1);
        /**
         * 北京
         */
        cityMap.put("bj", 12);
        /**
         * 上海
         */
        cityMap.put("sh", 13);
        /**
         * 天津
         */
        cityMap.put("tj", 14);
        /**
         * 重庆
         */
        cityMap.put("cq", 15);
        /**
         * 广州
         */
        cityMap.put("gz", 16);
        /**
         * 深圳
         */
        cityMap.put("sz", 17);
        /**
         * 珠海
         */
        cityMap.put("zh", 18);
        /**
         * 惠州
         */
        cityMap.put("huizhou", 23);
        /**
         * 东莞
         */
        cityMap.put("dg", 24);
        /**
         * 杭州
         */
        cityMap.put("hz", 26);
        /**
         * 成都
         */
        cityMap.put("cd", 45);
        /**
         * 沈阳
         */
        cityMap.put("sy", 55);
        /**
         * 大连
         */
        cityMap.put("dl", 56);
        /**
         * 南京
         */
        cityMap.put("nj", 65);
        /**
         * 无锡
         */
        cityMap.put("wuxi", 66);
        /**
         * 苏州
         */
        cityMap.put("suzhou", 67);
        /**
         * 福州
         */
        cityMap.put("fz", 75);
        /**
         * 长春
         */
        cityMap.put("changchun", 84);
        /**
         * 郑州
         */
        cityMap.put("zz", 103);
        /**
         * 济南
         */
        cityMap.put("jn", 113);
        /**
         * 青岛
         */
        cityMap.put("qd", 114);
        /**
         * 烟台
         */
        cityMap.put("yt", 118);
        /**
         * 合肥
         */
        cityMap.put("hf", 123);
        /**
         * 南宁
         */
        cityMap.put("nn", 142);
        /**
         * 海口
         */
        cityMap.put("haikou", 143);
        /**
         * 三亚
         */
        cityMap.put("sanya", 144);
        /**
         * 太原
         */
        cityMap.put("ty", 155);
        /**
         * 西安
         */
        cityMap.put("xian", 176);
        /**
         * 武汉
         */
        cityMap.put("wh", 194);
        /**
         * 长沙
         */
        cityMap.put("cs", 204);
        /**
         * 南昌
         */
        cityMap.put("nc", 214);
    }

    public static Integer getCityId(String city) {

        Integer cityId = cityMap.get(city);

        if (null == cityId) {
            cityId = 12;
        }
        return cityId;
    }
}
