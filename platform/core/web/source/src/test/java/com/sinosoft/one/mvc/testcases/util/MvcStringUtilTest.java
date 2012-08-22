package com.sinosoft.one.mvc.testcases.util;

import com.sinosoft.one.mvc.util.MvcStringUtil;
import org.junit.Test;

import junit.framework.Assert;

public class MvcStringUtilTest {

    @Test
    public void test() {
        Assert.assertEquals("", MvcStringUtil.relativePathToModulePath(""));
        Assert.assertEquals("/abc", MvcStringUtil.relativePathToModulePath("abc"));
        Assert.assertEquals("/abc", MvcStringUtil.relativePathToModulePath("abc/"));
    }
}
