using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Text;

namespace AliCloudPush
{
    class demo
    {
        static void Main(string[] args)
        {
            SortedDictionary<string, object> parameters = new SortedDictionary<string, object>{
                {"Format","XML"},
                {"RegionId","cn-hangzhou"},
                {"Version","2015-08-27"},
                {"SignatureMethod","HMAC-SHA1"},
                { "Timestamp",DateTime.UtcNow.ToString("yyyy-MM-ddTHH\\:mm\\:ssZ")},
                {"SignatureVersion","1.0"},
                {"SignatureNonce",Guid.NewGuid().ToString()},
                {"Action","ListTags"},
                {"AccessKeyId","<Your AccessKey>"},
                {"AppKey","<Your AppKey>"}
             };
            string host = "http://cloudpush.aliyuncs.com";
            string request = Request.request(host,parameters, "<Your SecretKey>");
            HttpRequest popRequest = new HttpRequest(request);
            popRequest.Method = MethodType.GET;
            HttpResponse response = HttpResponse.GetResponse(popRequest);
            string body = Encoding.Default.GetString(response.Content);
            Console.WriteLine(body);
            Console.ReadLine();
        }
    }
}
