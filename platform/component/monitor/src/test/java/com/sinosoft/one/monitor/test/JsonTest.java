package com.sinosoft.one.monitor.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.model.Method;
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
		"/spring/applicationContext-log.xml" })
public class JsonTest {
	public static void main(String[] args) {
		List<Method> list=new ArrayList<Method>();
//		
//		Method m=new Method();
//		m.setClassName("testClazzName");
//		m.setGrade("testGrade");
//		m.setMethodName("testMethodName");
//		m.setStatistics("1");
//		m.setThreshold(new BigDecimal(1));
//		Method m2=new Method();
//		m2.setClazzname("testClazzName");
//		m2.setGrade("testGrade");
//		m2.setMethodname("testMethodName");
//		m2.setStatistics("1");
//		m2.setThreshold(new BigDecimal(1));
//		list.add(m);
//		list.add(m2);
//		String str=JSON.toJSONString(list);
//		System.out.println(str);
	}
}
