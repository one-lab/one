package com.sinosoft.one.rmsdemo.uiUtils;

import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.rmsdemo.model.User;
import com.sinosoft.one.util.TreeNode;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sinosoft.one.util.reflection.ReflectionUtils;
import org.apache.commons.beanutils.BeanUtils;
import sun.reflect.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-12
 * Time: 上午11:14
 * To change this template use File | Settings | File Templates.
 */
public class TreeConverter<T> implements Converter<Treeable> {

    public String toJson(Treeable treeable) {
        JSONArray jsonArray = new JSONArray();
        List<T> content=treeable.getContent();
        for (T node : content) {
            JSONObject itemObject = new JSONObject();
            JSONObject subItemObject = new JSONObject();
            try {
                itemObject.put("attr", BeanUtils.getProperty(node, treeable.getIdField()));
                itemObject.put("title",BeanUtils.getProperty(node, treeable.getTitleField()));
                Object url = BeanUtils.getProperty(node,treeable.getUrlField());
                if(url !=null){
                    if(url.getClass().isAssignableFrom(String.class)){
                        itemObject.put("href",BeanUtils.getProperty(node,treeable.getUrlField()));
                    }
                }
                Object children = ReflectionUtils.getFieldValue(node, treeable.getChildrenField());
                if(children != null) {
                    if(children.getClass().isAssignableFrom(List.class)) {
                        addSubItemObject(node,children ,treeable,jsonArray);
                    }
                }
                itemObject.put("state",BeanUtils.getProperty(node, treeable.getStateField()));
                jsonArray.add(itemObject);
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return jsonArray.toString();
    }

    private JSONArray addSubItemObject(Object node, Object children, Treeable treeable, JSONArray jsonArray) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        List childrenNodes = new ArrayList();
        childrenNodes = (List) children;
        Iterator iterator = childrenNodes.iterator();
        if (iterator.hasNext()) {
            JSONObject itemObject = new JSONObject();
            itemObject.put("attr", BeanUtils.getProperty(iterator.next(), treeable.getIdField()));
            itemObject.put("title", BeanUtils.getProperty(iterator.next(), treeable.getTitleField()));
            //判断href
            //itemObject.put("href", BeanUtils.getProperty(iterator.next(), treeable.getUrlField()));
            Object url = BeanUtils.getProperty(node,treeable.getUrlField());
            if(url !=null){
                if(url.getClass().isAssignableFrom(String.class)){
                    itemObject.put("href",BeanUtils.getProperty(node,treeable.getUrlField()));
                }
            }
            itemObject.put("children", itemObject);
            jsonArray.add(itemObject);
        }
        Object childrenSub = ReflectionUtils.getFieldValue(childrenNodes, treeable.getChildrenField());
        if (childrenSub != null) {
            if (childrenSub.getClass().isAssignableFrom(List.class)) {
                addSubItemObject(iterator.next(), childrenSub, treeable, jsonArray);
            }
        }
        return jsonArray;
    }

    public String toXml(Treeable treeable) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
