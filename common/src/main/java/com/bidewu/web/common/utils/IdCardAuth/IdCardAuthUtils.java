package com.bidewu.web.common.utils.IdCardAuth;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class IdCardAuthUtils {

    private IdCardConfig idCardConfig;

    private static final Logger logger = LoggerFactory.getLogger(IdCardAuthUtils.class);

    public IdCardAuthUtils(IdCardConfig idCardConfig) {

        this.idCardConfig = idCardConfig;

    }

    public UserIdCardInfo idCardAuth(String base64Image) {

        String host = idCardConfig.getHost();
        String path = idCardConfig.getPath();
        String method = "POST";
        String appcode = idCardConfig.getAppcode();
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> map = new HashMap<>();
        map.put("image", base64Image);
        map.put("configure", "{\"side\":\"face\"}");
        try {
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, JSONObject.toJSONString(map));
            if (response.getStatusLine().getStatusCode() == 200) {
                String result = EntityUtil(response.getEntity());
                if (result!=null && result!="") {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    UserIdCardInfo userIdCardInfo = JSONObject.toJavaObject(jsonObject, UserIdCardInfo.class);
                    return userIdCardInfo;
                }
            } else {
                logger.error("lzr", "身份证请求失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String EntityUtil(HttpEntity entity) {
        InputStream inputStream = null;
        String result = "";
        try {
            inputStream = entity.getContent();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            String line = "";
            while (null != (line = bufferedReader.readLine())) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}