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
            PushMessageToiOSRequest request = new PushMessageToiOSRequest();
            request.AppKey = <your Appkey>;
            request.Target = "all";
            request.TargetValue = "all";
            request.Message = ".net message";
            request.Summary = ".net summary";
            try
            {
                PushMessageToiOSResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("ResponseId:"+response.ResponseId);
                Console.WriteLine("message:"+response.Message);
                Console.ReadLine();
            }
            catch (ServerException e)
            {
                Console.WriteLine(e.ErrorCode);
                Console.WriteLine(e.ErrorMessage);
            }
            catch (ClientException e)
            {
                Console.WriteLine(e.ErrorCode);
                Console.WriteLine(e.ErrorMessage);
            }
        }
            
    }
}

