package com.aliyun.push.demoTest;

import com.aliyuncs.push.model.v20160801.*;
import com.aliyuncs.utils.ParameterHelper;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lingbo on 16/8/15.
 */
public class PushTest extends BaseTest {


    /**
     * 推送通知给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/notice-to-android.html
     */
    @Test
    public void testPushMessageToAndroid() throws Exception {

        PushMessageToAndroidRequest androidRequest = new PushMessageToAndroidRequest();
        androidRequest.setAppKey(appKey);
        androidRequest.setTarget("ALL");
        androidRequest.setTargetValue("ALL");
        androidRequest.setTitle("66666666666");
        androidRequest.setBody("6");
        PushMessageToAndroidResponse pushMessageToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, MessageId: %d\n",
                pushMessageToAndroidResponse.getRequestId(), pushMessageToAndroidResponse.getMessageId());

    }

    /**
     * 推送通知给android
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/notice-to-android.html
     */
    @Test
    public void testPushNoticeToAndroid() throws Exception {

        PushNoticeToAndroidRequest androidRequest = new PushNoticeToAndroidRequest();
        androidRequest.setAppKey(appKey);
        androidRequest.setTarget("TAG");
        androidRequest.setTargetValue("tag1");
        androidRequest.setTitle("title");
        androidRequest.setBody("Body");
        androidRequest.setExtParameters("{\"k1\":\"v1\"}");

        PushNoticeToAndroidResponse pushNoticeToAndroidResponse = client.getAcsResponse(androidRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushNoticeToAndroidResponse.getRequestId(), pushNoticeToAndroidResponse.getMessageId());

    }
    /**
     * 推送消息给iOS
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/message-to-ios.html
     */
    @Test
    public void testPushMessageToIOS() throws Exception {
        PushMessageToiOSRequest iOSRequest = new PushMessageToiOSRequest();
        iOSRequest.setAppKey(appKey);
        iOSRequest.setTarget("DEVICE");
        iOSRequest.setTargetValue(deviceIds);
        iOSRequest.setTitle("title");
        iOSRequest.setBody("body");


        PushMessageToiOSResponse pushMessageToiOSResponse = client.getAcsResponse(iOSRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushMessageToiOSResponse.getRequestId(), pushMessageToiOSResponse.getMessageId());
    }

    /**
     * 推送通知给iOS
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/notice-to-ios.html
     */
    @Test
    public void testPushNoticeToIOS_toAll() throws Exception {

        PushNoticeToiOSRequest iOSRequest = new PushNoticeToiOSRequest();
        iOSRequest.setAppKey(appKey);
        // iOS的通知是通过APNS中心来发送的，需要填写对应的环境信息. DEV :表示开发环境, PRODUCT: 表示生产环境
        iOSRequest.setApnsEnv("PRODUCT");
        iOSRequest.setTarget("DEVICE");
        iOSRequest.setTargetValue("e24155d9f3db4e3791e5444d737c81db");
        //iOSRequest.setTitle("eewwewe");
        iOSRequest.setBody("Body");
        iOSRequest.setExtParameters("{\"k1\":\"v1\",\"k2\":\"v2\"}");


        PushNoticeToiOSResponse pushNoticeToiOSResponse = client.getAcsResponse(iOSRequest);
        System.out.printf("RequestId: %s, MessageId: %s\n",
                pushNoticeToiOSResponse.getRequestId(), pushNoticeToiOSResponse.getMessageId());
    }
    /**
     * 推送高级接口
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/push-advanced.html
     * //
     */
    @Test
    public void testAdvancedPush() throws Exception {

        PushRequest pushRequest = new PushRequest();
        // 推送目标
        pushRequest.setAppKey(appKey);
        pushRequest.setTarget("DEVICE"); //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
        pushRequest.setTargetValue(deviceIds); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
//        pushRequest.setTarget("ALL"); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
//        pushRequest.setTargetValue("ALL"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setPushType("NOTICE"); // 消息类型 MESSAGE NOTICE
        pushRequest.setDeviceType("ALL"); // 设备类型 ANDROID iOS ALL.


        // 推送配置
        pushRequest.setTitle("ALi Push Title"); // 消息的标题
        pushRequest.setBody("Ali Push Body"); // 消息的内容

        // 推送配置: iOS
        pushRequest.setiOSBadge(5); // iOS应用图标右上角角标
        pushRequest.setiOSMusic("default"); // iOS通知声音
        pushRequest.setiOSSubtitle("iOS10 subtitle");//iOS10通知副标题的内容
        pushRequest.setiOSNotificationCategory("iOS10 Notification Category");//指定iOS10通知Category
        pushRequest.setiOSMutableContent(true);//是否允许扩展iOS通知内容
        pushRequest.setiOSApnsEnv("DEV");//iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
        pushRequest.setiOSRemind(true); // 消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
        pushRequest.setiOSRemindBody("iOSRemindBody");//iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
        pushRequest.setiOSExtParameters("{\"_ENV_\":\"DEV\",\"k2\":\"v2\"}"); //通知的扩展属性(注意 : 该参数要以json map的格式传入,否则会解析出错)
        // 推送配置: Android
        pushRequest.setAndroidNotifyType("NONE");//通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
        pushRequest.setAndroidNotificationBarType(1);//通知栏自定义样式0-100
        pushRequest.setAndroidNotificationBarPriority(1);//通知栏自定义样式0-100
        pushRequest.setAndroidOpenType("URL"); //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
        pushRequest.setAndroidOpenUrl("http://www.aliyun.com"); //Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
        pushRequest.setAndroidActivity("com.alibaba.push2.demo.XiaoMiPushActivity"); // 设定通知打开的activity，仅当AndroidOpenType="Activity"有效
        pushRequest.setAndroidMusic("default"); // Android通知音乐
        pushRequest.setAndroidXiaoMiActivity("com.ali.demo.MiActivity");//设置该参数后启动小米托管弹窗功能, 此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 集成小米辅助通道；2. StoreOffline参数设为true）
        pushRequest.setAndroidXiaoMiNotifyTitle("Mi title");
        pushRequest.setAndroidXiaoMiNotifyBody("MiActivity Body");
        pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)


//        // 推送控制
        Date pushDate = new Date(System.currentTimeMillis()) ; // 30秒之间的时间点, 也可以设置成你指定固定时间
        String pushTime = ParameterHelper.getISO8601Time(pushDate);
        pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
        String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        pushRequest.setExpireTime(expireTime);
        pushRequest.setStoreOffline(true); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
        pushRequest.setBatchNumber("100010"); // 批次编号,用于活动效果统计. 设置成业务可以记录的字符串


        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        System.out.printf("RequestId: %s, MessageID: %s\n",
                    pushResponse.getRequestId(), pushResponse.getMessageId());



    }

    /**
     * 取消定时推送
     * <p>
     * //
     */
    @Test
    public void testCancelPush() throws Exception {
        CancelPushRequest request = new CancelPushRequest();
        request.setAppKey(appKey);
        request.setMessageId("510456");
        CancelPushResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());

    }

    /**
     * 推送排查接口
     * */
    @Test
    public void testTracePush () throws Exception {
        TracePushRequest request = new TracePushRequest();
        request.setAppKey(appKey);
        request.setMessageId("503360");
        request.setDeviceId(deviceIds);
        TracePushResponse response = client.getAcsResponse(request);
        TracePushResponse.PushBasicInfo basicInfo = response.getPushBasicInfo();
        TracePushResponse.PushTaskInfo  taskInfo = response.getPushTaskInfo();
        TracePushResponse.PushDeviceInfo deviceInfo = response.getPushDeviceInfo();
        System.out.printf("AppId: %d, Title: %s\nPushType: %s, DeviceType: %s\nPushTime: %s, ExpireTime: %s\n",
                basicInfo.getAppId(),basicInfo.getTitle(),basicInfo.getPushType(),basicInfo.getTargetType(),basicInfo.getPushTime(),basicInfo.getExpireTime());
        if  (taskInfo != null && taskInfo.getBroadcast() != null){
            if (taskInfo.getBroadcast()) {
                System.out.printf("AcceptTime: %s\nAndroidTaskStatus: %s,AndroidTaskErrCode: %s\niOSTaskStatus: %s,iOSTaskErrCode: %s\n"
                        ,taskInfo.getAcceptTime(),taskInfo.getAndroidTaskStatus(),taskInfo.getAndroidTaskErrCode(),
                        taskInfo.getiOSTaskStatus(),taskInfo.getAndroidTaskErrCode());
            } else {
                System.out.printf("AcceptTime: %s,DeviceSet: %s",taskInfo.getAcceptTime(),taskInfo.getDeviceSet());

            }
        }
        if (deviceInfo != null && deviceInfo.getOnline() != null) {
            System.out.printf("online: %b\nCreateTime: %s,SentTime: %s\nArriveTime: %s,clickTime: %s\nCleanTime: %s\nDeviceStatus: %s,DeviceErrCode: %s\n"
                    ,deviceInfo.getOnline(),deviceInfo.getCreateTime(),deviceInfo.getSentTime(),deviceInfo.getArriveTime(),
                    deviceInfo.getClickTime(),deviceInfo.getCleanTime(),deviceInfo.getDeviceStatus(),deviceInfo.getDeviceErrCode());
        }
       //
    }

}
