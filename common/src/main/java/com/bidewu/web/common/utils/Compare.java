package com.bidewu.web.common.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @ClassName Compare
 * @Author jiangweilong
 * @Date 2019/2/19 4:12 PM
 * @Description:
 **/
public class Compare {


    /**
     * 对比对象
     * @param class1
     * @param class2
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public static List<Map<String, Object>> compareTwoObject(Object class1, Object class2) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //获取对象的class
        Class<?> clazz1 = class1.getClass();
        Class<?> clazz2 = class2.getClass();
        //获取对象的属性列表
        Field[] field1 = clazz1.getDeclaredFields();
        Field[] field2 = clazz2.getDeclaredFields();
        //遍历属性列表field1
        for (int i = 0; i < field1.length; i++) {
            //遍历属性列表field2
            for (int j = 0; j < field2.length; j++) {
                //如果field1[i]属性名与field2[j]属性名内容相同
                if (field1[i].getName().equals(field2[j].getName())) {
                    field1[i].setAccessible(true);
                    field2[j].setAccessible(true);
                    //如果field1[i]属性值与field2[j]属性值内容不相同
                    if (!compareTwo(field1[i].get(class1), field2[j].get(class2))) {
                        Map<String, Object> map2 = new HashMap<String, Object>();
                        map2.put("name", field1[i].getName());
                        Object value1 = field1[i].get(class1);
                        Object value2 = field2[j].get(class2);

                        if (StringTool.isEmpty(value1)||StringTool.isEmpty(value2)||!value1.getClass().isArray()) {
                            map2.put("old", value1);
                            map2.put("new", value2);
                        } else {
                            Object[] arr1 = (Object[]) value1;
                            Object[] arr2 = (Object[]) value2;
                            map2.put("old", Arrays.toString(arr1));
                            map2.put("new", Arrays.toString(arr2));
                        }

                        list.add(map2);
                    }
                    break;
                }
            }
        }

        return list;
    }



    //对比两个数据是否内容相同
    public static boolean compareTwo(Object object1, Object object2) {

        if (object1 == null && object2 == null) {
            return true;
        }
        //以下注掉代码，看具体需求。因有时会出现源数据是没有进行赋值，因此是null；而通过EditText获取值的时候，虽然没有值，但是会变成""，但是本质是没有赋值的。
        //if (object1 == "" && object2 == null) {
        //    return true;
        //}
        //if (object1 == null && object2 == "") {
        //    return true;
        // }
        if (object1 == null && object2 != null) {
            return false;
        }
        if (object1.equals(object2)) {
            return true;
        }

        if (object1 instanceof String[]) {

            String[] s1 = (String[]) object1;
            String[] s2 = (String[]) object2;

            if (s1.length == s2.length) {

                for (int i = 0 ; i < s1.length; i ++) {

                    if (!s1[i].equals(s2[i])) {
                        return false;
                    }
                }
                return true;


            }


        }
        return false;
    }

}
