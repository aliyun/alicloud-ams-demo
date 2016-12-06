var ALY = require('aliyun-sdk');

var push = new ALY.PUSH({
      accessKeyId: '<your access key id>',
      secretAccessKey: '<your access key secret>',
      endpoint: 'http://cloudpush.aliyuncs.com',
      apiVersion: '2016-08-01’
    }
);

//查询近七天的统计数据
startTimestamp= new Date().getTime() - 7 * 24 * 3600 * 1000;
endTimestamp = new Date();
startTime = new Date(startTimestamp).toISOString().replace(/\.\d\d\d/g,'');
endTime = new Date(endTimestamp).toISOString().replace(/\.\d\d\d/g,'');

push.queryDeviceStat({
    AppKey: '<your appKey>',
    QueryType:'TOTAL',//NEW: 新增设备查询, TOTAL: 留存设备查询
    DeviceType:'ALL',//iOS,ANDROID,ALL
    StartTime: startTime,
    EndTime: endTime
  }, function (err, res) {
    console.log(err, res);
  });

return ;
