package ins.common.util;

import ins.framework.utils.StringUtils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @title DisposeObject
 * @description 使用json对象时处理Date类型，或者其他未预料到的数据类型转换
 * @author 朱超
 * @version
 * @copyright (c) SINOSOFT
 * 
 */
@SuppressWarnings("unchecked")
public class DisposeObject {
	public List dispose(List list,String[] args) {
		List dataList = null;
		try {
			String[] arg = args;
			dataList = new ArrayList();
			int size = arg.length;
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				Object element = iter.next();
				Map dataMap = new HashMap(size);
				for (int i = 0; i < size; ++i) {
					Object value = null;
					if (arg[i].indexOf(46) > -1) {
						String[] arrArg = StringUtils.split(arg[i], '.');
						value = element;
						for (int j = 0; j < arrArg.length - 1; ++j) {
							value = PropertyUtils.getProperty(value, arrArg[j]);
							value = PropertyUtils.getProperty(value,arrArg[(j + 1)]);
						}
					} else {
						value = PropertyUtils.getProperty(element, arg[i]);
					}
					dataMap.put(arg[i], fixValueForJSON(value));
				}
				dataList.add(dataMap);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return dataList;
	}
	
	public Map dispose(Object o ,String[] args){
		int size = args.length;
		Object element = o;
		Map dataMap = new HashMap(size);
		Object value = null;
		try{
			for (int i = 0; i < size; ++i) {
				if (args[i].indexOf(46) > -1) {
					String[] arrArg = StringUtils.split(args[i], '.');
					value = element;
					for (int j = 0; j < arrArg.length - 1; ++j) {
						value = PropertyUtils.getProperty(value, arrArg[j]);
						value = PropertyUtils.getProperty(value,arrArg[(j + 1)]);
					}
				} else {
					value = PropertyUtils.getProperty(element, args[i]);
				}
				dataMap.put(args[i], fixValueForJSON(value));
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return dataMap;
	}
	
	private Object fixValueForJSON(Object value) {
		Object retObject = value;
		if (value instanceof Date)
			retObject = new Timestamp(((Date) value).getTime());

		return retObject;
	}
}
