package com.sinosoft.one;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Morgan
 * Date: 12-11-8
 * Time: 下午4:50
 */
public class BeanUtilTest {

	public static void main(String[] args) throws NoSuchMethodException {
		User user = new User();
		try {
//			String age = BeanUtils.getProperty(user,"age");
//
//			PropertyDescriptor desc = org.springframework.beans.BeanUtils.getPropertyDescriptor(user.getClass(), "bb");
//			Class<?> type = desc.getPropertyType();
//			if( type.getName().contains("List") ){
//				BeanUtils.setProperty(user,"bb",new ArrayList(10));
//			}
//			String prop = BeanUtils.getProperty(user, "bb");
//			BeanUtils.setProperty(user,"age","abcd");
//			BeanUtils.setProperty(user,"id","123");
//
//			BeanUtils.setProperty(user,"aa(key)","123");
//			boolean a = org.springframework.beans.BeanUtils.isSimpleProperty(user.getClass());
//			boolean b = org.springframework.beans.BeanUtils.isSimpleValueType(user.getClass());
			user.setId("aaaaa");
			user.setId2("bbbbbb");
			user.setId3("bbbbbbb");
			Map<String,String> map = new HashMap<String, String>();
			map.put("id2","1111");
			map.put("id3","2222");
			BeanUtils.populate(user,map);
			user.getId2();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
