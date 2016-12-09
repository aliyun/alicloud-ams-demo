using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20160801;
using System;

namespace AlibabaCloud
{
    class UnbindTag
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
            DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            UnbindTagRequest request = new UnbindTagRequest();
            request.AppKey = <Your AppKey>;
            request.KeyType = "DEVICE";//设备：DEVICE 账号：别名：alias
            request.ClientKey = <Your DeviceIds>";//一次操作最多从10个tag上解绑1000和key
            request.TagName = "tag1,tag2,tag3";//一次操作最多从10个tag上解绑1000和key

            try
            {
                UnbindTagResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
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
