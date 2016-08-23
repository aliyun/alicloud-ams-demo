using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20150827;
using System;

namespace AlibabaCloud
{
    class QueryAppPushStat
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
	    DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            QueryAppPushStatRequest request = new QueryAppPushStatRequest();
            request.AppKey = <your appKey>;

            request.Granularity = 'DAY';
            request.StartTime = '';
            request.EndTime = '';

            try
            {
                QueryAppPushStatResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("ReceivedCount:"+response.getReceivedCount);
                Console.WriteLine("SentCount:"+response.getSentCount);
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

