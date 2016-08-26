var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2015-08-27'
    }
);

// 推送消息到 iOS
push.push({
  AppKey: '<your AppKey>',
  // 推送目标: device：推送给指定设备； account：推送给指定帐号；all：推送给全部
  Target: 'all', 
  //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
  TargetValue: 'all',
  Type: 0,    // 0：表示消息，默认值；1：表示通知。
  // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.
  DeviceType: 0,
  Title: 'title',
  Body: 'body123',
  Summary: 'summary',
  // 离线消息的过期时间，过期则不会再被发送。离线消息最长保存72小时，过期时间时长不会超过发送时间加72小时。时间格式按照ISO8601标准表示，并需要使用UTC时间，格式为YYYY-MM-DDThh:mm:ssZ
  //ExpireTime: (new Date((new Date()).getTime() + 12 * 3600 * 1000)).toISOString(),
  ApnsEnv: "DEV",
  // 当APP不在线时候，是否通过通知提醒,仅对iOS消息使用
  //Remind: false,
  // 推送控制, 是否离线存储
  //StoreOffline: false,
  iOSBadge:'6',
  iOSExtParameters:"{}"
}, function (err, res) {
  console.log(err, res);
});

return;
