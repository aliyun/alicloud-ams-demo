package com.aliyun.demo.push;

import com.aliyuncs.push.model.v20150827.*;
import org.junit.Test;

import java.util.List;

/**
 * 标签操作Demo
 */
public class TagDemoTest extends BaseTest {

    /**
     * 查询App所有的标签列表
     * 参考文档 ：https://help.aliyun.com/document_detail/30089.html
     * */
    @Test
    public void testListTags() throws Exception {

        ListTagsRequest request = new ListTagsRequest();
        request.setAppKey(appKey);

        ListTagsResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId : %s\n" , response.getRequestId());

        List<ListTagsResponse.TagInfo> tagInfos = response.getTagInfos();
        for (ListTagsResponse.TagInfo tagInfo : tagInfos) {
            System.out.printf("tagName : %s\n", tagInfo.getTagName());
        }

    }

    /**
     * 查询某个设备的标签列表
     * 参考文档 ： https://help.aliyun.com/document_detail/30090.html
     * */
    @Test
    public void testQueryTag() throws Exception {

        QueryTagsRequest request = new QueryTagsRequest();
        request.setAppKey(appKey);
        request.setClientKey(deviceIds);
        request.setKeyType(1);//1 : device 2 : account 3 : alias

        QueryTagsResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId : %s\n " , response.getRequestId());

        List<QueryTagsResponse.TagInfo> tagInfos = response.getTagInfos();
        for (QueryTagsResponse.TagInfo tagInfo : tagInfos) {
            System.out.printf("tagName : %s\n", tagInfo.getTagName());
        }

    }

    /**
     * 绑定标签
     * 参考文档 ：https://help.aliyun.com/document_detail/30087.html
     * */
    @Test
    public void testBindTag() throws Exception {

        BindTagRequest request = new BindTagRequest();
        request.setAppKey(appKey);
        request.setClientKey(deviceIds);
        request.setKeyType(1);//1 : device 2 : account 3 : alias
        request.setTagName("tag1");

        BindTagResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId : %s\n " , response.getRequestId());

    }

    /**
     * 解绑标签
     * 参考文档 ：https://help.aliyun.com/document_detail/30088.html
     * */
    @Test
    public void testUnbindTag() throws Exception {

        UnbindTagRequest request = new UnbindTagRequest();
        request.setAppKey(appKey);
        request.setClientKey(deviceIds);
        request.setKeyType(1);//1 : device 2 : account 3 : alias
        request.setTagName("tag1");

        UnbindTagResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId : %s\n " , response.getRequestId());

    }

}
