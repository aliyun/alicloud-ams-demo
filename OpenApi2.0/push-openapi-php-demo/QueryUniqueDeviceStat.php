<?php

include_once '../aliyun-php-sdk-core/Config.php';
include 'Push/Request/V20160801/QueryUniqueDeviceStatRequest.php';
use \Push\Request\V20160801 as Push;

$accessKeyId = "your accessKeyId";
$accessKeySecret = "your accessKeySecret";
$appKey = "your appKey";

$iClientProfile = DefaultProfile::getProfile("cn-hangzhou", $accessKeyId, $accessKeySecret);
$client = new DefaultAcsClient($iClientProfile);
$request = new Push\QueryUniqueDeviceStatRequest();

$request->setAppKey($appKey);
$request->setGranularity("DAY");//DAY: 天粒度 MONTH: 月粒度
//查询近七天的数据
$startTime =  gmdate('Y-m-d\TH:i:s\Z', strtotime('-7 day'));
$endTime = gmdate('Y-m-d\TH:i:s\Z', time());
$request->setStartTime($startTime);
$request->setEndTime($endTime);

$response = $client->getAcsResponse($request);
print_r("\r\n");
print_r($response);

?>
