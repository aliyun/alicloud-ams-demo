package com.aliyun.demo.push;

import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.push.model.v20150827.*;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.fail;

/**
 * 推送的OpenAPI文档 https://help.aliyun.com/document_detail/30074.html
 */
public class PushDemoTest extends BaseTest {
    /**
     * 推送通知给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/30082.html
     */
    @Test
    public void testPushNoticeToAndroid_toAll() throws Exception {
        PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
        //推送内容需要保护，请使用HTTPS协议
        androidRequest.setProtocol(ProtocolType.HTTPS);
        //推送内容较长，请使用POST请求
        androidRequest.setMethod(MethodType.POST);
        androidRequest.setAppKey(appKey);
        androidRequest.setTarget("all");
        androidRequest.setTargetValue("all");
        androidRequest.setTitle("Hello OpenAPI!");
        androidRequest.setSummary("你好, PushNoticeToAndroid from OpenAPI!");
        androidRequest.setAndroidExtParameters("{\"key1\":\"value1\",\"api_name\":\"PushNoticeToAndroidRequest\"}");

        PushNoticeToAndroidResponse pushNoticeToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushNoticeToAndroidResponse.getRequestId(), pushNoticeToAndroidResponse.getResponseId());
    }

    /**
     * 推送通知给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/30082.html
     */
    @Test
    public void testPushNoticeToAndroid_toDevice() throws Exception {
        if (deviceIds.startsWith("_YOUR")) {
            fail("先在 push.properties 配置文件中配置 deviceIds");
        }

        PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
        //推送内容需要保护，请使用HTTPS协议
        androidRequest.setProtocol(ProtocolType.HTTPS);
        //推送内容较长，请使用POST请求
        androidRequest.setMethod(MethodType.POST);
        androidRequest.setAppKey(appKey);
        androidRequest.setTarget("device");
        androidRequest.setTargetValue(deviceIds);
        androidRequest.setTitle("Hello OpenAPI!");
        androidRequest.setSummary("你好, PushNoticeToAndroid from OpenAPI!");

        PushNoticeToAndroidResponse pushNoticeToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushNoticeToAndroidResponse.getRequestId(), pushNoticeToAndroidResponse.getResponseId());
    }

    /**
     * 推送通知给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/30082.html
     */
    @Test
    public void testPushNoticeToAndroid_toAccount() throws Exception {
        if (accounts.startsWith("_YOUR")) {
            fail("先在 push.properties 配置文件中配置 accounts");
        }

        PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
        //推送内容需要保护，请使用HTTPS协议
        androidRequest.setProtocol(ProtocolType.HTTPS);
        //推送内容较长，请使用POST请求
        androidRequest.setMethod(MethodType.POST);
        androidRequest.setAppKey(appKey);
        androidRequest.setTarget("account");
        androidRequest.setTargetValue(accounts);
        androidRequest.setTitle("Hello OpenAPI!");
        androidRequest.setSummary("你好, PushNoticeToAndroid from OpenAPI!");

        PushNoticeToAndroidResponse pushNoticeToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushNoticeToAndroidResponse.getRequestId(), pushNoticeToAndroidResponse.getResponseId());
    }

    /**
     * 推送消息给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/30081.html
     */
    @Test
    public void testPushMessageToAndroid_toAll() throws Exception {
        PushMessageToAndroidRequest androidRequest = new PushMessageToAndroidRequest();
        //推送内容需要保护，请使用HTTPS协议
        androidRequest.setProtocol(ProtocolType.HTTPS);
        //推送内容较长，请使用POST请求
        androidRequest.setMethod(MethodType.POST);
        androidRequest.setAppKey(appKey);
        androidRequest.setTarget("all");
        androidRequest.setTargetValue("all");
        androidRequest.setMessage("PushMessageToAndroid from OpenAPI!");

        PushMessageToAndroidResponse pushMessageToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushMessageToAndroidResponse.getRequestId(), pushMessageToAndroidResponse.getResponseId());
    }

    /**
     * 推送通知给iOS
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/30084.html
     */
    @Test
    public void testPushNoticeToIOS_toAll() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");

        PushNoticeToiOSRequest iOSRequest = new PushNoticeToiOSRequest();
        //推送内容需要保护，请使用HTTPS协议
        iOSRequest.setProtocol(ProtocolType.HTTPS);
        //推送内容较长，请使用POST请求
        iOSRequest.setMethod(MethodType.POST);
        iOSRequest.setAppKey(appKey);
        // iOS的通知是通过APNS中心来发送的，需要填写对应的环境信息. DEV:表示开发环境, PRODUCT: 表示生产环境
        iOSRequest.setEnv("DEV");
        iOSRequest.setTarget("all");
        iOSRequest.setTargetValue("all");
        iOSRequest.setSummary(dateFormat.format(new Date()));
        iOSRequest.setiOSExtParameters("{\"k1\":\"v1\",\"k2\":\"v2\"}");
        iOSRequest.setExt("{\"sound\":\"default\", \"badge\":\"42\"}");

        PushNoticeToiOSResponse pushNoticeToiOSResponse = client.getAcsResponse(iOSRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushNoticeToiOSResponse.getRequestId(), pushNoticeToiOSResponse.getResponseId());
    }

    /**
     * 推送消息给iOS
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/30083.html
     */
    @Test
    public void testPushMessageToIOS_toAll() throws Exception {
        PushMessageToiOSRequest iOSRequest = new PushMessageToiOSRequest();
        //推送内容需要保护，请使用HTTPS协议
        iOSRequest.setProtocol(ProtocolType.HTTPS);
        //推送内容较长，请使用POST请求
        iOSRequest.setMethod(MethodType.POST);
        iOSRequest.setAppKey(appKey);
        iOSRequest.setAppKey(appKey);
        iOSRequest.setTarget("all");
        iOSRequest.setTargetValue("all");
        iOSRequest.setMessage("message");
        iOSRequest.setSummary("summary");

        PushMessageToiOSResponse pushMessageToiOSResponse = client.getAcsResponse(iOSRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushMessageToiOSResponse.getRequestId(), pushMessageToiOSResponse.getResponseId());
    }
}
