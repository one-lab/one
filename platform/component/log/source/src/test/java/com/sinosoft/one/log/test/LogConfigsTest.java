package com.sinosoft.one.log.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.log.config.LogUrl;
import org.jolokia.http.AgentServlet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志动态配置测试用例
 * User: carvin
 * Date: 12-12-16
 * Time: 下午4:12
 *
 */
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
        "/spring/applicationContext-notification.xml","/spring/applicationContext-log.xml" })
@TransactionConfiguration(transactionManager = "logMonitorTransactionManager",defaultRollback=true)
@Transactional(isolation= Isolation.READ_COMMITTED)
public class LogConfigsTest extends AbstractFilterTest {
    AgentServlet servlet = null;

    @Override
    public void setUp() throws Exception{
        super.setUp();
        servlet = new AgentServlet();
        servlet.init(new MockServletConfig());
    }

    @After
    public void tearDown() throws Exception {
        if(servlet != null) {
            servlet.destroy();
        }
    }

    /**
     * 查询
     * @param type
     * @param url
     * @return
     * @throws Exception
     */
    private JSONObject query(String type, String url) throws Exception{
        MockHttpServletRequest mockHttpServletRequestForRead = new MockHttpServletRequest();
        mockHttpServletRequestForRead.setSession(session);
        mockHttpServletRequestForRead.setMethod("GET");
        mockHttpServletRequestForRead.setRequestURI("/" + type + "/log:name=LogConfigs/" + url);
        mockHttpServletRequestForRead.setPathInfo("/" + type + "/log:name=LogConfigs/" + url);
        MockHttpServletResponse mockHttpServletResponseForRead = new MockHttpServletResponse();
        servlet.service(mockHttpServletRequestForRead, mockHttpServletResponseForRead);
        return JSON.parseObject(mockHttpServletResponseForRead.getContentAsString());
    }

    /**
     * POST 操作
     * @param type
     * @param operation
     * @param arguments
     * @throws Exception
     */
    private void postOperate(String type, String operation, List<String> arguments) throws Exception {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setCharacterEncoding("UTF-8");
        mockHttpServletRequest.setSession(session);
        mockHttpServletRequest.setMethod("POST");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mbean", "log:name=LogConfigs");
        jsonObject.put("operation", operation);
        jsonObject.put("arguments", arguments);
        jsonObject.put("type", type);

        mockHttpServletRequest.setContent(jsonObject.toJSONString().getBytes());
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        servlet.service(mockHttpServletRequest, mockHttpServletResponse);
        System.out.println(mockHttpServletResponse.getContentAsString() + "=============");
    }

    /**
     * POST 操作
     * @param type
     * @param operation
     * @param arguments
     * @throws Exception
     */
    private void postWrite(String type, String attribute, String value) throws Exception {
        MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletRequest.setCharacterEncoding("UTF-8");
        mockHttpServletRequest.setSession(session);
        mockHttpServletRequest.setMethod("POST");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mbean", "log:name=LogConfigs");
        jsonObject.put("attribute", attribute);
        jsonObject.put("value", value);
        jsonObject.put("type", type);

        mockHttpServletRequest.setContent(jsonObject.toJSONString().getBytes());
        MockHttpServletResponse mockHttpServletResponse = new MockHttpServletResponse();
        servlet.service(mockHttpServletRequest, mockHttpServletResponse);
        System.out.println(mockHttpServletResponse.getContentAsString() + "=============");
    }

    /**
     * Get 操作
     * @param type
     * @param url
     * @throws Exception
     */
    private void getOperate(String type, String url) throws Exception {
        MockHttpServletRequest mockHttpServletRequestForAdd = new MockHttpServletRequest();
        mockHttpServletRequestForAdd.setCharacterEncoding("UTF-8");
        mockHttpServletRequestForAdd.setSession(session);
        mockHttpServletRequestForAdd.setMethod("GET");
        mockHttpServletRequestForAdd.setRequestURI("/" + type + "/log:name=LogConfigs/" + url);
        mockHttpServletRequestForAdd.setPathInfo("/" + type + "/log:name=LogConfigs/" + url);

        MockHttpServletResponse mockHttpServletResponseForAdd = new MockHttpServletResponse();
        servlet.service(mockHttpServletRequestForAdd, mockHttpServletResponseForAdd);
    }

    @Test
    public void testGetLogUrls() throws Exception{
        getOperate("exec", "addLogUrl/!/test1/DEVELOP/15/5");
        postOperate("exec", "addLogUrl", new ArrayList<String>() {
            {
                add("/test2");
                add("TEST");
                add("20");
                add("5");
            }
        });

        JSONObject jsonObject = query("read", "LogUrls");
        Assert.assertEquals(jsonObject.getJSONArray("value").size(), 2);
    }

    @Test
    public void testAddLogURLForPostRequest() throws Exception{
        postOperate("exec", "addLogUrl",  new ArrayList<String>() {
            {
                add("/test3/test4");
                add("PRODUCT");
                add("15");
                add("5");
            }
        });
        JSONObject resultObject = query("exec", "getLogUrl/!/test3!/test4");
        JSONObject urlObject = resultObject.getJSONObject("value");
        System.out.println(resultObject.toJSONString() + "+++++++++++++");
        Assert.assertEquals("/test3/test4", urlObject.get("url"));
        Assert.assertEquals("PRODUCT", urlObject.get("environment"));
        Assert.assertEquals(15, urlObject.get("maxExecuteTime"));
    }

    @Test
    public void testAddLogURLAndRemoveLogURLForGetRequest() throws Exception{
        getOperate("exec", "addLogUrl/!/test4!/test5/DEVELOP/10/5");

        JSONObject jsonObjectForRead = query("exec", "getLogUrl/!/test4!/test5");
        JSONObject urlObject = jsonObjectForRead.getJSONObject("value");
        Assert.assertEquals("/test4/test5", urlObject.get("url"));
        Assert.assertEquals("DEVELOP", urlObject.get("environment"));
        Assert.assertEquals(10, urlObject.get("maxExecuteTime"));
        Assert.assertEquals(5, urlObject.get("interval"));
        // 删除URL请求
        postOperate("exec", "removeLogUrl", new ArrayList<String>() {
            {
                add("/test4/test5");
            }
        });
//        getOperate("exec", "removeLogUrl/!/test4!/test5");

        jsonObjectForRead = query("exec", "getLogUrl/!/test4!/test5");
        Assert.assertEquals(null, jsonObjectForRead.get("value"));
    }

    //============================= environment config test ===================================
    @Test
    public void testPutAndGetEnvironment() throws Exception{
        postWrite("write", "Environment","TEST");

        JSONObject jsonObjectForRead = query("read", "Environment");
        System.out.println(jsonObjectForRead.toJSONString() + "=============");
        Assert.assertEquals("TEST", jsonObjectForRead.getString("value"));
    }

    //============================= log method config test ===================================
    @Test
    public void testGetLogMethods() throws Exception {
        postOperate("exec", "addLogMethod", new ArrayList<String>() {
            {
                add("com.sinosoft.one.log.test");
                add("testMethod");
                add("15");
                add("1");
                add("DEVELOP");
                add("");
            }
        });

        postOperate("exec", "addLogMethod", new ArrayList<String>() {
            {
                add("com.sinosoft.one.log.test1");
                add("testMethod1");
                add("15");
                add("5");
                add("TEST");
                add("");
            }
        });

        JSONObject resultObject = query("read", "LogMethods");
        Assert.assertEquals(resultObject.getJSONArray("value").size(), 2);
    }

    @Test
    public void testGetLogMethod() throws Exception{
        getOperate("exec", "addLogMethod/com.sinosoft.one.log.test/testMethod2/20/5/DEVELOP/testDescription");
        JSONObject resultObject = query("exec", "getLogMethod/com.sinosoft.one.log.test/testMethod2");
        JSONObject valueObject = resultObject.getJSONObject("value");
        Assert.assertEquals("com.sinosoft.one.log.test", valueObject.getString("className"));
        Assert.assertEquals("testMethod2", valueObject.getString("methodName"));
        Assert.assertEquals(20, valueObject.getIntValue("maxExecuteTime"));
        Assert.assertEquals("DEVELOP", valueObject.getString("environment"));
        Assert.assertEquals("testDescription", valueObject.getString("description"));
    }

    @Test
    public void testRemoveLogMethod() throws Exception{
        getOperate("exec", "addLogMethod/com.sinosoft.one.log.test/testMethod3/30/5/TEST/testDescription");
        JSONObject resultObject = query("exec", "getLogMethod/com.sinosoft.one.log.test/testMethod3");
        JSONObject valueObject = resultObject.getJSONObject("value");
        Assert.assertEquals("com.sinosoft.one.log.test", valueObject.getString("className"));
        Assert.assertEquals("testMethod3", valueObject.getString("methodName"));
        Assert.assertEquals(30, valueObject.getIntValue("maxExecuteTime"));
        Assert.assertEquals("TEST", valueObject.getString("environment"));
        Assert.assertEquals("testDescription", valueObject.getString("description"));

        postOperate("exec", "removeLogMethod", new ArrayList<String>() {
            {
                add("com.sinosoft.one.log.test");
                add("testMethod3");
            }
        });

        resultObject = query("exec", "getLogMethod/com.sinosoft.one.log.test/testMethod3");
        Assert.assertEquals(null, resultObject.get("value"));
    }
}
