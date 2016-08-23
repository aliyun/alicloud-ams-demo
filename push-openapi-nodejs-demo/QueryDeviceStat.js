var ALY = require('./index.js');
var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2015-08-27'
    }
);
push.QueryDeviceStat({
    AppKey: '<your Appkey>',
    QueryType:'Total',
    DeviceType:'All',
    StartTime:'',
    EndTime:''
  }, function (err, res) {
    console.log(err, res);
  });

return ;
