package com.sinosoft.one.mvc.testcases.controllers.resolver;

import java.io.IOException;

import com.sinosoft.one.mvc.testcases.AbstractControllerTest;

/**
 * 测试一个controller方法中的所有参数都没有标注@Param的情况
 * 
 * @author Li Weibo (weibo.leo@gmail.com) //I believe spring-brother
 * @since 2011-1-12 下午07:23:39
 */
public class NoParamAnnotationControllerTest extends AbstractControllerTest {
	
	public void testList() throws Exception, IOException {
        Object ret = invoke("/resolver/noParamAnnotation");
        assertNotNull(ret);
    }
	
}
