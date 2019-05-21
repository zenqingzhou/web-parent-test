package com.bidewu.web.common.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.UnsupportedEncodingException;


public class HmacCheck {

    /**
     * 签名校验
     * @param data
     * @param key
     * @return
     */
    public static String checkSign(String data,String key){

        byte[] bytes = new byte[0];
        try {
            bytes = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_1,key.getBytes("UTF-8")).doFinal(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        Base64 base64=new Base64(true);

//        return base64.encodeToString(bytes);
        return new Hex().encodeHexString(bytes);
    }
}
