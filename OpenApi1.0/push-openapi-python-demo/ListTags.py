#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import ListTagsRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = ListTagsRequest.ListTagsRequest()
request.set_AppKey(properties.appKey)

result = clt.do_action(request)
print result
