using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20160801;
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

            request.Granularity = "DAY";//DAY: 天粒度 MONTH: 月粒度
	    String startTime = DateTime.UtcNow.AddDays(-7).ToString("yyyy-MM-ddTHH\\:mm\\:ssZ");//查询近7天的数据
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

