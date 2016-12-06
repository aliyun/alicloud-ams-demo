<?php

include_once '../aliyun-php-sdk-core/Config.php';
include 'Push/Request/V20160801/QueryTagsRequest.php';
use \Push\Request\V20160801 as Push;

$accessKeyId = "your accessKeyId";
$accessKeySecret = "your accessKeySecret";
$appKey = "your appKey";
$deviceId = 'your deviceId';

$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessKeySecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\QueryTagsRequest();

$request->setAppKey($appKey);
$request->setKeyType("DEVICE");//DEVICE：是设备，ACCOUNT：是账号，ALIAS：是别名
$request->setClientKey($deviceId);

$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
