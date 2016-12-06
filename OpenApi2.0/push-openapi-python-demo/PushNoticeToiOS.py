#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import PushNoticeToiOSRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushNoticeToiOSRequest.PushNoticeToiOSRequest()
request.set_AppKey(properties.appKey)
request.set_ApnsEnv('PRODUCT')
request.set_Target('ALL')
request.set_TargetValue('ALL')
request.set_Body("Body from ali push Open Api2.0 : PushNoticeToiOS")
request.set_ExtParameters("{\"key\":\"key1\",\"value\":\"value1\"}")
result = clt.do_action(request)

print result
