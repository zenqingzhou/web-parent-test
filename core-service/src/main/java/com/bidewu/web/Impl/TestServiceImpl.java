package com.bidewu.web.Impl;

import com.bidewu.web.TestService;
import com.bidewu.web.common.utils.redis.RedisSession;
import com.bidewu.web.dao.entity.Api;
import com.bidewu.web.dao.mapper.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Integer queryJson(Integer id) {
        Api api = new Api();
        api.setJdoc(1);
        apiMapper.insertSelective(api);

//        if (id != 1){
//            throw new BaseException(1,"异常测试");
//        }
//        if (redisSession.exists(String.valueOf(id))){
//            return JSON.parseObject(redisSession.getValue(String.valueOf(id)));
//        }
//        Page<Object> objects = PageHelper.startPage(-1, 0);
//        ApiExample apiExample = new ApiExample();
//        ApiExample.Criteria criteria = apiExample.createCriteria();
//        criteria.andIdEqualTo(id);
//        List<Api> apis = apiMapper.selectByExample(apiExample);
//        Api api = apis.get(0);
//        Object jdoc = api.getJdoc();
//        redisSession.set(String.valueOf(id),JSON.toJSONString(jdoc));
//        String result = JSON.toJSONString(jdoc);
        return api.getId();
    }

    @Override
    public String esTest() {
        return null;
    }


}
