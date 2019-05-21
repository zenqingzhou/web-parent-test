package com.bidewu.web.common.constant.auth;


import java.util.ArrayList;
import java.util.List;

public class LeftMenu {
    private static final Integer code = 0;
    private static final String msg = "";
    private static final List<Menuf> data = new ArrayList();
    static {
        List<Menu> centerList = new ArrayList<>();
        centerList.add(new Menu("mydata","我的资料"));
        centerList.add(new Menu("modifypassword","修改密码"));
        centerList.add(new Menu("authentication","我的认证"));
        Menus center = new Menus("center","个人中心",centerList);

        Menu shopsetting = new Menu("shopsetting", "店铺设置");

        List<Menu> myresourceList = new ArrayList<>();
        myresourceList.add(new Menu("manrent","管理出租"));
        myresourceList.add(new Menu("mansell","管理出售"));
        myresourceList.add(new Menu("inputrent","录入出租"));
        myresourceList.add(new Menu("inputsell","录入出售"));
        Menus myresource = new Menus("myresource","我的房源",myresourceList);

        List personalList = new ArrayList<>();
        personalList.add(center);
        personalList.add(shopsetting);
        personalList.add(myresource);
        data.add(new Menuf("persional","个人平台",personalList,"layui-icon-component"));
    }
    public static Integer getCode(){
        return code;
    }
    public static String getMsg(){
        return msg;
    }
    public static List getList(){
        return data;
    }


}
