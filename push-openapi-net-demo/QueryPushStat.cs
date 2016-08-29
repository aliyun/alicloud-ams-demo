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
            request.MessageId = "<MessageId>";
            
            try
            {
                QueryPushStatResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                foreach (QueryPushStatResponse.PushStat stat in response.PushStats)
                {
                    Console.WriteLine("MessageIdt:" + stat.MessageId);
                    Console.WriteLine("SentCount:" + stat.SentCount);
                    Console.WriteLine("ReceivedCount:" + stat.ReceivedCount);
                    Console.WriteLine("OpenedCount:" + stat.OpenedCount);
                    Console.WriteLine("DeletedCount:" + stat.DeletedCount);
                }
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

