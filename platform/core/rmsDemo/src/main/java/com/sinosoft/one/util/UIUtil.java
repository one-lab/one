package com.sinosoft.one.util;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;


public class UIUtil {
//	public static <T extends TreeNode> String convertList2TreeString(List<T> objs) {
//		return convertList2TreeString(objs, null);
//	}
	
	public static String convertMap2String(Map<String, String> map) {
		Set<String> sets=map.keySet() ;
		JSONArray jsonArray = new JSONArray();
		for(String key:sets){
            JSONObject itemObject=new JSONObject();
            itemObject.accumulate(key,map.get(key));
            jsonArray.add(itemObject);
        }
		return jsonArray.toString() ;
	}
	
	public static String convertSingle2JSON(String key, String value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate(key, value);
		return jsonObject.toString();
	}
	
	public static <T extends Object> String convertList2JSONString(List<T> objs, String cellFields) {
		return convertList2JSONString(objs, cellFields.split(","));
	}
	
	public static <T extends Object> String convertList2JSONString(List<T> objs, String[] cellFields) {
		ConvertUtils.register(new DateConvert(), Date.class);
		JSONArray rowsArray = new JSONArray();
		if(objs == null) {
			return rowsArray.toString();
		}
		for(T t : objs) {
			JSONObject rowObject = new JSONObject();
			assert cellFields != null && cellFields.length > 0;
			try {
				for(String cellField : cellFields) {
					rowObject.accumulate(cellField.trim(), BeanUtils.getProperty(t, cellField.trim()));
				}
			} catch (Exception e) {
				LogFactory.getLog(UIUtil.class).error("convert list to json string exception.", e);
			}
			rowsArray.add(rowObject);
		}
		return rowsArray.toString();
	}
	
	public static <T extends Object> String convertList2JSONString(List<T> objs) {
		return JSONArray.fromObject(objs).toString();
	}
	
	public static <T extends Object> String convertList2JSONStringWithExcludeProps(List<T> objs, String[] excludeProperties) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(excludeProperties);
		return JSONArray.fromObject(objs, jsonConfig).toString();
	}
	
	public static <T extends TreeNode> String convertList2TreeString(List<TreeNode> objs) {
		JSONArray jsonArray = new JSONArray();
		if(objs == null) {
			return jsonArray.toString();
		}
        jsonArray.addAll(objs);

//		for(T t : objs) {
//			JSONObject itemObject = new JSONObject();
//			JSONObject dataObject = new JSONObject();
//			dataObject.accumulate("attr", t.getAttr());
//			itemObject.accumulate("data", dataObject);
//
//			JSONObject tempAttributesObject = new JSONObject();
//			tempAttributesObject.accumulate("id", t.getId());
//			//jsonObject.accumulate("text", module.getName());
//			tempAttributesObject.accumulate("leaf", t.isLeafNode());
//			tempAttributesObject.accumulate("url", t.getNodeUrl());
//			tempAttributesObject.accumulate("checked", t.isChecked());
//			if(userAttributes != null && !userAttributes.isEmpty()) {
//				for(String key : userAttributes.keySet()) {
//					tempAttributesObject.accumulate(key, userAttributes.get(key));
//				}
//			}
//			itemObject.accumulate("attributes", tempAttributesObject);
//
//			if(!t.isLeafNode()) {
//				itemObject.accumulate("state", "closed");
//			}
//			jsonArray.add(itemObject);
//		}
		return jsonArray.toString();
	}
	
	public static String convertTreeNodeList2TreeString(List<TreeNode> nodes) {
		JSONArray jsonArray = new JSONArray();
		if(nodes == null) {
			return jsonArray.toString();
		}
		for(TreeNode node : nodes) {
			JSONObject itemObject = new JSONObject();
			JSONObject dataObject = new JSONObject();
			dataObject.accumulate("attr", node.getAttr());
			itemObject.accumulate("data", node.getData());
			itemObject.accumulate("state",node.getState());
			itemObject.accumulate("children", node.getChildren());
			jsonArray.add(itemObject);
		}
		return jsonArray.toString();
	}
	public static String convertGridNodeListGridString(List<GridNode> nodes) {
        JSONArray jsonArray = new JSONArray();
        if(nodes == null) {
            return jsonArray.toString();
        }
        for (GridNode node : nodes){
          JSONObject itemObject = new JSONObject();
          JSONObject dataObject = new JSONObject();
          dataObject.accumulate("total",node.getTotal());
          itemObject.accumulate("cell",node.getCell());
          itemObject.accumulate("rows",node.getRows());
          jsonArray.add(itemObject);
        }
        return jsonArray.toString();
    }
//	public static <T extends TreeNode> String convertObject2TreeString(T t) {
//		JSONArray jsonArray = new JSONArray();
//		JSONObject itemObject = new JSONObject();
//		JSONObject dataObject = new JSONObject();
//		dataObject.accumulate("title", t.getNodeTitle());
//		itemObject.accumulate("data", dataObject);
//
//		JSONObject tempAttributesObject = new JSONObject();
//		tempAttributesObject.accumulate("id", t.getId());
//		//jsonObject.accumulate("text", module.getName());
//		tempAttributesObject.accumulate("leaf", t.isLeafNode());
//		tempAttributesObject.accumulate("url", t.getNodeUrl());
//		itemObject.accumulate("attributes", tempAttributesObject);
//		if(!t.isLeafNode()) {
//			itemObject.accumulate("state", "closed");
//		}
//		jsonArray.add(itemObject);
//		return jsonArray.toString();
//	}
	

	
	@SuppressWarnings("unchecked")
	public static <T extends Object> String convertList2GridString(List<T> objs, Page pageInfo, String idField, String cellFields, String operators) throws Exception {
		JSONObject jsonObject = new JSONObject();
		ConvertUtils.register(new DateConvert(), Date.class);
		if(pageInfo != null) {
			jsonObject.accumulate("page", pageInfo.getNumber());
			jsonObject.accumulate("total", pageInfo.getTotalPages());
			jsonObject.accumulate("records", pageInfo.getContent());
		}
		if(objs == null) {
			return jsonObject.toString();
		}
		JSONArray rowsArray = new JSONArray();
		for(T t : objs) {
			JSONObject rowObject = new JSONObject();
			JSONArray cellArray = new JSONArray();
			try {
				assert idField != null && idField.length() > 0;
				rowObject.accumulate("id", BeanUtils.getProperty(t, idField.trim()));

				String[] cellFieldArray = cellFields.split(",");
				assert cellFieldArray != null && cellFieldArray.length > 0;
				for(String cellField : cellFieldArray) {
					if(cellField.contains(".")) {
						String[] names = cellField.split("\\.");
						String propertyName = names[0].trim();
						String subPropertyName = names[1].trim();
						Class<T> tClass = (Class<T>) t.getClass();

						Method getMethod = tClass.getMethod("get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1));
						Object o = getMethod.invoke(t);
						if(o == null) {
							cellArray.add("");
						} else {
							Class<?> fieldType =getMethod.getReturnType();
							Method subGetMethod = fieldType.getMethod("get" + subPropertyName.substring(0, 1).toUpperCase() + subPropertyName.substring(1));
							cellArray.add((String)subGetMethod.invoke(o));
						}
					}  else {
						String value = BeanUtils.getProperty(t, cellField.trim());
						cellArray.add(value == null ? "" : value);
					}
				}
				if(operators != null) {
					cellArray.add(operators);
				}
			} catch (Exception e) {
                e.printStackTrace();
				//throw new GridException("convert list to grid exception. ", e);
			}

			rowObject.accumulate("cell", cellArray);
			rowsArray.add(rowObject);
		}

		jsonObject.accumulate("rows", rowsArray);
		return jsonObject.toString();
	}
	
	public static <T extends Object> String convertList2GridString(List<T> objs, Page pageInfo, String idField, String cellFields) throws Exception {
		return convertList2GridString(objs, pageInfo, idField, cellFields, null);
	}
	
	public static <T extends Object> String convertList2GridString(List<T> objs, String idField, String cellFields) throws Exception {
		return convertList2GridString(objs, null, idField, cellFields);
	}
	
	public static <T extends Object> String convertObject2JSONString(T obj) {
		return convertObject2JSONString(obj, null);
	}
	
	
	/**
	 * 
	 *	转换object对象为属性，可以排除不需要转换的属性
	 *  @param    obj 需要转换成string的对象  excludeProperties 需要排除的属性
	 *  @return   返回值
	 *  @throws   
	 */
	public static <T extends Object> String convertObject2JSONString(T obj,String[] excludeProperties) {
		JsonConfig config = new JsonConfig();
		if(excludeProperties != null && excludeProperties.length != 0) {
			config.setExcludes(excludeProperties);
		}
		config.registerJsonValueProcessor(Date.class, new JsonValueProcessor(){

			public Object processArrayValue(Object value, JsonConfig jsonConfig) {
				return process(value);
			}

			public Object processObjectValue(String key, Object value,
					JsonConfig jsonConfig) {
				// TODO Auto-generated method stub
				return process(value);
			}
			
			 /** 
		     * process 
		     * @param value 
		     * @return 
		     */  
		    private Object process(Object value) {  
		        try {  
		            if (value instanceof Date) {  
		                return DateUtil.Date2String((Date)value);  
		            }  
		            return value == null ? "" : value.toString();  
		        } catch (Exception e) {  
		            return "";  
		        }  
		    }
		});
//		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		return JSONObject.fromObject(obj,config).toString();
	}


}