#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import PushNoticeToiOSRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushNoticeToiOSRequest.PushNoticeToiOSRequest()
request.set_AppKey(properties.appKey)
request.set_Env('PRODUCT')
request.set_Target('all')
request.set_TargetValue('all')
request.set_Summary("Summary from ali push Open Api:PushNoticeToiOS")
request.set_Ext("{\"sound\":\"default\",\"_ENV_\":\"DEV\"}")
result = clt.do_action(request)

print result
