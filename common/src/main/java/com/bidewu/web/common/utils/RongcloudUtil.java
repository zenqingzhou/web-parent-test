//package com.bidewu.web.common.utils;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.commons.codec.binary.Hex;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.ByteArrayOutputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.*;
//import java.security.MessageDigest;
//import java.util.Objects;
//
//@Component
//public class RongcloudUtil {
//    private static String appKey;
//
//    @Value("${rongyun.app_key}")
//    public void setAppKey(String v) {
//        appKey = v;
//    }
//
//    private static String appSecret;
//
//    @Value("${rongyun.app_secret}")
//    public void setAppSecret(String a) {
//        appSecret = a;
//    }
//
//    public static String imgPath;
//
//    @Value("${qiniu.img.path}")
//    public void setImgPath(String i) {
//        imgPath = i;
//    }
//
//
//    private static String hexSHA1(String value) {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-1");
//            md.update(value.getBytes("utf-8"));
//            byte[] digest = md.digest();
//            return String.valueOf(Hex.encodeHex(digest));
//        } catch (Exception ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    private static HttpURLConnection CreatePostHttpConnection(String appKey, String appSecret, String uri,
//                                                              String contentType) throws MalformedURLException, IOException, ProtocolException {
//        String nonce = String.valueOf(Math.random() * 1000000);
//        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
//        StringBuilder toSign = new StringBuilder(appSecret).append(nonce).append(timestamp);
//        String sign = hexSHA1(toSign.toString());
//        uri = "http://api.cn.ronghub.com" + uri;
//        URL url = new URL(uri);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setUseCaches(false);
//        conn.setDoInput(true);
//        conn.setDoOutput(true);
//        conn.setRequestMethod("POST");
//        conn.setInstanceFollowRedirects(true);
//        conn.setConnectTimeout(30000);
//        conn.setReadTimeout(30000);
//
//        conn.setRequestProperty("App-Key", appKey);
//        conn.setRequestProperty("Nonce", nonce);
//        conn.setRequestProperty("Timestamp", timestamp);
//        conn.setRequestProperty("Signature", sign);
//        conn.setRequestProperty("Content-Type", contentType);
//
//        return conn;
//    }
//
//    public static byte[] readInputStream(InputStream inStream) throws Exception {
//        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        int len = 0;
//        while ((len = inStream.read(buffer)) != -1) {
//            outStream.write(buffer, 0, len);
//        }
//        byte[] data = outStream.toByteArray();
//        outStream.close();
//        inStream.close();
//        return data;
//    }
//
//    public static String register(String userId, String name, String portraitUri) throws Exception {
//        if (Objects.equals(portraitUri, "")) {
//            portraitUri = "";
//        }
//        String body = "&userId=" + URLEncoder.encode(userId, "UTF-8") +
//                "&name=" + URLEncoder.encode(name, "UTF-8") +
//                "&portraitUri=" + URLEncoder.encode(portraitUri, "UTF-8");
//        if (body.indexOf("&") == 0) {
//            body = body.substring(1, body.length());
//        }
//
//        HttpURLConnection conn = CreatePostHttpConnection(appKey, appSecret, "/user/getToken.json", "application/x-www-form-urlencoded");
//
//        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
//        out.write(body.getBytes("utf-8"));
//        out.flush();
//        out.close();
//        int code = conn.getResponseCode();
//        InputStream input = null;
//        if (code == 200) {
//            input = conn.getInputStream();
//        } else {
//            input = conn.getErrorStream();
//        }
//        String result = new String(readInputStream(input), "UTF-8");
//        JSONObject aa = JSON.parseObject(result);
//        if (aa.get("token") != null && aa.get("token") != "") {
//            return aa.get("token").toString();
//        }
//        return "";
//    }
//
//    public static String refresh(String userId,String name,String portraitUri) throws Exception {
//        if (Objects.equals(portraitUri, "")){
//            portraitUri = "http://wap-qn.bidewu.com/morentouxiang1.jpg";
//        } else {
//            portraitUri =imgPath+portraitUri;
//        }
//
//
//
//        String body = "&userId=" + URLEncoder.encode(userId, "UTF-8") +
//                "&name=" + URLEncoder.encode(name, "UTF-8") +
//                "&portraitUri=" + URLEncoder.encode(portraitUri, "UTF-8");
//        if (body.indexOf("&") == 0) {
//            body = body.substring(1, body.length());
//        }
//
//        HttpURLConnection conn = CreatePostHttpConnection(appKey, appSecret, "/user/refresh.json", "application/x-www-form-urlencoded");
//
//        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
//        out.write(body.getBytes("utf-8"));
//        out.flush();
//        out.close();
//        int code = conn.getResponseCode();
//        InputStream input = null;
//        if (code == 200) {
//            return "ok";
//        }
//        return "";
//    }
//}