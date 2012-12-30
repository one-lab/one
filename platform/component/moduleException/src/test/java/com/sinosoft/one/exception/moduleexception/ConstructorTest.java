package com.sinosoft.one.exception.moduleexception;

import com.sinosoft.one.exception.ExceptionLevel;
import com.sinosoft.one.exception.moduleexception.businessexception.BizConfigCommonException;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import junit.framework.Assert;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.junit.Test;
import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-26
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */
public class ConstructorTest {

    @Test
    public void testPrivateConstructor() throws Exception{
        Class<BizConfigCommonException> clazz = BizConfigCommonException.class;
//        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
//        Assert.assertTrue(declaredConstructors.length  == 1);
//        for(Constructor<BizConfigCommonException> constructor : declaredConstructors) {
//            if(!constructor.isAccessible()) {
//                constructor.setAccessible(true);
//            }
//        }
        Constructor<BizConfigCommonException> constructor = ReflectionUtils.getPrivateConstructor(clazz, new Class[]{String.class, String.class, Throwable.class, ExceptionLevel.class});

        BizConfigCommonException exception = constructor.newInstance(null, "aaa", new RuntimeException("aaa"), ExceptionLevel.UNSERIOUS);
        Assert.assertEquals("aaa", exception.getMsg());
        Assert.assertEquals(ExceptionLevel.UNSERIOUS, exception.getLevel());
    }
}
