package com.sinosoft.one.mvc.util;

import com.sinosoft.one.mvc.web.Invocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * Mvc获取路径工具类
 * User: carvin
 * Date: 12-7-30
 * Time: 下午4:39
 * To change this template use File | Settings | File Templates.
 */
public final class MvcPathUtil {
    private static Log logger = LogFactory.getLog(MvcPathUtil.class);
    private MvcPathUtil() {

    }

    public static  File getDirectoryFile(final Invocation inv, final String dirctoryPath) {
        return new File(getDirectoryPath(inv, dirctoryPath));
    }

    public static  String getDirectoryPath(final Invocation inv, final String dirctoryPath) {
        ServletContext sc = inv.getServletContext();
        String realPath = sc.getRealPath(dirctoryPath);
        if(realPath != null) {
            return realPath;
        }
        try {
            realPath =  sc.getResource(dirctoryPath).toURI().getPath();
        } catch (Exception e) {
            logger.error("get directory path exception. directory path is " + dirctoryPath, e);
            throw new IllegalArgumentException(e);
        }
        return realPath;
    }
}
