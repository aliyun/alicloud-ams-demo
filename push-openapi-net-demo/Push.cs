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
	    // 推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次(发送通知时,Summary为通知的内容,Message不起作用)。注意：离线消息转通知仅适用于生产环境
            // request.Remind = false;
           
	    // 推送配置: Android
            // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url 4 :无跳转逻辑
            request.AndroidOpenType = "3";
            // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
            request.AndroidOpenUrl = "http://www.baidu.com";
            //设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffLine设为true)
            //request.XiaomiActivity = "_Your_XiaoMi_Activity_";
            // 设定android类型设备通知的扩展属性
            request.AndroidExtParameters = "{\"k1\":\"android\",\"k2\":\"v2\"}";

            // 推送控制
	    //String pushTime = DateTime.UtcNow.AddSeconds(3).ToString("yyyy-MM-ddTHH\\:mm\\:ssZ");
	    //request.PushTime = pushTime;//延迟3秒发送
	    //String expireTime = DateTime.UtcNow.AddDays(2).ToString("yyyy-MM-ddTHH\\:mm\\:ssZ");
	    //request.ExpireTime = expireTime;//设置过期时间为2天
            //request.StoreOffline = false;
            //request.BatchNumber = "100010";
            
            try
            {
                PushResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("ResponseId:"+response.ResponseId);
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

