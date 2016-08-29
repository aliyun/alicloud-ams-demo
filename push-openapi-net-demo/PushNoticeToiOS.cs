using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20150827;
using System;

namespace AlibabaCloud
{
    class Push
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
	    DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            PushNoticeToiOSRequest request = new PushNoticeToiOSRequest();
            request.AppKey = <your appKey>;
            // iOS的通知是通过APNS中心来发送的，需要填写对应的环境信息. DEV:表示开发环境, PRODUCT: 表示生产环境
            request.Env = "DEV";
            request.Target = "all";
            request.TargetValue = "all";
            request.Summary = ".net summary";
            request.IOSExtParameters = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
            request.Ext = "{\"sound\":\"default\", \"badge\":\"42\"}";
            try
            {
                PushNoticeToiOSResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("ResponseId:"+response.ResponseId);
                Console.ReadLine();
            }
            catch (ServerException e)
            {
                Console.WriteLine(e.ErrorCode);
                Console.WriteLine(e.ErrorMessage);
		Console.ReadLine();
            }
            catch (ClientException e)
            {
                Console.WriteLine(e.ErrorCode);
                Console.WriteLine(e.ErrorMessage);
		Console.ReadLine();
            }
        }
            
    }
}

