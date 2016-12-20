using Aliyun.Acs.Core;
using Aliyun.Acs.Core.Exceptions;
using Aliyun.Acs.Core.Profile;
using Aliyun.Acs.Push.Model.V20160801;
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
            //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
            request.Target = "ALL";
            //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
            request.TargetValue = "all";
            //消息类型 MESSAGE NOTICE
	    request.PushType = "NOTICE";
	    //设备类型 ANDROID iOS ALL.
            request.DeviceType = "ALL";
            // 消息的标题
            request.Title = "Push Title";
            // 消息的内容
            request.Body = "Push body";
            
	    // 推送配置: iOS
            // iOS应用图标右上角角标
            request.IOSBadge = 50;
	    //开启静默通知
            request.IOSSilentNotification = false;
            // iOS通知声音
            request.IOSMusic = "default";
	    //iOS10通知副标题的内容
	    request.IOSSubtitle = "iOS10 subtitle";
	    //指定iOS10通知Category
	    request.IOSNotificationCategory = "iOS10 Notification Category";
	    //是否允许扩展iOS通知内容
	    request.IOSMutableContent = true;	
	    //iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
	    request.IOSApnsEnv = "DEV";
	    //消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
	    request.IOSRemind = true;
	    //iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
	    request.IOSRemindBody = "iOSRemindBody";
            //自定义的kv结构,开发者扩展用 针对iOS设备
            request.IOSExtParameters = "{\"key1\":\"value1\"}";
           
	    // 推送配置: Android
            // 通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
            request.AndroidNotifyType = "BOTH";
	    //通知栏自定义样式0-100
	    request.AndroidNotificationBarType = 3;
	    //通知栏显示优先级
	    request.AndroidNotificationBarPriority = 0;
	    //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
	    request.AndroidOpenType = "NONE";
	    //Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
            request.AndroidOpenUrl = "http://www.baidu.com";
            //设定通知打开的activity，仅当AndroidOpenType="Activity"有效
	    request.AndroidActivity = "com.alibaba.push2.demo.XiaoMiPushActivity";
	    //Android通知音乐
	    request.AndroidMusic = "default";
	    //设置该参数后启动小米托管弹窗功能，此处指定通知点击后跳转的Activity（托管弹窗的前提条件：1. 继承小米辅助通道；2. storeOffline设为true)
            request.AndroidXiaoMiActivity  = "com.ali.demo.MiActivity";
            //小米弹窗标题
	    request.AndroidXiaoMiNotifyTitle = "Mi Title";
	    //小米弹窗内容
	    request.AndroidXiaoMiNotifyBody = "MiActivity Body";
	    // 设定android类型设备通知的扩展属性
            request.AndroidExtParameters = "{\"k1\":\"android\",\"k2\":\"v2\"}";

            // 推送控制
	    String pushTime = DateTime.UtcNow.AddSeconds(3).ToString("yyyy-MM-ddTHH\\:mm\\:ssZ");
	    request.PushTime = pushTime;//延迟3秒发送
	    String expireTime = DateTime.UtcNow.AddDays(2).ToString("yyyy-MM-ddTHH\\:mm\\:ssZ");
	    request.ExpireTime = expireTime;//设置过期时间为2天
            request.StoreOffline = false;
            
            try
            {
                PushResponse response = client.GetAcsResponse(request);
                Console.WriteLine("RequestId:" + response.RequestId);
                Console.WriteLine("ResponseId:"+response.MessageId);
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

