<?php

include_once '../aliyun-php-sdk-core/Config.php';
include 'Push/Request/V20160801/PushMessageToAndroidRequest.php';
use \Push\Request\V20160801 as Push;

// 设置你的AccessKeyId/AccessSecret/AppKey

$accessKeyId = "your accessKeyId";
$accessKeySecret = "your accessKeySecret";
$appKey = "your appKey";

$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessKeySecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\PushMessageToAndroidRequest();

$request->setAppKey($appKey);
$request->setTarget("ALL"); //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
$request->setTargetValue("ALL"); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
$request->setTitle("php Title");
$request->setBody("php Body");


$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
