var ALY = require('./index.js');
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
  Target: 'all', // 推送目标: device：推送给指定设备； account：推送给指定帐号；all：推送给全部
  TargetValue: 'all',
  Type: 0,    // 0：表示消息，默认值；1：表示通知。
  Title: 'title',
  Remind: false,
  StoreOffline: false,
  // 离线消息的过期时间，过期则不会再被发送。离线消息最长保存72小时，过期时间时长不会超过发送时间加72小时。时间格式按照ISO8601标准表示，并需要使用UTC时间，格式为YYYY-MM-DDThh:mm:ssZ
  //ExpireTime: (new Date((new Date()).getTime() + 12 * 3600 * 1000)).toISOString(),
  Body: 'body123',
  Summary: 'summary',
  ApnsEnv: "DEV",
  DeviceType: 0,
  iOSExtParameters:"{}",
  iOSBadge:'6'
}, function (err, res) {
  console.log(err, res);
});
return;
