var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2015-08-27'
    }
);

push.cancelPush({
    AppKey: '<your Appkey>',
    MessageId : '<your MessageId>',
  }, function (err, res) {
    console.log(err, res);
  });

return ;
