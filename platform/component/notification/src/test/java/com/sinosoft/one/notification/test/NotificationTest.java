package com.sinosoft.one.notification.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.sinosoft.one.util.test.SpringContextTestCase;
import com.sinosoft.one.util.thread.ThreadUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.sinosoft.one.notification.NotificationEvent;
import com.sinosoft.one.notification.NotificationModule;
import com.sinosoft.one.notification.service.facade.NotificationService;
@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-notification-test.xml" })
public class NotificationTest  extends SpringContextTestCase {
    @Autowired
    private NotificationService notificationService;
    /*
      * 测试notificationService是否可用,只测试功能是否可用
      */
    @Test
    public void testNotification() throws UnsupportedEncodingException {
//		List<String> tels = new ArrayList<String>();
//		tels.add("15210609387");
//		List<String> emails = new ArrayList<String>();
//		emails.add("email1");
//		emails.add("email2");
//		emails.add("email3");
        System.out.print("begin-------");
        // Notification.notify(tels.iterator(), emails.iterator(),
        // "title xxx","----xxxxx---", NotificationModule.OSAGENT);

        String title = URLEncoder.encode("中文    测试","GBK");
        title="中文    测试";
//		System.out.println("1"+title);
//		title=URLEncoder.encode(title,"GBK");
//		System.out.println("2"+title);
        String content = URLEncoder.encode("notification模块测试    ff&fk  afj&akjfk","GBK");
        content="notification模块测试    ff&fk  afj&akjfk";
//		NotificationEvent event = new NotificationEvent(tels.iterator(),
//				null, title, content, NotificationModule.EXCEPTION);
        NotificationEvent event = new NotificationEvent("1",
                "0", title, content, NotificationModule.EXCEPTION);
        notificationService.notification(event);
        System.out.print("end-------");
        ThreadUtils.sleep(1000 * 4);
    }
}
