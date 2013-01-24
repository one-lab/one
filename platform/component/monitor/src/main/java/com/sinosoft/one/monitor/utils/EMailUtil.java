package com.sinosoft.one.monitor.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.model.Mailinfo;
import com.sinosoft.one.monitor.model.Warn;
import com.sinosoft.one.monitor.service.MailService;

@Component
public class EMailUtil {
	@Autowired
	private static MailService mailService;
	public static void sendEMail(Warn warn){
////		warn.getContent();
////		warn.getAppid();
////		warn.getGrade();
////		warn.getOccurdate();
////		warn.getTitle();
//		Mailinfo m=new Mailinfo();
//		Map<String,String> map=new HashMap<String,String>();
//		m.setContent("这里是content");
//		m.setSendto("gongweitao@163.com");
//		m.setSubject("主题subject");
//		map.put("subject", "主题");
//		map.put("sendto", "18606862418@163.com");
//		map.put("content", "这是主题内容content");
//		mailService.sendMimeMail(map);
	}
}
