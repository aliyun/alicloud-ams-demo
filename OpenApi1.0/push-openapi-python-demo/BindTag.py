#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import BindTagRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = BindTagRequest.BindTagRequest()
request.set_AppKey(properties.appKey)
request.set_ClientKey(properties.deviceIds);
##1: device 2: account 3 : alias
request.set_KeyType(1)
request.set_TagName("tag1")

result = clt.do_action(request)
print result
