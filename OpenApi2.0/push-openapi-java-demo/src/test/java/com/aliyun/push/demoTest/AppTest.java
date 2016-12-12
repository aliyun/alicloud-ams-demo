package com.aliyun.push.demoTest;

import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.push.model.v20160801.*;
import org.junit.Test;

/**
 * Created by lingbo on 16/8/15.
 */
public class AppTest extends BaseTest {

    /**
     * 创建APP
     * 参考文档 ：https://help.aliyun.com/document_detail/48066.html
     * */
    @Test
    public void testCreateApp() throws Exception {
        CreateAppRequest request = new CreateAppRequest();
        request.setAppName("test12345678");
        request.setIndustryId(1);//1 : 社交(默认) 2 : 摄影和摄影 3 : 效率 4 : 生活 5 : 美食佳饮 6 : 工具 7 : 娱乐 8 : 游戏 9 : 儿童 10 : 教育 11 : 报刊杂志 12 : 健康健美 13 : 旅游 14 : 音乐 15 : 体育 16 : 新闻17 :  商务 18 : 参考 19 : 财务 20: 医疗 21 : 导航 22 : 天气 23 : 图书 24 : 智能物联网 25 : 其他
        request.setDescription("Keep yourself");
        CreateAppResponse response = client.getAcsResponse(request);
        System.out.println(response.getAppKey());
    }

    /**
     * 删除APP
     * 参考文档 ：https://help.aliyun.com/document_detail/48067.html
     * */
    @Test
    public void testDeleteApp() throws Exception {
        DeleteAppRequest request = new DeleteAppRequest();
        request.setAppKey(appKey);
        DeleteAppResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());
    }

    /**
     * APP列表
     * 参考文档 ：https://help.aliyun.com/document_detail/48068.html
     * */
    @Test
    public void testListApps() throws Exception {
        ListAppsRequest request = new ListAppsRequest();
        ListAppsResponse response = client.getAcsResponse(request);
        for(ListAppsResponse.AppInfo appInfo : response.getAppInfos()){
            System.out.println(appInfo.getAppKey()+" "+appInfo.getAppName()+" "+appInfo.getDescription());
        }
    }

    /**
     * 查询APP详情
     * 参考文档 ：https://help.aliyun.com/document_detail/48070.html
     * */
    @Test
    public void testQueryAppInfo() throws Exception {
        QueryAppInfoRequest request = new QueryAppInfoRequest();
        //安全性比较高的内容建议使用HTTPS
        request.setProtocol(ProtocolType.HTTPS);
        request.setAppKey(60027911l);
        QueryAppInfoResponse response = client.getAcsResponse(request);
        QueryAppInfoResponse.AppInfo appInfo = response.getAppInfo();
        System.out.println(appInfo.getAppKey() +" "+appInfo.getAppName() +" "+appInfo.getDescription());
    }

    /**
     * 查询APP安全信息
     * 参考文档 ：https://help.aliyun.com/document_detail/48071.html
     * */
    @Test
    public void testQueryAppSecurityInfo() throws Exception {
        QueryAppSecurityInfoRequest request = new QueryAppSecurityInfoRequest();
        //安全性比较高的内容建议使用HTTPS
        request.setProtocol(ProtocolType.HTTPS);
        request.setAppKey(60027911l);
        QueryAppSecurityInfoResponse response = client.getAcsResponse(request);
        System.out.println(response.getAppKey() +" "+response.getAppSecret());
    }

    /**
     * APP概览列表
     * 参考文档 ：https://help.aliyun.com/document_detail/48069.html
     * */
    @Test
    public void testListSummaryApps() throws Exception {
        ListSummaryAppsRequest request = new ListSummaryAppsRequest();
        ListSummaryAppsResponse response = client.getAcsResponse(request);
        for (ListSummaryAppsResponse.SummaryAppInfo summaryAppInfo : response.getSummaryAppInfos()){
            System.out.println(summaryAppInfo.getAppKey() +" " +summaryAppInfo.getAppName());
        }
    }

    /**
     * 查询APP配置信息
     * 参考文档 ：https://help.aliyun.com/document_detail/48072.html
     * */
    @Test
    public void testQueryAppConfig() throws Exception{
        QueryAppConfigRequest request = new QueryAppConfigRequest();
        //安全性比较高的内容建议使用HTTPS
        request.setProtocol(ProtocolType.HTTPS);
        request.setAppKey(60027911l);
        QueryAppConfigResponse response = client.getAcsResponse(request);
        QueryAppConfigResponse.AppConfig appConfig = response.getAppConfig();
        System.out.println(appConfig.getAppKey() + " " +appConfig.getAppId());
    }

    /**
     * 修改APP配置信息
     * 参考文档 ：https://help.aliyun.com/document_detail/48074.html
     * */
    @Test
    public void testModifyAppConfig() throws Exception {
        ModifyAppConfigRequest request = new ModifyAppConfigRequest();
        //安全性比较高的内容建议使用HTTPS
        request.setProtocol(ProtocolType.HTTPS);
        request.setAppKey(60027911l);
        request.setPackageName("com.alibaba.org");
        ModifyAppConfigResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());
    }

    /**
     * 修改APP扩展信息
     * 参考文档 ：https://help.aliyun.com/document_detail/48073.html
     * */
    @Test
    public void testModifyAppExtensions() throws Exception {
        ModifyAppExtensionsRequest request = new ModifyAppExtensionsRequest();
        //安全性比较高的内容建议使用HTTPS
        request.setProtocol(ProtocolType.HTTPS);
        request.setAppKey(60027911l);
        request.setHwAppKey("214234234");
        ModifyAppExtensionsResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());
    }
    /**
     * 上传iOS证书
     * 参考文档 ：https://help.aliyun.com/document_detail/48075.html
     * */
    @Test
    public void testUploadFile() throws Exception {

        UploadAppCertRequest request = new UploadAppCertRequest();
        //安全性比较高的内容建议使用HTTPS
        request.setProtocol(ProtocolType.HTTPS);
        //内容较大的请求，使用POST请求
        request.setMethod(MethodType.POST);
        request.setAppKey(60027911l);
        request.setFileItem("12131231231");
        request.setIsDevCert(true);

        UploadAppCertResponse response = client.getAcsResponse(request);

        System.out.println(response.getRequestId());
    }
}
