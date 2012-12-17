package com.sinosoft.one.commonTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class CommonTest {

	@Test
	public void reflectTest() throws Exception {
		String bean1 = "123";
		Combo bean2 = new Combo();
		bean2.setCode("abc");
		bean2.setNo(1);
		KindPack kp = new KindPack();
		kp.setKindCode("123abc");
		kp.setKindName("test");
		bean2.setKindPack(kp);

		Map bean3 = new HashMap<String, Combo>();
		List<?> bean4 = new ArrayList<Combo>();

		int a = 3;
		Object bean5 = new Integer(a);
		String value = "";
		if (BeanUtils.isSimpleProperty(bean5.getClass())) {
			value = bean5.toString();
			System.out.println("value=" + value);
		}
		if (BeanUtils.isSimpleProperty(bean2.getClass())) {
			value = bean2.toString();
			System.out.println("value=" + value);
		} else {
			Object o = PropertyUtils.getSimpleProperty(bean2, "code");
			// Object
			// o=org.apache.commons.beanutils.BeanUtils.getSimpleProperty(bean2,
			// "code");
			System.out.println("not a simple property ! get SimpleProperty   "
					+ o.toString());
		}
		Object o = PropertyUtils.getProperty(bean2, "no");
		System.out.println(" no:  " + o.toString());
		o = PropertyUtils.getProperty(bean2, "kindPack.kindCode");
		System.out.println(" kindCode:  " + o.toString());

	}
}
