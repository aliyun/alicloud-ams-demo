#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import CancelPushRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = CancelPushRequest.CancelRequest()
request.set_AppKey(properties.appKey)
#推送时返回的responseId
request.set_MessageId('Your MessageId');

result = clt.do_action(request)
print result
