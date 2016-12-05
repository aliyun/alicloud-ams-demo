#!/usr/bin/python
#coding=utf-8
from datetime import *
import time
import properties
from aliyunsdkpush.request.v20150827 import QueryUniqueDeviceStatRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryUniqueDeviceStatRequest.QueryUniqueDeviceStatRequest()
request.set_AppKey(properties.appKey)

## 查询近七天的数据
startDate = datetime.utcnow() + timedelta(days = -7)
endDate = datetime.utcnow()

## 转换成ISO8601T数据格式
startTime = startDate.strftime("%Y-%m-%dT%XZ")
endTime = endDate.strftime("%Y-%m-%dT%XZ")

request.set_StartTime(startTime)
request.set_EndTime(endTime)

result = clt.do_action(request)
print result
