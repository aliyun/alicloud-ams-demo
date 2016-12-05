package com.aliyun.push.demoTest;

import com.aliyuncs.push.model.v20160801.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by lingbo on 16/8/15.
 */
public class TagTest extends BaseTest {

    /**
     * 查询某个APP的Tag列表
     */

    @Test
    public void testListTags() throws Exception {

        ListTagsRequest request = new ListTagsRequest();
        request.setAppKey(appKey);

        ListTagsResponse response = client.getAcsResponse(request);
        List<ListTagsResponse.TagInfo> tagInfos = response.getTagInfos();
        for (ListTagsResponse.TagInfo tagInfo : tagInfos) {
            System.out.printf("tagName: %s \n" , tagInfo.getTagName());
        }

    }

    /**
     * 查询某个对象的所有Tag列表
     */

    @Test
    public void testQueryTag() throws Exception {

        QueryTagsRequest request = new QueryTagsRequest();
        request.setAppKey(appKey);
        request.setKeyType("DEVICE");//DEVICE：是设备，ACCOUNT：是账号，ALIAS：是别名
        request.setClientKey(deviceIds);


        QueryTagsResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s, tags: %s\n",
                response.getRequestId(), response.getTagInfos().size());
        for(QueryTagsResponse.TagInfo info : response.getTagInfos()){
            System.out.println("tagName : " + info.getTagName());
        }

    }
    /**
     * 绑定Tag
     */
    @Test
    public void testBindTag() throws Exception {

        BindTagRequest request = new BindTagRequest();
        request.setAppKey(appKey);
        request.setKeyType("DEVICE");//DEVICE：是设备，ACCOUNT：是账号，ALIAS：是别名
        request.setClientKey(deviceIds);
        request.setTagName(tag);//tag长度限制为128Byte,一个App最多绑定128个tag

        BindTagResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",
                response.getRequestId());

    }
    /**
     * 解绑Tag
     */
    @Test
    public void testUnbindTag() throws Exception {

        UnbindTagRequest request = new UnbindTagRequest();
        request.setAppKey(appKey);
        request.setClientKey(deviceIds);
        request.setKeyType("DEVICE");//DEVICE：是设备，ACCOUNT：是账号，ALIAS：是别名
        request.setTagName(tag);

        UnbindTagResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",
                response.getRequestId());

    }

}
