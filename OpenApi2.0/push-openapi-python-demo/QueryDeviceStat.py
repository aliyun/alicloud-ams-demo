#!/usr/bin/python
#coding=utf-8
from datetime import *
import time
import properties
from aliyunsdkpush.request.v20160801 import QueryDeviceStatRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryDeviceStatRequest.QueryDeviceStatRequest()
request.set_AppKey(properties.appKey)
#NEW: 新增设备查询, TOTAL: 留存设备查询
request.set_QueryType('TOTAL')
#iOS,ANDROID,ALL
request.set_DeviceType('ALL')

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
