#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import UnbindAliasRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = UnbindAliasRequest.UnbindAliasRequest()
request.set_AppKey(properties.appKey)
request.set_DeviceId(properties.deviceId)
request.set_AliasName(properties.alias)

result = clt.do_action(request)
print result
