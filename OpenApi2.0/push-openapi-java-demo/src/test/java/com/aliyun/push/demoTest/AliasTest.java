package com.aliyun.push.demoTest;

import com.aliyuncs.push.model.v20160801.*;
import org.junit.Test;

/**
 * Created by lingbo on 16/8/15.
 */
public class AliasTest extends BaseTest {

    /**
     * 查询别名
     * 参考文档 ：https://help.aliyun.com/document_detail/48078.html
     */
    @Test
    public void testQueryAlias() throws Exception {

        QueryAliasesRequest request = new QueryAliasesRequest();
        request.setAppKey(appKey);
        request.setDeviceId(deviceIds);

        QueryAliasesResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",
                response.getRequestId());
        for(QueryAliasesResponse.AliasInfo aliasInfo : response.getAliasInfos()){
            System.out.println("aliasName: " + aliasInfo.getAliasName());
        }

    }

    /**
     * 绑定别名
     * 参考文档 ：https://help.aliyun.com/document_detail/48079.html
     */

    @Test
    public void testBindAlias() throws Exception {

        BindAliasRequest request = new BindAliasRequest();
        request.setAppKey(appKey);
        request.setDeviceId(deviceIds);
        request.setAliasName(alias);//别名的长度限制为128Byte,一个设备最多绑定128个别名

        BindAliasResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",
                response.getRequestId());

    }

    /**
     * 解绑别名
     * https://help.aliyun.com/document_detail/48080.html
     */

    @Test
    public void testUnbindAlias() throws Exception {

        UnbindAliasRequest request = new UnbindAliasRequest();
        request.setAppKey(appKey);
        request.setDeviceId(deviceIds);
        request.setAliasName(alias);

        UnbindAliasResponse response = client.getAcsResponse(request);
        System.out.printf("RequestId: %s\n",
                response.getRequestId());

    }

}
