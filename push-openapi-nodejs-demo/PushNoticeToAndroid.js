var ALY = require('./index.js');
var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2015-08-27'
    }
);
push.pushNoticeToAndroid({
    AppKey: '<your Appkey>',
    Target: 'all', // 推送目标: device：推送给指定设备； account：推送给指定帐号；all：推送给全部
    TargetValue: 'all',
    Title: 'title',
    Summary: 'js Summarg',
    AndroidExtParameters: '{\"id\":1002,\"content\":\"Hello OpenAPI!\"}'
  }, function (err, res) {
    console.log(err, res);
  });

return ;
