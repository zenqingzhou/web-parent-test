package com.bidewu.web.dao.mapper;

import com.bidewu.web.dao.entity.Api;
import com.bidewu.web.dao.entity.ApiExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiMapper{
    int countByExample(ApiExample example);

    int insert(Api record);

    int insertSelective(Api record);

    List<Api> selectByExample(ApiExample example);

    int updateByExampleSelective(@Param("record") Api record, @Param("example") ApiExample example);

    int updateByExample(@Param("record") Api record, @Param("example") ApiExample example);

    Api insertTest(@Param("jdoc") Object jdoc);
}