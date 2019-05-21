package com.bidewu.web.common.extension.mybatis.typehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  wangzw
 * @create  2018/3/5 11:47
 * @desc
 **/
public class JsonTypeHandler extends BaseTypeHandler<Object> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,Object parameter, JdbcType jdbcType) throws SQLException {

        if(parameter instanceof List){
            List paraList = (List) parameter;
            String paraJson = JSON.toJSONString(paraList);
            ps.setString(i,paraJson);
        }else{
            List<Object> objects = new ArrayList<>();
            objects.add(parameter);
            String jsonString = JSON.toJSONString(objects);
            ps.setString(i,jsonString);
        }
    }
    private Object getObject(String jsonString){
        Object object = JSONArray.parseObject(jsonString, Object.class);
        return object;
    }
    @Override
    public Object getNullableResult(ResultSet rs, String columnName) throws SQLException {
        ;
        return getObject(rs.getString(columnName));
    }

    @Override
    public Object getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getObject(rs.getNString(columnIndex));
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getObject(cs.getString(columnIndex));
    }
}
