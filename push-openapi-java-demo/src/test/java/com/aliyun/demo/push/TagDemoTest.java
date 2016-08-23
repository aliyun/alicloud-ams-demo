package com.aliyun.demo.push;

import com.aliyuncs.push.model.v20150827.*;
import com.aliyuncs.utils.ParameterHelper;
import org.junit.Test;

import java.util.Date;

    /**
     * 标签操作Demo
     */
public class TagDemoTest extends BaseTest {

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

        @Test
        public void testQueryTag() throws Exception {

            QueryTagsRequest request = new QueryTagsRequest();
            request.setAppKey(appKey);
            request.setClientKey("yourDeviceId");
            request.setKeyType("DEVICE");

            QueryTagsResponse response = client.getAcsResponse(request);
            System.out.printf("RequestId: %s, tags: %s\n",
                    response.getRequestId(), response.getTagInfos());

        }

        @Test
        public void testBindTag() throws Exception {

            BindTagRequest request = new BindTagRequest();
            request.setAppKey(appKey);
            request.setClientKey("yourDeviceId");
            request.setKeyType("DEVICE");
            request.setTagName("tag1");

            BindTagResponse response = client.getAcsResponse(request);
            System.out.printf("RequestId: %s\n",
                    response.getRequestId());

        }

        @Test
        public void testUnbindTag() throws Exception {

            UnbindTagRequest request = new UnbindTagRequest();
            request.setAppKey(appKey);
            request.setClientKey("yourDeviceId");
            request.setKeyType("DEVICE");
            request.setTagName("tag1");

            UnbindTagResponse response = client.getAcsResponse(request);
            System.out.printf("RequestId: %s\n",
                    response.getRequestId());

        }

        @Test
        public void testDeleteTags() throws Exception {

            DeleteTagRequest request = new DeleteTagRequest();
            request.setAppKey(appKey);
            request.setTagName("tag1");

            DeleteTagResponse response = client.getAcsResponse(request);
            System.out.printf("RequestId: %s\n",
                    response.getRequestId());

        }

}
