var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2016-08-01'
    }
);

push.unbindTag({
    AppKey: '<your Appkey>',
    KeyType : "DEVICE"//DEVICE：是设备，ACCOUNT：是账号，ALIAS：是别名
    ClientKey : '<your deviceId or your account>',
    TagName : 'tag3'
  }, function (err, res) {
    console.log(err, res);
  });

return ;
