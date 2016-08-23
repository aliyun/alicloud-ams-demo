using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20150827;
using System;

namespace AlibabaCloud
{
    class QueryPushStat
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
	    DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            QueryPushStatRequest request = new QueryPushStatRequest();
            request.AppKey = <your appKey>;

            request.MessageId = '500345';
            try
            {
                QueryPushStatResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("ReceivedCount:"+response.getReceivedCount);
                Console.WriteLine("SentCount:"+response.getSentCount);
                Console.WriteLine("MessageId:"+response.getMessageId);
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

