package com.sinosoft.one.uiutil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.uiutil.exception.GridConverterException;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-24
 * Time: 上午10:00
 * To change this template use File | Settings | File Templates.
 */
public class GridConverter<T> implements Converter<Gridable> {
    private static Log log = LogFactory.getLog(GridConverter.class);
    private static final String TOTAL_ELEMENT = "total";
    private static final String ROWS_ELEMENT = "rows";
    private static final String ID_ELEMENT = "id";
    private static final String CELL_ELEMENT = "cell";

    public String toJson(Gridable gridable)  {
        if (gridable == null || gridable.getPage() == null) {
            return null;
        } else {
            Page page = gridable.getPage();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(TOTAL_ELEMENT, page.getTotalElements());
            if (gridable.getPage().getContent() instanceof Collection) {
                Collection nextItemObject = (Collection) gridable.getPage().getContent();
                jsonObject.put(ROWS_ELEMENT, addCellObjectWithListString(nextItemObject, gridable));
            } else {
                log.error("The result type must be a 'Collection' type.");
            }

            return jsonObject.toString();
        }
    }

    private JSONArray addCellObjectWithListString(Collection nextItemObject, Gridable gridable){
        JSONArray jsonArray = new JSONArray();
        for (Object obj : nextItemObject) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(ID_ELEMENT, BeanUtils.getProperty(obj, gridable.getIdField()));
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
                throw new GridConverterException("The current method does not  have permission to access the member.", e);
            } catch (InvocationTargetException e) {
                log.error(e.getMessage());
                throw new GridConverterException(e.getTargetException());
            } catch (NoSuchMethodException e) {
                log.error(e.getMessage());
                throw new GridConverterException(e);
            }
            List<String> attributeNames = new ArrayList<String>();
            if (gridable.getCellListStringField() != null) {
                attributeNames = gridable.getCellListStringField();
            } else if (gridable.getCellStringArrayField() != null) {
                attributeNames = convertToList(gridable.getCellStringArrayField());
            } else if (gridable.getCellStringField() != null) {
                attributeNames = convertToList(gridable.getCellStringField());
            } else {
                attributeNames = null;
            }
            if (attributeNames != null && attributeNames.size() > 0) {
                JSONArray cellJsonArray = new JSONArray();
                for (String attributeName : attributeNames) {
                    cellJsonArray.add(getValue(obj, attributeName));
                }
                jsonObject.put(CELL_ELEMENT, cellJsonArray);
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    private Object getValue(Object obj,String attributeName){
        Object value = null;
        if(obj instanceof Map){
            value = ((Map)obj).get(attributeName);
            return value;
        }
        try{
            value = ReflectionUtils.invokeGetterMethod(obj,attributeName);
        }catch (IllegalArgumentException exception){
            value = ReflectionUtils.getFieldValue(obj, attributeName);
        }
        return value.toString();
    }

    private List<String> convertToList(String[] cellField) {
        List<String> attributeNames = new ArrayList<String>();
        for (String str : cellField) {
            attributeNames.add(str);
        }
        return attributeNames;
    }

    private List<String> convertToList(String cellField) {
        String[] cellStringArrayField = cellField.split(",");
        List<String> attributeNames = new ArrayList<String>();
        for (String str : cellStringArrayField) {
            attributeNames.add(str);
        }
        return attributeNames;
    }

    public String toXml(Gridable gridable) {
        return null;
    }


}
