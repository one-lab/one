package com.sinosoft.one.mvc.util;

import com.sinosoft.one.mvc.web.Invocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

    public static  File getDirectoryFile(final Invocation inv, final String directoryPath) {
        return new File(getDirectoryPath(inv, directoryPath));
    }

    public static  String getDirectoryPath(final Invocation inv, String directoryPath) {
        ServletContext sc = inv.getServletContext();
        String realPath = sc.getRealPath(directoryPath);
        if(realPath != null) {
            return realPath;
        }
        try {
            if(!directoryPath.startsWith("/")) {
                directoryPath = "/" + directoryPath;
            }
            realPath =  sc.getResource(directoryPath).toURI().getPath();
        } catch (Exception e) {
            logger.error("get directory path exception. directory path is " + directoryPath, e);
            throw new IllegalArgumentException(e);
        }
        return realPath;
    }

    public static InputStream getDirectoryStream(final Invocation inv, final String directoryPath) {
        try {
            return new FileInputStream(getDirectoryFile(inv, directoryPath));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("the directory path is not found, path is [" + directoryPath + "]", e);
        }
    }
}
