var http = require('http');
var util = require('util');
var request = require('./request.js');

var params = {
"Format" : "XML",
"RegionId" : "cn-hangzhou",
"Version" : "2015-08-27",
"AccessKeyId" : '<Your AccessKey>',
"SignatureMethod" : "HMAC-SHA1",
"Timestamp" : new Date().toISOString().replace(/\.\d\d\d/g,''),
"SignatureVersion" : "1.0",
"SignatureNonce" : Math.random().toString(36).substring(7),
"Action" : "ListTags",
"AppKey" : '<Your AppKey>'
};

var host = "http://cloudpush.aliyuncs.com";
var request = request.request(host,params,'<Your SecretKey>');

http.get(request, function(res) {
    console.log("HTTP StatusCode: " + res.statusCode);

    var buffers = [];
    res.on('data', function(chunk) {
        buffers.push(chunk);
    });

    res.on('end', function(chunk) {
        var wholeData = Buffer.concat(buffers);
        var dataStr = wholeData.toString('utf8');
        console.log(dataStr);
    });
}).on('error', function(e) {
    console.log("错误: " + e.message);
});
