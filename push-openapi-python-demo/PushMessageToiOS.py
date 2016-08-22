#!/usr/bin/python
#coding=utf-8
import properties
from aliyunsdkpush.request.v20150827 import PushMessageToiOSRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushMessageToiOSRequest.PushMessageToiOSRequest();
request.set_AppKey(properties.appKey)
request.set_Target('all')
request.set_TargetValue('all')
request.set_Message("Message from ali push Open Api:PushMessageToiOS")
#当应用不在线时,会把该内容转成通知发送出去,转通知后Message不起作用(高级接口的离线消息转通知的功能详见高级接口remind参数)
request.set_Summary("Summary from ali push Open Api:PushMessageToiOS")
result = clt.do_action(request)

print result
