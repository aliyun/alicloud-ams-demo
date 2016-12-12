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
         * 参见文档 ：https://help.aliyun.com/document_detail/43592.html
         */
        @Test
        public void testQueryPushStat() throws Exception {
            QueryPushStatRequest request = new QueryPushStatRequest();
            request.setAppKey(appKey);
            request.setMessageId("_MessageId_");//此处填写推送成功后返回的ResponseId

            QueryPushStatResponse response = client.getAcsResponse(request);
            System.out.printf("RequestId: %s\n" , response.getRequestId());

            for (QueryPushStatResponse.PushStat item : response.getPushStats()) {
                System.out.printf("MessageId: %s , ReceivedCount: %s, SentCount: %s, OpenedCount: %s, DeletedCount: %s\n",
                        item.getMessageId(), item.getReceivedCount(), item.getSentCount(), item.getOpenedCount(), item.getDeletedCount());
            }
        }

        /**
         * 查询多次推送统计
         * 参见文档 ： https://help.aliyun.com/document_detail/43593.html
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
            System.out.printf("RequestId: %s\n",response.getRequestId());

            for (QueryAppPushStatResponse.AppPushStat stat : response.getAppPushStats()) {
                System.out.printf("Time: %s, ReceivedCount: %s, SentCount: %s, OpenedCount: %s, DeletedCount: %s\\\n",
                        stat.getTime(), stat.getReceivedCount(), stat.getSentCount(), stat.getOpenedCount(), stat.getDeletedCount());
            }
        }

        /**
         * 查询设备统计
         * 参见文档 ：https://help.aliyun.com/document_detail/43596.html
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
            System.out.printf("RequestId: %s\n",response.getRequestId());

            for (QueryDeviceStatResponse.AppDeviceStat stat : response.getAppDeviceStats()) {
                System.out.printf("Time: %s, DeviceType: %s, Count: %s\n",
                        stat.getTime(), stat.getDeviceType(), stat.getCount());
            }
        }

        /**
         * 查询去重设备统计
         * 参见文档 ： https://help.aliyun.com/document_detail/43598.html
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
            System.out.printf("RequestId: %s\n",response.getRequestId());

            for (QueryUniqueDeviceStatResponse.AppDeviceStat stat : response.getAppDeviceStats()) {
                System.out.printf("Time: %s, Count: %s\n",
                        stat.getTime(), stat.getCount());
            }
        }

}
