package ins.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import ins.framework.common.Page;
import ins.framework.utils.StringUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-8-28
 * Time: 下午4:00
 * To change this template use File | Settings | File Templates.
 */
public final class WebUtil {
    protected static final Log logger = LogFactory.getLog(WebUtil.class);
    private WebUtil() {};

    public static String toJSONData(Page page, String[] args)
    {
        try
        {
            Assert.notEmpty(args);
            List dataList = new ArrayList();
            List list = page.getResult();
            int size = args.length;
            for (Iterator iter = list.iterator(); iter.hasNext(); ) {
                Object element = iter.next();
                Map dataMap = new HashMap(size);
                for (int i = 0; i < size; i++) {
                    Object value = null;
                    if (args[i].indexOf('.') > -1) {
                        String[] arrArg = StringUtils.split(args[i], '.');
                        value = element;
                        for (int j = 0; j < arrArg.length - 1; j++) {
                            value = PropertyUtils.getProperty(value, arrArg[j]);
                            value = PropertyUtils.getProperty(value, arrArg[(j + 1)]);
                        }
                    } else {
                        value = PropertyUtils.getProperty(element, args[i]);
                    }
                    dataMap.put(args[i], fixValueForJSON(value));
                }
                dataList.add(dataMap);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("recordsReturned", Integer.valueOf(page.getPageSize()));
            jsonObject.put("startIndex", Long.valueOf(page.getStart()));
            jsonObject.put("totalRecords", Long.valueOf(page.getTotalCount()));
            jsonObject.put("data", JSONArray.toJSON(dataList));
            jsonObject.put("message", page.getMessage());
            return jsonObject.toJSONString();
        } catch (Exception e) {
            logger.error("to json data exception. ", e);
            return "";
        }
    }

    private static  Object fixValueForJSON(Object value)
    {
        Object retObject = value;
        if ((value instanceof Date)) {
            retObject = new Timestamp(((Date)value).getTime());
        }
        return retObject;
    }


}
