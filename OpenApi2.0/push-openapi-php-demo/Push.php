<?php

include_once '../aliyun-php-sdk-core/Config.php';
include 'Push/Request/V20160801/PushRequest.php';
use \Push\Request\V20160801 as Push;

// 设置你自己的AccessKeyId/AccessSecret/AppKey
$accessKeyId = "your accessKeyId";
$accessKeySecret = "your accessKeySecret";
$appKey = "your appKey";

$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessKeySecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\PushRequest();

// 推送目标
$request->setAppKey($appKey);
$request->setTarget("ALL"); //推送目标: DEVICE:推送给设备; ACCOUNT:推送给指定帐号,TAG:推送给自定义标签; ALL: 推送给全部
$request->setTargetValue("ALL"); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
$request->setDeviceType("ANDROID"); //设备类型 ANDROID iOS ALL.
$request->setPushType("MESSAGE"); //消息类型 MESSAGE NOTICE
$request->setTitle("php title"); // 消息的标题
$request->setBody("php body"); // 消息的内容


// 推送配置: iOS
$request->setiOSBadge("5"); // iOS应用图标右上角角标
$request->setiOSMusic("default"); // iOS通知声音
$request->setiOSApnsEnv("DEV");//iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
$request->setiOSRemind("false"); // 推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次(发送通知时,Summary为通知的内容,Message不起作用)。注意：离线消息转通知仅适用于生产环境
$request->setiOSRemindBody("iOSRemindBody");//iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
$request->setiOSExtParameters("{\"k1\":\"ios\",\"k2\":\"v2\"}"); //自定义的kv结构,开发者扩展用 针对iOS设备


// 推送配置: Android
$request->setAndroidNotifyType("NONE");//通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
$request->setAndroidNotificationBarType(1);//通知栏自定义样式0-100
$request->setAndroidOpenType("URL");//点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
$request->setAndroidOpenUrl("http://www.aliyun.com");//Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
$request->setAndroidActivity("com.alibaba.push2.demo.XiaoMiPushActivity");//设定通知打开的activity，仅当AndroidOpenType="Activity"有效
$request->setAndroidMusic("default");//Android通知音乐
$request->setAndroidXiaoMiActivity("com.ali.demo.MiActivity");//设置该参数后启动小米托管弹窗功能, 此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 集成小米辅助通道；2. StoreOffline参数设为true
$request->setAndroidXiaoMiNotifyTitle("Mi Title");
$request->setAndroidXiaoMiNotifyBody("Mi Body");
$request->setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); // 设定android类型设备通知的扩展属性

// 推送控制
$pushTime = gmdate('Y-m-d\TH:i:s\Z', strtotime('+3 second'));//延迟3秒发送
$request->setPushTime($pushTime);
$expireTime = gmdate('Y-m-d\TH:i:s\Z', strtotime('+1 day'));//设置失效时间为1天
$request->setExpireTime($expireTime);
$request->setStoreOffline("false"); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到

$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
