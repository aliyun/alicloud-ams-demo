using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20160801;
using System;

namespace AlibabaCloud
{
    class Push
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
	    DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            PushNoticeToAndroidRequest request = new PushNoticeToAndroidRequest();
            request.AppKey = <your Appkey>;
            request.Target = "ALL";//推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
            request.TargetValue = "all";//根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备一次最多100个)
            request.Title = "android notice title";
            request.Body = "android notice body";
            request.ExtParameters = "{\"key1\":\"value1\",\"api_name\":\"PushNoticeToAndroidRequest\"}";
            try
            {
                PushNoticeToAndroidResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("ResponseId:"+response.MessageId);
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

