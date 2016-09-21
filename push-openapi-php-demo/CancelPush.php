<?php

include_once '../aliyun-php-sdk-core/Config.php';
use \Push\Request\V20150827 as Push;

$accessKeyId = "";
$accessSecret = "";
$appKey = 123456;
$deviceId = '';
$account = '';
$messageId='';
$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessSecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\CancelPushRequest();

$request->setAppKey($appKey);
$request->setKeyMessageId(messageId);//推送时返回的responseID

$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
