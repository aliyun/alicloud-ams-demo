<?php

include_once '../aliyun-php-sdk-core/Config.php';
include 'Push/Request/V20160801/QueryPushStatByMsgRequest.php';
use \Push\Request\V20160801 as Push;

$accessKeyId = "your accessKeyId";
$accessKeySecret = "your accessKeySecret";
$appKey = "your appKey";

$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessKeySecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\QueryPushStatByMsgRequest();

$request->setAppKey($appKey);
$request->setMessageId('500345');

$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
