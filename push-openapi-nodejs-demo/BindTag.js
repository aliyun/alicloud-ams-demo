var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2015-08-27'
    }
);

push.bindTag({
    AppKey: '<your Appkey>',
    KeyType : 1,//1: device 2: account 3 : alias
    ClientKey : '<your deviceId or your account>',
    TagName : 'tag3'
  }, function (err, res) {
    console.log(err, res);
  });

return ;
