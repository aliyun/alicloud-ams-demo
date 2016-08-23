#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import QueryUniqueDeviceStatRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryUniqueDeviceStatRequest.QueryUniqueDeviceStatRequest()
request.set_AppKey(properties.appKey)
request.set_StartTime('')
request.set_EndTime('')
result = clt.do_action(request)

print result
