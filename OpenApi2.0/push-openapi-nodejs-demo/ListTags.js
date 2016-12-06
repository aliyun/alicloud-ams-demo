var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2016-08-01’
    }
);

push.listTags({
    AppKey: <Your appKey>,
  }, function (err, res) {
    console.log(err, res);
  });

return ;
