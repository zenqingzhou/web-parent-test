package com.bidewu.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.bidewu.web.TestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by zengqingzhou on 2019/5/9.
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/")
    public String queryText(Integer id){
        return testService.queryText("nice");
    }

    @ApiOperation(value = "测试1", nickname = "测试别名", response = JSONObject.class, tags = {"测试"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = JSONObject.class),
            @ApiResponse(code = 201, message = "Created", response = JSONObject.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @GetMapping(value = "/queryJson",produces = {"application/json"})
    public JSONObject queryJson(@ApiParam(value = "id",required = true) @Valid @RequestParam(value = "id") Integer id){
        return testService.queryJson(id);
    }
}
