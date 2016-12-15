#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import QueryDeviceInfoRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryDeviceInfoRequest.QueryDeviceInfoRequest()
request.set_AppKey(properties.appKey)
request.set_DeviceId(properties.deviceId)

result = clt.do_action(request)
print result
