package com.aliyun.push.demoTest;

import com.aliyuncs.push.model.v20160801.*;
import org.junit.Test;

/**
 * Created by lingbo on 16/8/15.
 */
public class AppTest extends BaseTest {

    @Test
    public void testCreateApp() throws Exception {
        CreateAppRequest request = new CreateAppRequest();
        request.setAppName("test12345678");
        request.setIndustryId(1);//1 : 社交(默认) 2 : 摄影和摄影 3 : 效率 4 : 生活 5 : 美食佳饮 6 : 工具 7 : 娱乐 8 : 游戏 9 : 儿童 10 : 教育 11 : 报刊杂志 12 : 健康健美 13 : 旅游 14 : 音乐 15 : 体育 16 : 新闻17 :  商务 18 : 参考 19 : 财务 20: 医疗 21 : 导航 22 : 天气 23 : 图书 24 : 智能物联网 25 : 其他
        request.setDescription("Keep yourself");
        CreateAppResponse response = client.getAcsResponse(request);
        System.out.println(response.getAppKey());
    }

    @Test
    public void testDeleteApp() throws Exception {
        DeleteAppRequest request = new DeleteAppRequest();
        request.setAppKey(appKey);
        DeleteAppResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());
    }

    @Test
    public void testListApps() throws Exception {
        ListAppsRequest request = new ListAppsRequest();
        ListAppsResponse response = client.getAcsResponse(request);
        for(ListAppsResponse.AppInfo appInfo : response.getAppInfos()){
            System.out.println(appInfo.getAppKey()+" "+appInfo.getAppName()+" "+appInfo.getDescription());
        }
    }

    @Test
    public void testQueryAppInfo() throws Exception {
        QueryAppInfoRequest request = new QueryAppInfoRequest();
        request.setAppKey(60027911l);
        QueryAppInfoResponse response = client.getAcsResponse(request);
        QueryAppInfoResponse.AppInfo appInfo = response.getAppInfo();
        System.out.println(appInfo.getAppKey() +" "+appInfo.getAppName() +" "+appInfo.getDescription());
    }

    @Test
    public void testQueryAppSecurityInfo() throws Exception {
        QueryAppSecurityInfoRequest request = new QueryAppSecurityInfoRequest();
        request.setAppKey(60027911l);
        QueryAppSecurityInfoResponse response = client.getAcsResponse(request);
        System.out.println(response.getAppKey() +" "+response.getAppSecret());
    }

    @Test
    public void testListSummaryApps() throws Exception {
        ListSummaryAppsRequest request = new ListSummaryAppsRequest();
        ListSummaryAppsResponse response = client.getAcsResponse(request);
        for (ListSummaryAppsResponse.SummaryAppInfo summaryAppInfo : response.getSummaryAppInfos()){
            System.out.println(summaryAppInfo.getAppKey() +" " +summaryAppInfo.getAppName());
        }
    }

    @Test
    public void testQueryAppConfig() throws Exception{
        QueryAppConfigRequest request = new QueryAppConfigRequest();
        request.setAppKey(60027911l);
        QueryAppConfigResponse response = client.getAcsResponse(request);
        QueryAppConfigResponse.AppConfig appConfig = response.getAppConfig();
        System.out.println(appConfig.getAppKey() + " " +appConfig.getAppId());
    }

    @Test
    public void testModifyAppConfig() throws Exception {
        ModifyAppConfigRequest request = new ModifyAppConfigRequest();
        request.setAppKey(60027911l);
        request.setPackageName("com.alibaba.org");
        ModifyAppConfigResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());
    }

    @Test
    public void testModifyAppExtensions() throws Exception {
        ModifyAppExtensionsRequest request = new ModifyAppExtensionsRequest();
        request.setAppKey(60027911l);
        request.setHwAppKey("214234234");
        ModifyAppExtensionsResponse response = client.getAcsResponse(request);
        System.out.println(response.getRequestId());
    }
    @Test
    public void testUploadFile() throws Exception {

        UploadAppCertRequest request = new UploadAppCertRequest();
        request.setAppKey(60027911l);
        request.setFileItem("12131231231");
        request.setIsDevCert(true);

        UploadAppCertResponse response = client.getAcsResponse(request);

        System.out.println(response.getRequestId());
    }
}
