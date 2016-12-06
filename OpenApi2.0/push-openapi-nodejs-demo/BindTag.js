var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2016-08-01’
    }
);

push.bindTag({
    AppKey: '<Your appKey>',
    //DEVICE：是设备，ACCOUNT：是账号，ALIAS：是别名
    KeyType : 'DEVICE',
    ClientKey : '<Your DeviceID>',
    TagName : 'tag3'
  }, function (err, res) {
    console.log(err, res);
  });

return ;
