package com.bidewu.web.common.constant;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Constant {
    //客服表
    //1-城市账号，
    public static Short CustomerTypeOne = 1;
    //2-全国账号
    public static Short CustomerTypeTwo = 2;

    //所属层级(1-公司)
    public static Integer corpLeveOne = 1;
    //2-门店
    public static Integer corpLeveTwo = 2;

    //删除标志位（0-未删除，）
    public static Integer isDelOne = 1;
    //1-已删除
    public static Integer isDelTwo = 2;

    //账号状态：0-生效，
    public static Short statusNotFailure = 0;

    //1-未生效
    public static Short  statusFailure= 1;

    //sys_User 表
    //1-个人账户
    public static Short userTypeOne = 1;
    //   2-企业账户
    public static Short userTypeTwo = 2;
    //3-城市账户
    public static Short userTypeThird = 3;
    //4-全国账户
    public static Short userTypeFour = 4;

}
