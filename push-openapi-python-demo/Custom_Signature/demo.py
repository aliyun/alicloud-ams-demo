from datetime import  * # 用于获取时间戳 
from random import choice # 用于获取随机数
from string import ascii_uppercase
from request import * # 用于组装HTTP请求
from urllib import * # 用于发送HTTP请求

params = {
    "Format" : "XML",
    "RegionId" : "cn-hangzhou",
    "Version" : "2015-08-27",
    "AccessKeyId" : "<Your AccessKey>",
    "SignatureMethod" : "HMAC-SHA1",
    "Timestamp" : datetime.utcnow().strftime("%Y-%m-%dT%XZ"),
    "SignatureVersion" : "1.0",
    "SignatureNonce" : ''.join(choice(ascii_uppercase) for i in range(12)),
    "Action" : "ListTags",
    "AppKey" : "<Your AppKey>"
}

host = "http://cloudpush.aliyuncs.com"
request = request(host,params,'<Your SecretKey>')
print urlopen(request).read()
