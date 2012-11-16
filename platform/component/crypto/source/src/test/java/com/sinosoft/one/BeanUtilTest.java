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

		String a = "id,id1,id2,id3,id4,id5,aid,bid,cid1";
		System.out.println( a.matches("[id],") );

	}
}
