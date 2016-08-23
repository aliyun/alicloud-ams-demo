package com.aliyun.demo.push;

import com.aliyuncs.push.model.v20150827.*;
import com.aliyuncs.utils.ParameterHelper;
import org.junit.Test;

import java.util.Date;

    /**
     * 推送统计分组测试
     */
public class StatDemoTest extends BaseTest {

        /**
         * 查询某次推送统计
         */
        @Test
        public void testQueryPushStat() throws Exception {
            QueryPushStatRequest request = new QueryPushStatRequest();
            request.setAppKey(appKey);
            request.setMessageId("500345");

            QueryPushStatResponse response = client.getAcsResponse(request);
            for (QueryPushStatResponse.PushStat item : response.getPushStats()) {
                System.out.printf("RequestId: %s, ReceivedCount: %s, SentCount: %s, MessageId: %s \n",
                        response.getRequestId(), item.getReceivedCount(), item.getSentCount(), item.getMessageId());
            }
        }

        /**
         * 查询多次推送统计
         */
        @Test
        public void testQueryAppPushStat() throws Exception {

            QueryAppPushStatRequest request = new QueryAppPushStatRequest();
            request.setAppKey(appKey);
            request.setGranularity("DAY");

            final Date startDate = new Date(System.currentTimeMillis() - 3 * 24 * 3600 * 1000);
            final String startTime = ParameterHelper.getISO8601Time(startDate);
            final Date endDate = new Date(System.currentTimeMillis());
            final String endTime = ParameterHelper.getISO8601Time(endDate);


            request.setStartTime(startTime);
            request.setEndTime(endTime);

            QueryAppPushStatResponse response = client.getAcsResponse(request);

            for (QueryAppPushStatResponse.AppPushStat stat : response.getAppPushStats()) {
                System.out.printf("RequestId: %s, time: %s, ReceivedCount: %s, SentCount: %s \n",
                        response.getRequestId(), stat.getTime(), stat.getReceivedCount(), stat.getSentCount());
            }
        }

        /**
         * 查询设备统计
         */
        @Test
        public void testQueryDeviceStat() throws Exception {
            QueryDeviceStatRequest request = new QueryDeviceStatRequest();
            request.setAppKey(appKey);
            request.setQueryType("Total");
            request.setDeviceType("All");

            final Date startDate = new Date(System.currentTimeMillis() - 7 * 24 * 3600 * 1000);
            final String startTime = ParameterHelper.getISO8601Time(startDate);
            final Date endDate = new Date(System.currentTimeMillis());
            final String endTime = ParameterHelper.getISO8601Time(endDate);


            request.setStartTime(startTime);
            request.setEndTime(endTime);

            QueryDeviceStatResponse response = client.getAcsResponse(request);
            for (QueryDeviceStatResponse.AppDeviceStat stat : response.getAppDeviceStats()) {
                System.out.printf("RequestId: %s, DeviceType: %s, time: %s, count: %s \n",
                        response.getRequestId(), stat.getDeviceType(), stat.getTime(), stat.getCount());
            }
        }

        /**
         * 查询去重设备统计
         */
        @Test
        public void testQueryUniqueDeviceStat() throws Exception {

            QueryUniqueDeviceStatRequest request = new QueryUniqueDeviceStatRequest();
            request.setAppKey(appKey);


            final Date startDate = new Date(System.currentTimeMillis() - 24 * 3600 * 1000);
            final String startTime = ParameterHelper.getISO8601Time(startDate);
            final Date endDate = new Date(System.currentTimeMillis());
            final String endTime = ParameterHelper.getISO8601Time(endDate);


            request.setStartTime(startTime);
            request.setEndTime(endTime);

            QueryUniqueDeviceStatResponse response = client.getAcsResponse(request);

            for (QueryUniqueDeviceStatResponse.AppDeviceStat stat : response.getAppDeviceStats()) {
                System.out.printf("RequestId: %s, count: %s, time: %s \n",
                        response.getRequestId(), stat.getCount(), stat.getTime());
            }
        }

}
