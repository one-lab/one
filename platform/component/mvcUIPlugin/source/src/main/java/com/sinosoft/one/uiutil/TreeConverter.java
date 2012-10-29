package com.sinosoft.one.uiutil;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import org.apache.commons.beanutils.BeanUtils;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-12
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class TreeConverter<T> implements Converter<Treeable> {
    private static final String idElement = "id";
    private static final String attrElement = "attr";
    private static final String dataElement = "data";
    private static final String titleElement = "title";
    private static final String classElement = "class";
    private static final String hrefElement = "href";
    private static final String childrenElement = "children";
    private static final String stateElement = "state";
    private static final String emptyClass = "";
    private static final String emptyHref = "javascript:void(0);";
    private JSONArray jsonArray;

    public String toJson(Treeable treeable) {
        if (treeable == null) {
            return null;
        } else {
            jsonArray = addSubItemObject(treeable.getContent(), treeable);
            return jsonArray.toString();
        }
    }

    private JSONArray addSubItemObject(Object children, Treeable treeable) {
        JSONArray jsonArray = new JSONArray();
        if (children instanceof Collection) {
            Collection subChildren = (Collection) children;
            for (Object obj : subChildren) {
                JSONObject jsonObject = new JSONObject();
                JSONObject jsonAttrObject = new JSONObject();
                JSONObject dataItemObject = new JSONObject();
                JSONObject dataAttrItemObject = new JSONObject();
                try {
                    jsonAttrObject.put(idElement, BeanUtils.getProperty(obj, treeable.getIdField()));
                    jsonObject.put(attrElement, jsonAttrObject);
                    dataItemObject.put(titleElement, BeanUtils.getProperty(obj, treeable.getTitleField()));
                    if (BeanUtils.getProperty(obj, treeable.getClassField()) == null || BeanUtils.getProperty(obj, treeable.getClassField()).isEmpty()) {
                        dataAttrItemObject.put(classElement, emptyClass);
                    } else {
                        dataAttrItemObject.put(classElement, BeanUtils.getProperty(obj, treeable.getClassField()));
                    }
                    if (BeanUtils.getProperty(obj, treeable.getUrlField()) == null || BeanUtils.getProperty(obj, treeable.getUrlField()).isEmpty()) {
                        dataAttrItemObject.put(hrefElement, emptyHref);
                    } else {
                        dataAttrItemObject.put(hrefElement, BeanUtils.getProperty(obj, treeable.getUrlField()));
                    }
                    dataItemObject.put(attrElement, dataAttrItemObject);
                    jsonObject.put(dataElement, dataItemObject);
                    if (hasSubNode(obj, treeable)) {
                        Object subSubChildren = ReflectionUtils.getFieldValue(obj, treeable.getChildrenField());
                        jsonObject.put(childrenElement, addSubItemObject(subSubChildren, treeable));
                    }
                    jsonObject.put(stateElement, BeanUtils.getProperty(obj, treeable.getStateField()));
                    jsonArray.add(jsonObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return jsonArray;
        }
        return jsonArray;
    }

    private Boolean hasSubNode(Object object, Treeable treeable) {
        if (ReflectionUtils.getFieldValue(object, treeable.getChildrenField()) != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public String toXml(Treeable treeable) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}