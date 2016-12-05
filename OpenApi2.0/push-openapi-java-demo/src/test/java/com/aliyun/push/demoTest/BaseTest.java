package com.aliyun.push.demoTest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.junit.BeforeClass;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

/**
 * 推送的OpenAPI文档 https://help.aliyun.com/document_detail/mobilepush/api-reference/openapi.html
 */
public class BaseTest {
    private static final String REGION_HANGZHOU = "cn-hangzhou";

    protected static long appKey;
    protected static String deviceIds;
    protected static String accounts;
    protected static String alias;
    protected static String tag;

    protected static DefaultAcsClient client;

    /**
     * 从配置文件中读取配置值，初始化Client
     * <p>
     * 1. 如何获取 accessKeyId/accessKeySecret/appKey 照见README.md 中的说明<br/>
     * 2. 先在 push.properties 配置文件中 填入你的获取的值
     */
    @BeforeClass
    public static void beforeClass() throws Exception {
        InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("push.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String accessKeyId = properties.getProperty("accessKeyId");
        assertNotNull("先在 push.properties 配置文件中配置 accessKeyId", accessKeyId);

        String accessKeySecret = properties.getProperty("accessKeySecret");
        assertNotNull("先在 push.properties 配置文件中配置 accessKeySecret", accessKeySecret);

        String key = properties.getProperty("appKey");
        assertNotNull("先在 push.properties 配置文件中配置 appKey", key);

        appKey = Long.valueOf(key);
        deviceIds = properties.getProperty("deviceIds");
        accounts = properties.getProperty("accounts");
        alias = properties.getProperty("alias");
        tag = properties.getProperty("tag");

        IClientProfile profile = DefaultProfile.getProfile(REGION_HANGZHOU, accessKeyId, accessKeySecret);
        client = new DefaultAcsClient(profile);
    }
}
