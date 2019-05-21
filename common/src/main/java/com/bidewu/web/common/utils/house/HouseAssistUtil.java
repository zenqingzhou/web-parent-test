package com.bidewu.web.common.utils.house;

/**
 * @author WuShoulei on 2018/4/1
 */
public class HouseAssistUtil {

    /**
     * 房源计算楼层高中低
     * @param floorNo
     * @param totalFloor
     * @return
     */
    public static String calculateFloorLevel(Integer floorNo, Integer totalFloor) {

        if (null != floorNo && null != totalFloor) {
            if (floorNo > 0 && totalFloor > 0) {
                double result = (double) floorNo/totalFloor;
                if (result <= (double) 1/3) {
                    return "低";
                } else if (result>(double)1/3 && result<=(double)2/3) {
                    return "中";
                } else {
                    return "高";
                }
            }
        }

        return null;
    }
}
