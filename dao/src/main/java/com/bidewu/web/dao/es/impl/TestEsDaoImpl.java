package com.bidewu.web.dao.es.impl;

import com.bidewu.web.dao.es.TestEsDao;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zengqingzhou on 2019/5/24.
 */
public class TestEsDaoImpl implements TestEsDao {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public SearchResponse esTest() {
        return null;
    }
}
