package com.sinosoft.one.monitor.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

import freemarker.template.TemplateException;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test-mail.xml" })
public class FreeMarkerTest extends AbstractJUnit4SpringContextTests {

	private String templateName = "email_test.vm";
//	@Autowired
//	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
    private VelocityConfigurer velocityConfigurer;
//	@Test
//	public void isNotNull() {
//		//Assert.assertNotNull(freeMarkerConfigurer);
//		//Assert.assertNotNull(velocityConfigurer);
//	}
	
	@Test
	public void generateEmailContent() throws IOException, TemplateException {
		Map<String ,Object> m=new HashMap<String ,Object>();
		Vector<User> v=new Vector<User>();
		User u1=new User();
		u1.setName("离散");
		u1.setPassword("密码");
		u1.setSex("2");
		User u2=new User();
		u2.setName("name2");
		u2.setPassword("password2");
		u2.setSex("2");
		User u3=new User();
		u3.setName("name3");
		u3.setPassword("password3");
		u3.setSex("3");
		
		
		v.add(u1);
		v.add(u3);
		v.add(u2);
		m.put("l", v);
		
		//获取Velocity模板
		Template tempVelocity=velocityConfigurer.getVelocityEngine().getTemplate(templateName);
		StringWriter sw = new StringWriter();  
		//初始化Velocity
		Velocity.init();
		VelocityContext context = new VelocityContext(m);  
		tempVelocity.merge(context, sw)  ;      
		
		System.out.print(sw.toString());
	}
}

