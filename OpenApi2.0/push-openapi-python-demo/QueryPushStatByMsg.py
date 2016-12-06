#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import QueryPushStatByMsgRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = QueryPushStatByMsgRequest.QueryPushStatByMsgRequest()
request.set_AppKey(properties.appKey)

## 推送成功后返回的消息ID
request.set_MessageId('500028')

result = clt.do_action(request)

print result
