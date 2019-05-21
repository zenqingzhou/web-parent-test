package com.bidewu.web;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zengqingzhou on 2019/5/9.
 */
public interface TestService {

    String queryText(String prams);

    JSONObject queryJson(Integer id);
}
