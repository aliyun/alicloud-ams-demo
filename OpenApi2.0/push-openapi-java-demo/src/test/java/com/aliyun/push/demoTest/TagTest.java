package com.aliyun.push.demoTest;

import com.aliyuncs.push.model.v20160801.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by lingbo on 16/8/15.
 */
public class TagTest extends BaseTest {

    /**
     * TAG列表
     * 参考文档 ：https://help.aliyun.com/document_detail/48082.html
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
     * 查询TAG
     * https://help.aliyun.com/document_detail/48081.html?
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
     * 绑定TAG
     * 参考文档 ：https://help.aliyun.com/document_detail/48083.html
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
     * 解绑TAG
     * 参考文档 ：https://help.aliyun.com/document_detail/48084.html
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
