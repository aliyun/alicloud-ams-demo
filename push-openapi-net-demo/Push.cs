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
            PushRequest request = new PushRequest();

            // 推送目标

            request.AppKey = <your appKey>;
            //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
            request.Target = "all";
            //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
            request.TargetValue = "all";
            // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.
            request.DeviceType = 1;

            // 推送配置
            // 0:表示消息(默认为0), 1:表示通知
            request.Type = 0;
            // 消息的标题
            request.Title = ".net Title";
            // 消息的内容
            request.Body = ".net body";
            // 通知的摘要
            request.Summary = ".net Summary";
            // 推送配置: iOS
            // iOS应用图标右上角角标
            request.IOSBadge = "1";
            // iOS通知声音
            request.IOSMusic = "default";
            //自定义的kv结构,开发者扩展用 针对iOS设备
            request.IOSExtParameters = "{\"key1\":\"value1\"}";
            request.ApnsEnv = "DEV";
            // 当APP不在线时候，是否通过通知提醒
            //request.Remind = true;
            // 推送配置: Android
            // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url
            request.AndroidOpenType = "3";
            // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
            request.AndroidOpenUrl = "http://www.baidu.com";
            // 设定android类型设备通知的扩展属性
            request.AndroidExtParameters = "{\"k1\":\"android\",\"k2\":\"v2\"}";

            // 推送控制
            request.StoreOffline = true;
           
            
            try
            {
                PushResponse response = client.GetAcsResponse(request);
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

