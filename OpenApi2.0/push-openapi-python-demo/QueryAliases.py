#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import QueryAliasesRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryAliasesRequest.QueryAliasesRequest()
request.set_AppKey(properties.appKey)
#一次只能查询一个设备
request.set_DeviceId(properties.deviceId);

result = clt.do_action(request)
print result
