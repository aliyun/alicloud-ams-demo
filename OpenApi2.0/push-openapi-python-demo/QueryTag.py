#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import QueryTagsRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryTagsRequest.QueryTagsRequest()
request.set_AppKey(properties.appKey)
request.set_ClientKey(properties.deviceIds);
# DEVICE：是设备，ACCOUNT：是账号，ALIAS：是别名
request.set_KeyType("DEVICE")

result = clt.do_action(request)
print result
