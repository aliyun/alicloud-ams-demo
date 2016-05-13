#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import PushMessageToAndroidRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushMessageToAndroidRequest.PushMessageToAndroidRequest()
request.set_AppKey(properties.appKey)
request.set_Target('all')
request.set_TargetValue('all')
request.set_Message("Message from ali push Open Api:PushMessageToAndroid")
result = clt.do_action(request)

print result
