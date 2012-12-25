package com.sinosoft.one.notification.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.sinosoft.one.notification.NotificationEvent;
import com.sinosoft.one.notification.NotificationEventWrapper;

public class NotificationEventWrapperTest {
    /*
      * 测试NotificationEventWrapperTest里边的方法
      */
    @Test
    public void wrapperTest() {
        List<String> tels = new ArrayList<String>();
        tels.add("tel1");
        tels.add("tel2");
        tels.add("tel3");
        List<String> emails = new ArrayList<String>();
        emails.add("email1");
        emails.add("email2");
        emails.add("email3");
        String url = "http://10.0.68.123:9001/monitor/monitor/notification.do?";
        String param_tel = "isSendSms";
        String param_email = "isSendEmail";
        String param_title = "title";
        String param_content = "content";
        String title = "xx中文x& xxx";
        String content = "afa  sdfasf&akfj   kafj&akjfk";
        // NotificationEvent event = new NotificationEvent(tels.iterator(),
        // emails.iterator(), title, content, null);
        NotificationEvent event = new NotificationEvent("1", "1", title,
                content, null);
        StringBuffer urlAppend = new StringBuffer(url);
        NotificationEventWrapper wrapper = new NotificationEventWrapper(event);
        urlAppend.append(wrapper.getIsSendSmsParam(param_tel))
                .append(wrapper.getIsSendEmailParam(param_email))
                .append(wrapper.getTitleParam(param_title))
                .append(wrapper.getContentParam(param_content))
                .append("appName=online");
        System.out.println("1----"+urlAppend.toString());
        Assert.assertEquals(
                "http://10.0.68.123:9001/monitor/monitor/notification.do?isSendSms=1&isSendEmail=1&title=xx%D6%D0%CE%C4x%26+xxx&content=afa++sdfasf%26akfj+++kafj%26akjfk&appName=online",
                urlAppend.toString());

        param_tel = "isSendSms";
        param_email = "isSendEmail";
        param_title = "title";
        param_content = "content";
        title = "";
        content = "afa 中文 sdfasf&akfj   kafj&akjfk";
        event = new NotificationEvent("1", "0", title, content,
                null);
        urlAppend = new StringBuffer(url);
        wrapper = new NotificationEventWrapper(event);
        urlAppend.append(wrapper.getIsSendSmsParam(param_tel))
                .append(wrapper.getIsSendEmailParam(param_email))
                .append(wrapper.getTitleParam(param_title))
                .append(wrapper.getContentParam(param_content))
                .append("appName=online");
        System.out.println("2---"+urlAppend.toString());
        Assert.assertEquals(
                "http://10.0.68.123:9001/monitor/monitor/notification.do?isSendSms=1&isSendEmail=0&title=no+title&content=afa+%D6%D0%CE%C4+sdfasf%26akfj+++kafj%26akjfk&appName=online",
                urlAppend.toString());
    }
}
