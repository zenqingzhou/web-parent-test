package com.bidewu.web.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bidewu.web.TestService;
import com.bidewu.web.common.exceptions.BaseException;
import com.bidewu.web.common.utils.redis.RedisSession;
import com.bidewu.web.dao.entity.Api;
import com.bidewu.web.dao.entity.ApiExample;
import com.bidewu.web.dao.mapper.ApiMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zengqingzhou on 2019/5/9.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private ApiMapper apiMapper;

    @Autowired
    private RedisSession redisSession;

    @Override
    public String queryText(String prams) {
        return "success: " + prams;
    }
    @Override
    public JSONObject queryJson(Integer id) {
        if (id != 1){
            throw new BaseException(1,"异常测试");
        }
        if (redisSession.exists(String.valueOf(id))){
            return JSON.parseObject(redisSession.getValue(String.valueOf(id)));
        }
        Page<Object> objects = PageHelper.startPage(-1, 0);
        ApiExample apiExample = new ApiExample();
        ApiExample.Criteria criteria = apiExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<Api> apis = apiMapper.selectByExample(apiExample);
        Api api = apis.get(0);
        Object jdoc = api.getJdoc();
        redisSession.set(String.valueOf(id),JSON.toJSONString(jdoc));
        String result = JSON.toJSONString(jdoc);
        return JSON.parseObject(result);
    }

    @Override
    public String esTest() {
        return null;
    }


}
