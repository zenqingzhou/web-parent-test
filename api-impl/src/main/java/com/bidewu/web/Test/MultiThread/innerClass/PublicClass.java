package com.bidewu.web.Test.MultiThread.innerClass;

import lombok.Data;

/**
 * Created by zengqingzhou on 2019/6/18.
 */
@Data
public class PublicClass {
    private String username;
    private String password;
    @Data
    static class PrivateClass{
        private String age;
        private String address;
    }
}
