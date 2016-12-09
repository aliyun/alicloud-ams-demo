using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20160801;
using System;

namespace AlibabaCloud
{
    class BindTag
    {
        static void Main()
        {
            IClientProfile clientProfile = DefaultProfile.GetProfile("cn-hangzhou", "<your access key id>", "<your access key secret>");
            DefaultAcsClient client = new DefaultAcsClient(clientProfile);
            BindTagRequest request = new BindTagRequest();
            request.AppKey = <Your AppKay>;
            request.KeyType = "DEVICE";//设备：DEVICE 账号：ACCOUNT 别名：ALIAS
            request.ClientKey = <Your DeviceIds>;//一次最多可以绑定1000个Key到10个tag上
            request.TagName = "tag1,tag2";//一次最多可以绑定1000个Key到10个tag上

            try
            {
                BindTagResponse response = client.GetAcsResponse(request);
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
