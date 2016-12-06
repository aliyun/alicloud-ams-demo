<?php

include_once '../aliyun-php-sdk-core/Config.php';
include 'Push/Request/V20160801/PushNoticeToiOSRequest.php';
use \Push\Request\V20160801 as Push;

// 设置你的AccessKeyId/AccessSecret/AppKey

$accessKeyId = "your accessKeyId";
$accessKeySecret = "your accessKeySecret";
$appKey = "your appKey";

$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessKeySecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\PushNoticeToiOSRequest();


$request->setAppKey($appKey);
$request->setTarget("ALL"); //推送目标: DEVICE:推送给设备; ACCOUNT:推送给指定帐号,TAG:推送给自定义标签; ALL: 推送给全部
$request->setTargetValue("ALL"); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
$request->setApnsEnv("DEV");//iOS的通知是通过APNS中心来发送的，需要填写对应的环境信息. DEV :表示开发环境, PRODUCT: 表示生产环境
$request->setBody("php Body");
$request->setExtParameters("{\"k1\":\"v1\",\"k2\":\"v2\"}");


$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
