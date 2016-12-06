var ALY = require('aliyun-sdk');


var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2016-08-01'
    }
);

push.queryPushStatByMsg({
    AppKey: '<your AppKey>',
    MessageId: '500345'
  }, function (err, res) {
    console.log(err, res);
  });

return ;
