#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import PushMessageToAndroidRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushMessageToAndroidRequest.PushMessageToAndroidRequest()
request.set_AppKey(properties.appKey)
request.set_Target('ALL')
request.set_TargetValue('ALL')
request.set_Title("PushMessageToAndroid title")
request.set_Body("Message from ali push Open Api2.0 : PushMessageToAndroid")
result = clt.do_action(request)

print result
