var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2016-08-01’
    }
);

push.pushNoticeToiOS({
    AppKey: '<your appKey>',
    ApnsEnv:'PRODUCT',
    Target: 'ALL', //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
    TargetValue: 'ALL',
    Body: 'nodejs Body',
    ExtParameters:'{\"key1\":\"value1\",\"key2\":\"value2\"}'
  }, function (err, res) {
    console.log(err, res);
  });

return ;
