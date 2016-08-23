<?php

include_once '../aliyun-php-sdk-core/Config.php';
use \QueryAppPushStat\Request\V20150827 as QueryAppPushStat;

$accessKeyId = "";
$accessSecret = "";
$appKey = 123456;
$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessSecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new QueryAppPushStat\QueryAppPushStatRequest();

$request->setAppKey($appKey);
$request->setGranularity("DAY");
$request.setStartTime(startTime);
$request.setEndTime(endTime);

print_r("\r\n");
print_r($response);

?>
