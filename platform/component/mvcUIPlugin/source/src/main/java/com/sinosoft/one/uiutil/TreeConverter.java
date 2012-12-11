package com.sinosoft.one.uiutil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.uiutil.exception.TreeConverterException;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-10-12
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class TreeConverter<T> implements Converter<Treeable> {
    private static Log log = LogFactory.getLog(TreeConverter.class);
    private static final String ID_ELEMENT = "id";
    private static final String ATTR_ELEMENT = "attr";
    private static final String DATA_ELEMENT = "data";
    private static final String TITLE_ELEMENT = "title";
    private static final String CLASS_ELEMENT = "class";
    private static final String HREF_ELEMENT = "href";
    private static final String CHILDREN_ELEMENT = "children";
    private static final String STATE_ELEMENT = "state";
    private static final String CLASS_DEFAULT_VALUE = "";
    private static final String HREF_DEFAULT_VALUE = "javascript:void(0);";
    private JSONArray jsonArray;

    public String toJson(Treeable treeable) throws TreeConverterException {
        if (treeable == null || treeable.getContent() == null) {
            log.info("The treeable object is null.");
            return null;
        } else {
            jsonArray = addSubItemObject(treeable.getContent(), treeable);
            return jsonArray.toString();
        }
    }

    private JSONArray addSubItemObject(Object children, Treeable treeable) throws TreeConverterException {
        JSONArray jsonArray = new JSONArray();
        if (children instanceof Collection) {
            Collection subChildren = (Collection) children;
            for (Object obj : subChildren) {
                JSONObject jsonObject = new JSONObject();
                JSONObject jsonAttrObject = new JSONObject();
                JSONObject dataItemObject = new JSONObject();
                JSONObject dataAttrItemObject = new JSONObject();
                try {
                    jsonAttrObject.put(ID_ELEMENT, BeanUtils.getProperty(obj, treeable.getIdField()));
                    /*根据具体情况，将class属性放在<li>标签中*/
                    if (treeable.getClassField() == null || StringUtils.isBlank(BeanUtils.getProperty(obj, treeable.getClassField()))) {
                        jsonAttrObject.put(CLASS_ELEMENT, CLASS_DEFAULT_VALUE);
                    } else {
                        jsonAttrObject.put(CLASS_ELEMENT, BeanUtils.getProperty(obj, treeable.getClassField()));
                    }
                    jsonObject.put(ATTR_ELEMENT, jsonAttrObject);
                    dataItemObject.put(TITLE_ELEMENT, BeanUtils.getProperty(obj, treeable.getTitleField()));
                    /* if (treeable.getClassField() == null || StringUtils.isBlank(BeanUtils.getProperty(obj, treeable.getClassField()))) {
                        dataAttrItemObject.put(CLASS_ELEMENT, CLASS_DEFAULT_VALUE);
                    } else {
                        dataAttrItemObject.put(CLASS_ELEMENT, BeanUtils.getProperty(obj, treeable.getClassField()));
                    }*/
                    if (treeable.getUrlField() == null || StringUtils.isBlank(BeanUtils.getProperty(obj, treeable.getUrlField()))) {
                        dataAttrItemObject.put(HREF_ELEMENT, HREF_DEFAULT_VALUE);
                    } else {
                        dataAttrItemObject.put(HREF_ELEMENT, BeanUtils.getProperty(obj, treeable.getUrlField()));
                    }
                    dataItemObject.put(ATTR_ELEMENT, dataAttrItemObject);
                    jsonObject.put(DATA_ELEMENT, dataItemObject);
                    if (hasSubNode(obj, treeable)) {
                        Object subSubChildren = ReflectionUtils.getFieldValue(obj, treeable.getChildrenField());
                        jsonObject.put(CHILDREN_ELEMENT, addSubItemObject(subSubChildren, treeable));
                    }
                    //如果state属性不为空字符串或者null的判断，json字符串中增加state属性；
                    //如果state属性为空字符串或者null的判断，json字符串中没有state属性，交由前端处理（前端默认是关闭）
                    if (!StringUtils.isBlank(treeable.getStateField())) {
                        jsonObject.put(STATE_ELEMENT, BeanUtils.getProperty(obj, treeable.getStateField()));
                    }
                    jsonArray.add(jsonObject);
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage());
                    throw new TreeConverterException("the current method does not  have permission to access the member.", e);
                } catch (InvocationTargetException e) {
                    log.error(e.getMessage());
                    throw new TreeConverterException(e.getTargetException());
                } catch (NoSuchMethodException e) {
                    log.error(e.getMessage());
                    throw new TreeConverterException(e);
                }
            }
            return jsonArray;
        } else {
            log.error("The children node's type must be a 'Collection' type.");
        }
        return jsonArray;
    }

    private Boolean hasSubNode(Object object, Treeable treeable) {
        //子节点的属性children不是必须的，如果没有children属性，则不作任何处理
        /*if (ReflectionUtils.getFieldValue(object, treeable.getChildrenField()) != null) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }*/
        if (StringUtils.isBlank(treeable.getChildrenField()) || (ReflectionUtils.getFieldValue(object, treeable.getChildrenField()) == null)) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public String toXml(Treeable treeable) {
        return null;
    }
}