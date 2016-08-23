using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20150827;
using System;

namespace AlibabaCloud
{
    class QueryDeviceStat
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
	    DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            QueryDeviceStatRequest request = new QueryDeviceStatRequest();
            request.AppKey = <your appKey>;

            request.QueryType = 'Total';
            request.DeviceType = 'All';
            request.StartTime = '';
            request.EndTime = '';

            try
            {
                QueryDeviceStatResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("time:"+response.getSentCount);
                Console.WriteLine("DeviceType:"+response.getReceivedCount);
                Console.WriteLine("count:"+response.getSentCount);
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

