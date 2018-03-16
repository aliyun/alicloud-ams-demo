package com.aliyun.push.demoTest;

import com.aliyuncs.push.model.v20160801.ListSummaryAppsRequest;
import com.aliyuncs.push.model.v20160801.ListSummaryAppsResponse;
import org.junit.Test;

/**
 * Created by lingbo on 16/8/15.
 */
public class AppTest extends BaseTest {

  
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

 }
