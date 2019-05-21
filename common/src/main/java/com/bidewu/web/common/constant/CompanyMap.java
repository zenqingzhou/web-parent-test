package com.bidewu.web.common.constant;


import com.bidewu.web.common.api.rent.HouseImportApiConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介公司中英文对照
 * @author WuShoulei on 2017/12/25
 */
public class CompanyMap {

    private static final Map<String, String> companyMap;

    static {
        companyMap = new HashMap<>();
        companyMap.put(HouseImportApiConstant.COMPANY_CENTANET, "中原地产");
        companyMap.put(HouseImportApiConstant.COMPANY_5I5J, "我爱我家");
        companyMap.put(HouseImportApiConstant.COMPANY_TUITUI99, "麦田房产");
        companyMap.put(HouseImportApiConstant.COMPANY_MAITIAN, "麦田房产");
        companyMap.put(HouseImportApiConstant.COMPANY_XIANGYU, "相寓");
        companyMap.put(HouseImportApiConstant.COMPANY_MGZF, "蘑菇租房");
        companyMap.put(HouseImportApiConstant.COMPANY_HEZUQU, "合租趣");
        companyMap.put(HouseImportApiConstant.COMPANY_HUIZHAOFANG, "会找房");
        companyMap.put(HouseImportApiConstant.COMPANY_QFANG, "Q房网");
        companyMap.put(HouseImportApiConstant.COMPANY_QIAOFANG, "巧房网");
        companyMap.put(HouseImportApiConstant.COMPANY_CENTURY21, "21世纪");
        companyMap.put(HouseImportApiConstant.COMPANY_IGUANYU, "龙湖冠寓");
        companyMap.put(HouseImportApiConstant.COMPANY_IHK, "合富置业");
        companyMap.put(HouseImportApiConstant.COMPANY_PACIFIC, "太平洋房屋");
        companyMap.put(HouseImportApiConstant.COMPANY_JINLEJIA, "金乐家");
        companyMap.put(HouseImportApiConstant.COMPANY_ZHDCLINK, "中环地产");
        companyMap.put(HouseImportApiConstant.COMPANY_UJUZ, "优居网");
        companyMap.put(HouseImportApiConstant.COMPANY_DAOJIALE, "到家了");
        companyMap.put(HouseImportApiConstant.COMPANY_HIZHU, "嗨住");
        companyMap.put(HouseImportApiConstant.COMPANY_MEILIWU, "美丽屋");

    }

    public static String getCNCompany(String enCompany) {
        return companyMap.get(enCompany);
    }
}
