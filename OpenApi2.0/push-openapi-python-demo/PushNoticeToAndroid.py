#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20160801 import PushNoticeToAndroidRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushNoticeToAndroidRequest.PushNoticeToAndroidRequest()
request.set_AppKey(properties.appKey)
request.set_Target('ALL')
request.set_TargetValue('ALL')
request.set_Title("OpenAPI2.0 Title")
request.set_Body("PushNoticeToAndroid from OpenAPI2.0 : PushNoticeToAndroid!")
request.set_ExtParameters("{\"id\":1001,\"content\":\"Hello OpenAPI!\"}")
result = clt.do_action(request)

print result
