using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20150827;
using System;

namespace AlibabaCloud
{
    class QueryUniqueDeviceStat
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
	    DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            QueryUniqueDeviceStatRequest request = new QueryUniqueDeviceStatRequest();
            request.AppKey = <Your AppKey>;

            String startTime = DateTime.UtcNow.AddDays(-7).ToString("yyyy-MM-ddTHH\\:mm\\:ssZ");
            String endTime = DateTime.UtcNow.AddDays(-7).ToString("yyyy-MM-ddTHH\\:mm\\:ssZ");
            request.StartTime = startTime;
            request.EndTime = endTime;

            try
            {
                QueryUniqueDeviceStatResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                foreach (QueryUniqueDeviceStatResponse.AppDeviceStat stat in response.AppDeviceStats)
                {
                    Console.WriteLine("time:" + stat.Time);
                    Console.WriteLine("count:" + stat.Count);
                }
             
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

