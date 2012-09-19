package com.sinosoft.one.mvc.testcases.scanning;

import org.apache.commons.lang.ArrayUtils;

import junit.framework.TestCase;
import com.sinosoft.one.mvc.scanning.LoadScope;

public class LoadScopeTest extends TestCase {

    public void test1() {
        LoadScope scope = new LoadScope("controllers=com.xiaonei.game", "controllers");
        assertNull(scope.getScope("applicationContext"));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.game", "com.sinosoft.one.mvc" },
                scope.getScope("controllers")));
    }

    public void test2() {
        LoadScope scope = new LoadScope("controllers=com.xiaonei.game,com.sinosoft.one.mvc.web",
                "controllers");
        assertNull(scope.getScope("applicationContext"));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.game", "com.sinosoft.one.mvc.web",
                "com.sinosoft.one.mvc" }, scope.getScope("controllers")));
    }

    public void test3() {
        LoadScope scope = new LoadScope(
                "com.xiaonei.game;applicationContext=com.xiaonei.abc", "controllers");
        assertNotNull(scope.getScope("applicationContext"));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.game", "com.sinosoft.one.mvc" },
                scope.getScope("controllers")));
        assertTrue(ArrayUtils.isEquals(new String[] { "com.xiaonei.abc", "com.sinosoft.one.mvc" },
                scope.getScope("applicationContext")));
    }
}
