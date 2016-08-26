<?php

include_once '../aliyun-php-sdk-core/Config.php';
use \Push\Request\V20150827 as Push;
$accessKeyId = "";
$accessSecret = "";
$appKey = 123456;
$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessSecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\QueryAppPushStatRequest();

$request->setAppKey($appKey);
//按天进行查询
$request->setGranularity("DAY");
//查询近七天的数据
$startTime =  gmdate('Y-m-d\TH:i:s\Z', strtotime('-7 day'));
$endTime = gmdate('Y-m-d\TH:i:s\Z', time());
$request->setStartTime($startTime);
$request->setEndTime($endTime);

$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
