#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import PushMessageToiOSRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushMessageToiOSRequest.PushMessageToiOSRequest();
request.set_AppKey(properties.appKey)
request.set_Target('ALL')
request.set_TargetValue('ALL')
request.set_Title("PushMessageToiOS Title")
request.set_Body("Body from ali push Open Api2.0 : PushMessageToiOS")
result = clt.do_action(request)

print result
