<?php

include_once '../aliyun-php-sdk-core/Config.php';
use \QueryPushStat\Request\V20150827 as QueryPushStat;

$accessKeyId = "";
$accessSecret = "";
$appKey = 123456;
$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessSecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new QueryPushStat\QueryPushStatRequest();

$request->setAppKey($appKey);
$request->setMessageId('500345');


print_r("\r\n");
print_r($response);

?>
