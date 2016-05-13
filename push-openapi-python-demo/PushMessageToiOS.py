#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import PushMessageToiOSRequest
from aliyunsdkcore import client

t = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushMessageToiOSRequest.PushMessageToiOSRequest();
request.set_AppKey(properties.appKey)
request.set_Target('all')
request.set_TargetValue('all')
request.set_Message("Message from ali push Open Api:PushMessageToiOS")
request.set_Summary("Summary from ali push Open Api:PushMessageToiOS")
result = clt.do_action(request)

print result
