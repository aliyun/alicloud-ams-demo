<?php

include_once '../aliyun-php-sdk-core/Config.php';
use \QueryDeviceStat\Request\V20150827 as QueryDeviceStat;

$accessKeyId = "";
$accessSecret = "";
$appKey = 123456;
$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessSecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new QueryDeviceStat\QueryDeviceStatRequest();

$request->setAppKey($appKey);
$request.setQueryType("Total");
$request.setDeviceType("All");
$request.setStartTime(startTime);
$request.setEndTime(endTime);

print_r("\r\n");
print_r($response);

?>
