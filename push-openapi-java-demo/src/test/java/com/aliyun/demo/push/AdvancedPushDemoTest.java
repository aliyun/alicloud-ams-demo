package com.aliyun.demo.push;

import com.aliyuncs.push.model.v20150827.PushRequest;
import com.aliyuncs.push.model.v20150827.PushResponse;
import com.aliyuncs.utils.ParameterHelper;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 推送的OpenAPI文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/openapi.html
 */
public class AdvancedPushDemoTest extends BaseTest {
    /**
     * 推送高级接口
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/push-advanced.html
     */
    @Test
    public void testPushNoticeToAllDeviceTypeAndAllDevice() throws Exception {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        final String date = dateFormat.format(new Date());
        PushRequest pushRequest = new PushRequest();

        // 推送目标
        pushRequest.setAppKey(appKey);
        pushRequest.setTarget("all"); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        pushRequest.setTargetValue("all"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setDeviceType(3); // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.


        // 推送配置
        pushRequest.setType(1); // 0:表示消息(默认为0), 1:表示通知
        pushRequest.setTitle(date); // 消息的标题
        pushRequest.setBody("PushRequest body"); // 消息的内容
        pushRequest.setSummary("PushRequest summary"); // 通知的摘要
        // 推送配置: iOS
        pushRequest.setiOSBadge("5"); // iOS应用图标右上角角标
        pushRequest.setiOSMusic("default"); // iOS通知声音
        pushRequest.setiOSExtParameters("{\"k1\":\"ios\",\"k2\":\"v2\"}"); //自定义的kv结构,开发者扩展用 针对iOS设备
        pushRequest.setApnsEnv("DEV");
        //pushRequest.setRemind(false); // 当APP不在线时候，是否通过通知提醒
        // 推送配置: Android
        //设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffLine设为true
        //pushRequest.setXiaomiActivity("_Your_XiaoMi_Activity_");
        pushRequest.setAndroidOpenType("3"); // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url 4 : 无跳转逻辑
        pushRequest.setAndroidOpenUrl("http://www.baidu.com"); // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
        pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); // 设定android类型设备通知的扩展属性


        // 推送控制
        //final Date pushDate = new Date(System.currentTimeMillis() + 30 * 1000); // 30秒之间的时间点, 也可以设置成你指定固定时间
        //final String pushTime = ParameterHelper.getISO8601Time(pushDate);
        // pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
        //pushRequest.setStoreOffline(false); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
        //final String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        //pushRequest.setExpireTime(expireTime);
        //pushRequest.setBatchNumber("100010"); // 批次编号,用于活动效果统计. 设置成业务可以记录的字符串

        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushResponse.getRequestId(), pushResponse.getResponseId());
    }

    @Test
    public void testPushNoticeToDeviceList() throws Exception {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        final String date = dateFormat.format(new Date());
        PushRequest pushRequest = new PushRequest();

        // 推送目标
        pushRequest.setAppKey(appKey);
        pushRequest.setTarget("device"); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        pushRequest.setTargetValue("_YOUR_DEVICE_IDS_HERE"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setDeviceType(3); // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.


        // 推送配置
        pushRequest.setType(1); // 0:表示消息(默认为0), 1:表示通知
        pushRequest.setTitle(date); // 消息的标题
        pushRequest.setBody("PushRequest body"); // 消息的内容
        pushRequest.setSummary("PushRequest summary"); // 通知的摘要
        // 推送配置: iOS
        pushRequest.setiOSBadge("5"); // iOS应用图标右上角角标
        pushRequest.setiOSMusic("default"); // iOS通知声音
        pushRequest.setiOSExtParameters("{\"k1\":\"ios\",\"k2\":\"v2\"}"); //自定义的kv结构,开发者扩展用 针对iOS设备
        pushRequest.setApnsEnv("DEV");
        //pushRequest.setRemind(true); // 推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次(发送通知时,Summary为通知的内容,Message不起作用)。注意：离线消息转通知仅适用于生产环境
        // 推送配置: Android
        //设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffLine设为true
        //pushRequest.setXiaomiActivity("_Your_XiaoMi_Activity_");
        pushRequest.setAndroidOpenType("3"); // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url 4 : 无跳转逻辑
        pushRequest.setAndroidOpenUrl("http://www.baidu.com"); // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
        pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); // 设定android类型设备通知的扩展属性


        // 推送控制
        //final Date pushDate = new Date(System.currentTimeMillis() + 30 * 1000); // 30秒之间的时间点, 也可以设置成你指定固定时间
        //final String pushTime = ParameterHelper.getISO8601Time(pushDate);
        // pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
        //pushRequest.setStoreOffline(false); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
        //final String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
        //pushRequest.setExpireTime(expireTime);
        //pushRequest.setBatchNumber("100010"); // 批次编号,用于活动效果统计. 设置成业务可以记录的字符串

        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushResponse.getRequestId(), pushResponse.getResponseId());
    }

    /**
     * 推送高级接口
     * <p>
     * 参见文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/push-advanced.html
     */
    @Test
    public void testPushNoticeToAllDeviceTypeAndDeviceWithAccount() throws Exception {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        PushRequest pushRequest = new PushRequest();

        // 推送目标
        pushRequest.setAppKey(appKey);
        pushRequest.setDeviceType(3); // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.
        pushRequest.setTarget("account"); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        pushRequest.setTargetValue("_YOUR_ACCOUNTS_HERE_"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多1000个的限制)


        // 推送控制
        //final Date pushDate = new Date(System.currentTimeMillis() + 30 * 1000); // 30秒之间的时间点, 也可以设置成你指定固定时间
        //final String pushTime = ParameterHelper.getISO8601Time(pushDate);
        // pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送

        //pushRequest.setStoreOffline(false); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
        //pushRequest.setTimeOut(24); // 离线消息保存时长,取值范围为1~72, 若不填,则表示不保存离线消息
        //pushRequest.setBatchNumber("100010"); // 批次编号,用于活动效果统计. 设置成业务可以记录的字符串


        // 推送配置
        pushRequest.setType(1); // 0:表示消息(默认为0), 1:表示通知
        pushRequest.setTitle(dateFormat.format(new Date())); // 消息的标题
        pushRequest.setBody("PushRequest body"); // 消息的内容
        pushRequest.setSummary("PushRequest summary "); // 通知的摘要
        // 推送配置: iOS
        //设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffLine设为true)
        //pushRequest.setXiaomiActivity("_Your_XiaoMi_Activity_");
        pushRequest.setAndroidOpenType("3"); // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url 4 : 无跳转逻辑
        pushRequest.setAndroidOpenUrl("http://www.baidu.com"); // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
        pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); // 设定android类型设备通知的扩展属性
        // 推送配置: Android
        pushRequest.setiOSBadge("3"); // iOS应用图标右上角角标
        pushRequest.setiOSMusic("default"); // iOS通知声音
        pushRequest.setApnsEnv("DEV");
        pushRequest.setiOSExtParameters("{\"k1\":\"ios\",\"k2\":\"v2\"}"); // 自定义的kv结构,开发者扩展用 针对iOS设备
        //pushRequest.setRemind(false); // 当APP不在线时候，是否通过通知提醒

        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        System.out.printf("RequestId: %s, ResponseId: %s\n",
                pushResponse.getRequestId(), pushResponse.getResponseId());
    }
}
