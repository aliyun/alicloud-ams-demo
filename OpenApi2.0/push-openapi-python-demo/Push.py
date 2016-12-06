#!/usr/bin/python
#coding=utf-8

import properties
from aliyunsdkpush.request.v20160801 import PushRequest
from aliyunsdkcore import client
from datetime import *
import time

clt = client.AcsClient(properties.accessKeyId,properties.accessKeySecret,properties.regionId)

request = PushRequest.PushRequest()
request.set_AppKey(properties.appKey)
#推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
request.set_Target('ALL')
#根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
request.set_TargetValue('ALL')
#设备类型 ANDROID iOS ALL
request.set_DeviceType("ANDROID")
#消息类型 MESSAGE NOTICE
request.set_PushType("NOTICE")
#消息的标题
request.set_Title("Open Api Push Title")
#消息的内容
request.set_Body("Body from ali push open api2.0 : Push")

# iOS配置

#iOS应用图标右上角角标
request.set_iOSBadge("5")
#iOS通知声音
request.set_iOSMusic("default")
#iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
request.set_iOSApnsEnv("PRODUCT")
# 消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
request.set_iOSRemind(True)
#iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
request.set_iOSRemindBody("iOSRemindBody");
#自定义的kv结构,开发者扩展用 针对iOS设备
request.set_iOSExtParameters("{\"k1\":\"ios\",\"k2\":\"v2\"}")

#android配置

#通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
request.set_AndroidNotifyType("SOUND")
#通知栏自定义样式1-100
request.set_AndroidNotificationBarType(1)
#点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
request.set_AndroidOpenType("URL");
#Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
request.set_AndroidOpenUrl("www.aliyun.com")
#设定通知打开的activity，仅当AndroidOpenType="Activity"有效
request.set_AndroidActivity("com.alibaba.push2.demo.XiaoMiPushActivity")
#Android通知声音
request.set_AndroidMusic("default")
#设置该参数后启动小米托管弹窗功能, 此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 集成小米辅助通道；2. StoreOffline参数设为true）
request.set_AndroidXiaoMiActivity("com.alibaba.push2.demo.XiaoMiPushActivity")
#设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)
request.set_AndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}")

#推送控制
#30秒之后发送, 也可以设置成你指定固定时间
pushDate = datetime.utcnow() + timedelta(seconds = +30)
#24小时后消息失效, 不会再发送
expireDate = datetime.utcnow() + timedelta(hours = +24)
#转换成ISO8601T数据格式
pushTime = pushDate.strftime("%Y-%m-%dT%XZ")
expireTime = expireDate.strftime("%Y-%m-%dT%XZ")
request.set_PushTime(pushTime)
request.set_ExpireTime(expireTime)
#设置过期时间，单位是小时
request.set_TimeOut(24)
request.set_StoreOffLine(True)
request.set_BatchNumber("100010")

result = clt.do_action(request)
print result
