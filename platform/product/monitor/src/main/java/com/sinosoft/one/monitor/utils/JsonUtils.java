package com.sinosoft.one.monitor.utils;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;


public class JsonUtils {
	private ObjectMapper mapper;
	private JsonUtils(){
		mapper=new ObjectMapper();
		//设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
	}
	
	public String toJson(Object object) {

		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			return null;
		}
	}
}
