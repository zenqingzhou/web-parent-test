package com.bidewu.web.common.utils.wxPay.WxPayConfig;

import com.alibaba.fastjson.JSON;
import com.bidewu.web.common.utils.wxPay.HttpUtil;
import com.bidewu.web.common.utils.wxPay.PayToolUtil;
import com.bidewu.web.common.utils.wxPay.RandomStringGenerator;
import com.bidewu.web.common.utils.wxPay.XMLUtil4jdom;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class WeiChartUtil {

    @Autowired
    private WxPayConfig wxPayConfig;

    public String getCodeUrl(HttpServletRequest request, Map<String, String> map) {
        try {
            // 账号信息
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            packageParams.put("appid", wxPayConfig.getAPP_ID());
            packageParams.put("mch_id", wxPayConfig.getMCH_ID());
            packageParams.put("nonce_str", RandomStringGenerator.getRandomStringByLength(30));
            packageParams.put("body", map.get("body"));  //（调整为自己的名称）
            packageParams.put("out_trade_no", map.get("productId"));
            packageParams.put("total_fee", map.get("total_fee")); //价格的单位为分
            packageParams.put("spbill_create_ip", getIpAddr(request));
            packageParams.put("notify_url", wxPayConfig.getNotifyUrl());
            packageParams.put("trade_type", "NATIVE");
            //设置交易开始时间
            packageParams.put("time_start", map.get("time_start"));
            packageParams.put("time_expire", map.get("time_expire"));
            //设置签名
            String sign = PayToolUtil.createSign("UTF-8", packageParams, wxPayConfig.getMCH_KEY());
            packageParams.put("sign", sign);
            String requestXML = PayToolUtil.getRequestXml(packageParams);
            String resXml = HttpUtil.postData(WxPayUrl.unifiedOrderUrl, requestXML);
            Map ma = XMLUtil4jdom.doXMLParse(resXml);
            String urlCode = (String) ma.get("code_url");
            return urlCode;
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询订单
     * @return
     */
    public Map getOrderquery(Map<String, String> map) {
        try {
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            packageParams.put("appid", wxPayConfig.getAPP_ID());
            packageParams.put("mch_id", wxPayConfig.getMCH_ID());
            packageParams.put("nonce_str", RandomStringGenerator.getRandomStringByLength(30));
            packageParams.put("out_trade_no", map.get("productId"));
            String sign = PayToolUtil.createSign("UTF-8", packageParams, wxPayConfig.getMCH_KEY());
            packageParams.put("sign", sign);
            String requestXML = PayToolUtil.getRequestXml(packageParams);
            String resXml = HttpUtil.postData(WxPayUrl.orderQueryUrl, requestXML);
            return XMLUtil4jdom.doXMLParse(resXml);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用关单接口：
     *
     * @return
     */
    public Map closeOrder(Map<String, String> map) {
        try {
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            packageParams.put("appid", wxPayConfig.getAPP_ID());
            packageParams.put("mch_id", wxPayConfig.getMCH_ID());
            packageParams.put("nonce_str", RandomStringGenerator.getRandomStringByLength(30));
            packageParams.put("out_trade_no", map.get("productId"));
            String sign = PayToolUtil.createSign("UTF-8", packageParams, wxPayConfig.getMCH_KEY());
            packageParams.put("sign", sign);

            String requestXML = PayToolUtil.getRequestXml(packageParams);
            String resXml = HttpUtil.postData(WxPayUrl.closeOrderUrl, requestXML);
            return XMLUtil4jdom.doXMLParse(resXml);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 退款
     * @return
     */
    public Map refund(Map<String, Object> map) {
        try {
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            packageParams.put("appid", wxPayConfig.getAPP_ID());
            packageParams.put("mch_id", wxPayConfig.getMCH_ID());
            packageParams.put("nonce_str", RandomStringGenerator.getRandomStringByLength(30));
            packageParams.put("out_refund_no", map.get("out_refund_no"));
            packageParams.put("out_trade_no", map.get("out_refund_no"));
            packageParams.put("refund_fee", map.get("refund_fee"));
            packageParams.put("total_fee", map.get("total_fee"));
            String sign = PayToolUtil.createSign("UTF-8", packageParams, wxPayConfig.getMCH_KEY());
            packageParams.put("sign", sign);
            /**
             * 验证证书
             */
            HttpClient httpClient = checkMchCert(packageParams);
            String requestXML = PayToolUtil.getRequestXml(packageParams);
            HttpPost httpPost = new HttpPost(WxPayUrl.refundUrl);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(8 * 1000).setConnectTimeout(6 * 1000).build();
            httpPost.setConfig(requestConfig);
            StringEntity postEntity = new StringEntity(requestXML, "UTF-8");
            httpPost.addHeader("Content-Type", "text/xml");
            // TODO: 很重要，用来检测 sdk 的使用情况，要不要加上商户信息？
            httpPost.addHeader("User-Agent", "wxpay sdk java v1.0 " + wxPayConfig.getMCH_ID());
            httpPost.setEntity(postEntity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
            Map mapType = JSON.parseObject(jsonStr, Map.class);
            return mapType;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询退款
     *
     * @return
     */
    public Map refundQuery(Map<String, Object> map) {
        try {
            SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
            packageParams.put("appid", wxPayConfig.getAPP_ID());
            packageParams.put("mch_id", wxPayConfig.getMCH_ID());
            packageParams.put("nonce_str", RandomStringGenerator.getRandomStringByLength(30));
            packageParams.put("out_refund_no", map.get("out_refund_no"));
            String sign = PayToolUtil.createSign("UTF-8", packageParams, wxPayConfig.getMCH_KEY());
            packageParams.put("sign", sign);
            String requestXML = PayToolUtil.getRequestXml(packageParams);
            String resXml = HttpUtil.postData(WxPayUrl.refundQueryUrl, requestXML);
            return XMLUtil4jdom.doXMLParse(resXml);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载账单
     *
     * @param map
     * @return
     */
    public Map<String, String> downLoadBill(SortedMap<Object, Object> map) {
        try {
            map.put("appid", wxPayConfig.getAPP_ID());
            map.put("mch_id", wxPayConfig.getMCH_ID());
            map.put("nonce_str", RandomStringGenerator.getRandomStringByLength(30));
            String sign = PayToolUtil.createSign("UTF-8", map, wxPayConfig.getMCH_KEY());
            map.put("sign", sign);
            String requestXML = PayToolUtil.getRequestXml(map);
            String resXml = HttpUtil.postData(WxPayUrl.downLoadBillUrl, requestXML);
            return XMLUtil4jdom.doXMLParse(resXml);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 下载资金账单
     *
     * @param map
     * @return
     */
    public Map<String, String> downloadfundflow(SortedMap<Object, Object> map) {

        try {
            map.put("appid", wxPayConfig.getAPP_ID());
            map.put("mch_id", wxPayConfig.getMCH_ID());
            map.put("nonce_str", RandomStringGenerator.getRandomStringByLength(30));
            String sign = PayToolUtil.createSign("UTF-8", map, wxPayConfig.getMCH_KEY());
            map.put("sign", sign);
            //检查证书
            HttpClient httpClient = checkMchCert(map);
            String requestXML = PayToolUtil.getRequestXml(map);
            HttpPost httpPost = new HttpPost(WxPayUrl.downLoadFundFlowUrl);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(8 * 1000).setConnectTimeout(6 * 1000).build();
            httpPost.setConfig(requestConfig);
            StringEntity postEntity = new StringEntity(requestXML, "UTF-8");
            httpPost.addHeader("Content-Type", "text/xml");
            // TODO: 很重要，用来检测 sdk 的使用情况，要不要加上商户信息？
            httpPost.addHeader("User-Agent", "wxpay sdk java v1.0 " + wxPayConfig.getMCH_ID());
            httpPost.setEntity(postEntity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
            Map mapType = JSON.parseObject(jsonStr, Map.class);
            return mapType;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验证证书
     *
     * @param packageParams
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws KeyManagementException
     * @throws IOException
     */
    private HttpClient checkMchCert(SortedMap<Object, Object> packageParams) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, KeyManagementException, IOException {
        //初始化证书
        KeyStore keystore = initSSLContext();
        String requestXML = PayToolUtil.getRequestXml(packageParams);
        // 实例化密钥库 & 初始化密钥工厂
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keystore, wxPayConfig.getMCH_ID().toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null,
                new DefaultHostnameVerifier());
        BasicHttpClientConnectionManager connManager = new BasicHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", sslConnectionSocketFactory)
                        .build(),
                null,
                null,
                null);
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();

        return httpClient;
    }

    /**
     * 初始化证书
     *
     * @return
     */
    public KeyStore initSSLContext() {
        FileInputStream inputStream = null;
        KeyStore keystore = null;
        try {
            inputStream = new FileInputStream(new File(wxPayConfig.getMCH_PATH()));
        } catch (IOException e) {
            throw new RuntimeException("读取微信商户证书文件出错", e);
        }
        try {
            keystore = KeyStore.getInstance("PKCS12");
            char[] partnerId2charArray = wxPayConfig.getMCH_ID().toCharArray();
            keystore.load(inputStream, partnerId2charArray);
            return keystore;
        } catch (Exception e) {
            throw new RuntimeException("证书文件有问题，请核实！", e);
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }


    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
