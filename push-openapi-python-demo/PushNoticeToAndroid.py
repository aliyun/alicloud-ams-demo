#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import PushNoticeToAndroidRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushNoticeToAndroidRequest.PushNoticeToAndroidRequest()
request.set_AppKey(properties.appKey)
request.set_Target('all')
request.set_TargetValue('all')
request.set_Title("Hello OpenAPI!")
request.set_Summary("你好, PushNoticeToAndroid from OpenAPI:PushNoticeToAndroid!")
request.set_AndroidExtParameters("{\"id\":1001,\"content\":\"Hello OpenAPI!\"}")
result = clt.do_action(request)
print result
