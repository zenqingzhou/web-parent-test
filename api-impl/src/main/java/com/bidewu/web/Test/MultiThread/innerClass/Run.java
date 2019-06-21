package com.bidewu.web.Test.MultiThread.innerClass;

/**
 * Created by zengqingzhou on 2019/6/18.
 */
public class Run {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        publicClass.setUsername("usernameValue");
        publicClass.setPassword("passwordValue");
        System.out.println(publicClass.getUsername()+" "+publicClass.getPassword());

        PublicClass.PrivateClass privateClass = new PublicClass.PrivateClass();
        privateClass.setAddress("aa");
        privateClass.setAge("11");
        System.out.println(privateClass.getAddress()+" "+privateClass.getAge());

    }
}
