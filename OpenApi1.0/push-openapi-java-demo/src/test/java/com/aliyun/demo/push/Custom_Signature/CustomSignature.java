package com.aliyun.demo.push.Custom_Signature;

import com.aliyuncs.utils.ParameterHelper;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * Created by lingbo on 16/11/7.
 */
public class CustomSignature {
    /**
     * 如果用户有自己的特殊应用场景,不适合使用SDK可以参考下面的demo自己组装HTTP请求 以ListTags接口为例,其它接口按要求构造相应的访问参数即可
     */
    @Test
    public void testCustomSignature() throws Exception {
        //构造访问参数
        SecureRandom random = new SecureRandom();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("Format", "XML");
        params.put("RegionId", "cn-hangzhou");
        params.put("Version", "2015-08-27");
        params.put("SignatureMethod", "HMAC-SHA1");
        params.put("Timestamp", ParameterHelper.getISO8601Time(new Date()));//生成ISO格式的时间戳
        params.put("SignatureVersion", "1.0");
        params.put("SignatureNonce", new BigInteger(32, random).toString(8));//生成随机字符串
        params.put("Action", "ListTags");
        params.put("AccessKeyId", "<Your AccessKey>");
        params.put("AppKey", "<Your AppKey>");
        //定义host并生成url
        String host = "http://cloudpush.aliyuncs.com";
        String request = request(host, params, "<Your SecretKey>");
        //发起请求并打印返回结果
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(request);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));
        try {
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }
            byte[] responseBody = method.getResponseBody();
            System.out.println(new String(responseBody));

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }

    //构造移动推送HTTP请求URL
    private static String request(String host, Map<String, Object> params, String secret) throws Exception {
        String params_string = "";
        List sortedKeys = new ArrayList(params.keySet());
        Collections.sort(sortedKeys);
        for (Object key : sortedKeys) {
            params_string += URLEncoder.encode(String.valueOf(key), "UTF-8") + "=" + URLEncoder.encode(String.valueOf(params.get(key)), "UTF-8") + "&";
        }
        String request = host + "/?" + params_string + "Signature=" + sign("GET", params, secret + "&");
        return request;
    }
    //构造签名
    private static String sign(String method, Map<String, Object> params, String secret) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String query_string = "";
        List sortedKeys = new ArrayList(params.keySet());
        Collections.sort(sortedKeys);
        for (Object key : sortedKeys) {
            query_string += '&' + popEncode(String.valueOf(key)) + '=' + popEncode(String.valueOf(params.get(key)));
        }
        String sign_to_string = method + "&%2F&" + popEncode(query_string.substring(1, query_string.length()));
        Mac e = Mac.getInstance("HmacSHA1");
        e.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA1"));
        byte[] signData = e.doFinal(sign_to_string.getBytes("UTF-8"));
        return (new BASE64Encoder()).encodeBuffer(signData);
    }
    //pop网管urlEncode
    private static String popEncode(String value) throws UnsupportedEncodingException {
        return value != null ? URLEncoder.encode(value, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~") : null;
    }
}
