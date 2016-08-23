#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import QueryDeviceStatRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryDeviceStatRequest.QueryDeviceStatRequest()
request.set_AppKey(properties.appKey)
request.set_QueryType('Total')
request.set_DeviceType('All')
request.set_StartTime('')
request.set_EndTime('')
result = clt.do_action(request)

print result
