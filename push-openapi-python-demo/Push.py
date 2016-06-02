#!/usr/bin/python
#coding=utf-8

import properties
from aliyunsdkpush.request.v20150827 import PushRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushRequest.PushRequest()
request.set_AppKey(properties.appKey)
request.set_Target('all')
request.set_TargetValue('all')
request.set_Type(0)
request.set_Title("Hello Open Api!")
request.set_Body("Body from ali push open api:Push")
request.set_Summary("Summary from ali push open api:Push")
request.set_DeviceType(1)
#request.set_Remind(True)
#request.set_StoreOffline(False)



result = clt.do_action(request)
print result
