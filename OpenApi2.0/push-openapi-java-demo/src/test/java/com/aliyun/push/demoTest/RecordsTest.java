package com.aliyun.push.demoTest;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.push.model.v20160801.ListPushRecordsRequest;
import com.aliyuncs.push.model.v20160801.ListPushRecordsResponse;
import com.aliyuncs.push.model.v20160801.QueryPushDetailRequest;
import com.aliyuncs.push.model.v20160801.QueryPushDetailResponse;
import com.aliyuncs.utils.ParameterHelper;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lingbo on 16/8/15.
 */
public class RecordsTest extends BaseTest {

    /**
     * 查询推送列表
     * 参考文档 ：https://help.aliyun.com/document_detail/48095.html
     */
    @Test
    public void testMessageList() throws Exception {
            ListPushRecordsRequest request = new ListPushRecordsRequest();
            request.setAppKey(appKey);
            request.setPushType("NOTICE");//MESSAGE: 消息 NOTICE : 通知
            Date startDate = new Date(System.currentTimeMillis() - 7*24 *3600 * 1000); // 30秒之间的时间点, 也可以设置成你指定固定时间
            String startTime = ParameterHelper.getISO8601Time(startDate);
            Date endDate = new Date(); // 30秒之间的时间点, 也可以设置成你指定固定时间
            String endTime = ParameterHelper.getISO8601Time(endDate);
            request.setStartTime(startTime);
            request.setEndTime(endTime);
            request.setPage(1);//默认1
            request.setPageSize(20);//默认20
            ListPushRecordsResponse response = client.getAcsResponse(request);
        for (ListPushRecordsResponse.PushMessageInfo pushMessageInfo : response.getPushMessageInfos()) {
            System.out.printf("AppName: %s\tPushTime: %s\tMessageId: %d\tPushType: %s\tDeviceType: %s\tTitle: %s\tBody: %s\n",pushMessageInfo.getAppName(),pushMessageInfo.getPushTime(),pushMessageInfo.getMessageId(),
                    pushMessageInfo.getType(),pushMessageInfo.getDeviceType(),pushMessageInfo.getTitle(),pushMessageInfo.getBody());
        }
    }
    /**
     * 查询推送配置详情
     * 参考文档 ：https://help.aliyun.com/document_detail/48096.html
     */
    @Test
    public void testPushDetail() throws Exception {
        QueryPushDetailRequest request = new QueryPushDetailRequest();
        request.setAppKey(appKey);
        request.setMessageId(503360l);

        QueryPushDetailResponse response = client.getAcsResponse(request);

        System.out.print(JSON.toJSONString(response));
    }
}
