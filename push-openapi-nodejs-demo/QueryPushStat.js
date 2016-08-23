var ALY = require('./index.js');
var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2015-08-27'
    }
);
push.QueryPushStat({
    AppKey: '<your Appkey>',
    MessageId: '500345'
  }, function (err, res) {
    console.log(err, res);
  });

return ;
