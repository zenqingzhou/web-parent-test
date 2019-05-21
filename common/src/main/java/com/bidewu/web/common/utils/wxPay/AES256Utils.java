package com.bidewu.web.common.utils.wxPay;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class AES256Utils {

    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

    /**
     * 解密
     *            待解密内容
     * @return
     */
    public static byte[] decrypt(byte[] data,String KEY) throws Exception {

        Key k = toKey(KEY.getBytes());

        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, k);

        return cipher.doFinal(data);
    }

    private static Key toKey(byte[] key) throws Exception {

        SecretKey secretKey = new SecretKeySpec(key, "AES/ECB/PKCS5Padding");

        return secretKey;
    }
}
