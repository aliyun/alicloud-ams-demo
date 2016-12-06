package com.aliyun.push.demoTest;

import com.aliyuncs.push.model.v20160801.*;
import com.aliyuncs.utils.ParameterHelper;
import java.util.Date;
import org.junit.Test;

/**
 * Created by lingbo on 16/8/25.
 */
public class StatTest extends BaseTest {

    /**
     * 查询某次推送统计
     * 查询: 发送数,到达数,打开数,删除数
     */
    @Test
    public void testQueryPushStatByMsg() throws Exception {
        QueryPushStatByMsgRequest request = new QueryPushStatByMsgRequest();
        request.setAppKey(appKey);
        request.setMessageId("500028");//消息推送后返回的MessageID

        QueryPushStatByMsgResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n" , response.getRequestId());

        for (QueryPushStatByMsgResponse.PushStat item : response.getPushStats()) {
            System.out.printf("MessageId: %s , SentCount: %s, ReceivedCount: %s, OpenedCount: %s, DeletedCount: %s\n",
                    item.getMessageId(), item.getSentCount() ,item.getReceivedCount(),item.getOpenedCount(),item.getDeletedCount());
        }
    }

    /**
     * 查询多次推送统计
     */
    @Test
    public void testQueryPushStatByApp() throws Exception {

        QueryPushStatByAppRequest request = new QueryPushStatByAppRequest();
        request.setAppKey(appKey);
        request.setGranularity("DAY");//DAY: 天粒度

        Date startDate = new Date(System.currentTimeMillis() - 3 * 24 * 3600 * 1000);
        String startTime = ParameterHelper.getISO8601Time(startDate);
        Date endDate = new Date(System.currentTimeMillis());
        String endTime = ParameterHelper.getISO8601Time(endDate);

        request.setStartTime(startTime);
        request.setEndTime(endTime);

        QueryPushStatByAppResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",response.getRequestId());

        for (QueryPushStatByAppResponse.AppPushStat item : response.getAppPushStats()) {
            System.out.printf("Time: %s , SentCount: %s, ReceivedCount: %s, OpenedCount: %s, DeletedCount: %s\n",
                    item.getTime(), item.getSentCount() ,item.getReceivedCount(),item.getOpenedCount(),item.getDeletedCount());
        }
    }

    /**
     * 查询设备统计
     */
    @Test
    public void testQueryDeviceStat() throws Exception {
        QueryDeviceStatRequest request = new QueryDeviceStatRequest();
        request.setAppKey(appKey);
        request.setQueryType("NEW");//NEW: 新增设备查询, TOTAL: 留存设备查询
        request.setDeviceType("iOS");//iOS,ANDROID,ALL

        Date startDate = new Date(System.currentTimeMillis() - 7 * 24 * 3600 * 1000);
        String startTime = ParameterHelper.getISO8601Time(startDate);
        Date endDate = new Date(System.currentTimeMillis());
        String endTime = ParameterHelper.getISO8601Time(endDate);


        request.setStartTime(startTime);
        request.setEndTime(endTime);

        QueryDeviceStatResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",response.getRequestId());

        for (QueryDeviceStatResponse.AppDeviceStat stat : response.getAppDeviceStats()) {
            System.out.printf("Time: %s, DeviceType: %s, Count: %s\n",
                    stat.getTime(), stat.getDeviceType(), stat.getCount());
        }
    }

    /**
     * 查询去重设备统计
     */
    @Test
    public void testQueryUniqueDeviceStat() throws Exception {

        QueryUniqueDeviceStatRequest request = new QueryUniqueDeviceStatRequest();
        request.setAppKey(appKey);
        request.setGranularity("DAY");//DAY: 天粒度 MONTH: 月粒度

        Date startDate = new Date(System.currentTimeMillis() - 7 * 24 * 3600 * 1000);
        String startTime = ParameterHelper.getISO8601Time(startDate);
        Date endDate = new Date(System.currentTimeMillis());
        String endTime = ParameterHelper.getISO8601Time(endDate);


        request.setStartTime(startTime);
        request.setEndTime(endTime);

        QueryUniqueDeviceStatResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",response.getRequestId());

        for (QueryUniqueDeviceStatResponse.AppDeviceStat stat : response.getAppDeviceStats()) {
            System.out.printf("Time: %s, Count: %s\n",
                    stat.getTime(), stat.getCount());
        }
    }

}
