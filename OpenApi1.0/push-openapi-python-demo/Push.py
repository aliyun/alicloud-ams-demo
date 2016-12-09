#!/usr/bin/python
#coding=utf-8

import properties
from aliyunsdkpush.request.v20150827 import PushRequest
from aliyunsdkcore import client

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushRequest.PushRequest()
#替换成自己的appKey
request.set_AppKey(properties.appKey)
#推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
request.set_Target('all')
#根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
request.set_TargetValue('all')
#设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值
request.set_DeviceType(1)
#0:表示消息(默认为0), 1:表示通知
request.set_Type(0)
#消息的标题
request.set_Title("Hello Open Api!")
#消息的内容
request.set_Body("Body from ali push open api:Push")
#通知的摘要
request.set_Summary("Summary from ali push open api:Push")
#离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
#request.set_StoreOffline(False)

# iOS配置

#iOS应用图标右上角角标
request.set_iOSBadge("5")
#iOS通知声音
request.set_iOSMusic("default")
# iOS通知标题(iOS 10+)
request.set_iOSTitle("iOS 10 Title")
# iOS通知副标题(iOs 10+)
request.set_iOSSubtitle("iOS 10 Subtitle")
# 使能通知扩展处理(iOS 10+)
request.set_iOSMutableContent(True)
# 设定通知Category(iOS 10+)
request.set_iOSNotificationCategory("test_category")
#自定义的kv结构,开发者扩展用 针对iOS设备(iOS 10+ 可以使用关键字attachment来指定富媒体推送通知的资源Url)
request.set_iOSExtParameters("{\"attachment\":\"https://xxxx.xxx/notification_pic.png\",\"k2\":\"v2\"}")
#推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次(发送通知时,Summary为通知的内容,Message不起作用)。注意：离线消息转通知仅适用于生产环境
#request.set_Remind(False)
#iOS环境
request.set_ApnsEnv("DEV")

#android配置

#设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffline设为true）
#request.set_XiaomiActivity("_Your_XiaoMi_Activity_")
#点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url 4 : 无跳转逻辑
request.set_AndroidOpenType("3")
#Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
request.set_AndroidOpenUrl("http://www.baidu.com")
#设定android类型设备通知的扩展属性
request.set_AndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}")

result = clt.do_action(request)
print result
