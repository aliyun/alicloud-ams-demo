var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2016-08-01'
    }
);

push.push({
  AppKey: '<your appKey>',
  //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
  Target: 'ALL', 
  //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
  TargetValue: 'ALL',
  PushType: "NOTICE", //消息类型 MESSAGE NOTICE
  //设备类型 ANDROID iOS ALL.
  DeviceType: "ANDROID",
  Title: 'Push Title',
  Body: 'Push Body',

  //iOS相关配置
  iOSBadge: '5',//iOS应用图标右上角角标
  iOSMusic: 'default',//iOS通知声音
  iOSApnsEnv: 'PRODUCT',//iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
  iOSRemind: true,//消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
  iOSRemindBody: "iOSReminfBody",//iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
  iOSExtParameters: "{\"key\":\"value\"}",//通知的扩展属性(注意 : 该参数要以json map的格式传入,否则会解析出错)

  //android相关配置
  AndroidNotifyType: "NONE", //通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
  AndroidNotificationBarType: 1, //通知栏自定义样式0-100
  AndroidOpenType: "URL", //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
  AndroidOpenUrl: "http://www.aliyun.com", //Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
  AndroidActivity: "com.alibaba.push2.demo.XiaoMiPushActivity", //设定通知打开的activity,仅当AndroidOpenType="Activity"有效
  AndroidXiaoMiActivity: "com.ali.demo.MiActivity", //设置该参数后启动小米托管弹窗功能, 此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 集成小米辅助通道；2. StoreOffline参数设为true）
  AndroidExtParameters: "{\"key\":\"value\"}", //通知的扩展属性(注意 : 该参数要以json map的格式传入,否则会解析出错)


  //推送控制
  //可以设置成你指定固定时间
  PushTime: (new Date((new Date()).getTime() + 3600 * 1000)).toISOString().replace(/\.\d\d\d/g,''),
  // 离线消息的过期时间，过期则不会再被发送。离线消息最长保存72小时，过期时间时长不会超过发送时间加72小时。时间格式按照ISO8601标准表示，并需要使用UTC时间，格式为YYYY-MM-DDThh:mm:ssZ
  ExpireTime: (new Date((new Date()).getTime() + 12 * 3600 * 1000)).toISOString().replace(/\.\d\d\d/g,''),
  StoreOffLine: false,//离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
  BatchNumber: "100010"//批次编号,用于活动效果统计. 设置成业务可以记录的字符串
}, function (err, res) {
  console.log(err, res);
});

return;
