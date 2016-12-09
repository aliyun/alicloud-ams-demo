<?php

include_once '../aliyun-php-sdk-core/Config.php';
use \Push\Request\V20150827 as Push;

// 设置你自己的AccessKeyId/AccessSecret/AppKey
$accessKeyId = "";
$accessSecret = "";
$appKey = 123456;

$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessSecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\PushRequest();

// 推送目标
$request->setAppKey($appKey);
$request->setTarget("all"); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
$request->setTargetValue("all"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
$request->setDeviceType(3); // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.

// 推送配置
$request->setType(1); // 0:表示消息(默认为0), 1:表示通知
$request->setTitle("Hello OpenAPI!"); // 消息的标题
$request->setBody("PushRequest body"); // 消息的内容
$request->setSummary("PushRequest summary"); // 通知的摘要


// 推送配置: iOS
$request->setiOSBadge("5"); // iOS应用图标右上角角标
$request->setiOSMusic("default"); // iOS通知声音
$request->setiOSTitle("iOS 10 Title");//iOS通知标题(iOS 10+)
$request->setiOSSubtitle("iOS 10 Subtitle");//iOS通知副标题(iOS 10+)
$request->setiOSMutableContent("true");//使能通知扩展处理(iOS 10+)
$request->setiOSNotificationCategory("test_category");//设定通知Category(iOS 10+)
$request->setiOSExtParameters("{\"attachment\":\"https://xxxx.xxx/notification_pic.png\",\"k2\":\"v2\"}"); //自定义的kv结构,开发者扩展用 针对iOS设备（iOS 10+可以使用attachment关键字来指定富媒体推送通知的资源Url）
$request->setApnsEnv("DEV");
//$request->setRemind("false"); // 推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次(发送通知时,Summary为通知的内容,Message不起作用)。注意：离线消息转通知仅适用于生产环境

// 推送配置: Android
$request->setAndroidOpenType("3"); // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url 4 : 无跳转逻辑
$request->setAndroidOpenUrl("http://www.baidu.com"); // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
//$request->setsetXiaomiActivity("_Your_XiaoMi_Activity_");//设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffline设为true)
$request->setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); // 设定android类型设备通知的扩展属性

// 推送控制
$pushTime = gmdate('Y-m-d\TH:i:s\Z', strtotime('+3 second'));//延迟3秒发送
$request->setPushTime($pushTime);
$expireTime = gmdate('Y-m-d\TH:i:s\Z', strtotime('+1 day'));//设置失效时间为1天
$request->setExpireTime($expireTime);
$request->setTimeOut(3);
$request->setStoreOffline("false"); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到

$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
