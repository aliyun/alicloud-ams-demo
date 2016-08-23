<?php

include_once '../aliyun-php-sdk-core/Config.php';
use \QueryUniqueDeviceStat\Request\V20150827 as QueryUniqueDeviceStat;

$accessKeyId = "";
$accessSecret = "";
$appKey = 123456;
$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessSecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new QueryUniqueDeviceStat\QueryUniqueDeviceStatRequest();

$request->setAppKey($appKey);
$request.setStartTime(startTime);
$request.setEndTime(endTime);

print_r("\r\n");
print_r($response);

?>
