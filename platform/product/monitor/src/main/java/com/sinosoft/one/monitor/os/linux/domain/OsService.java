package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Map;
/**
 * 数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
public interface OsService {

	/**
	 * 读取操作系统基本信息
	 * @return
	 */
	public Map<String, String> getOsBasic();

	/**
	 * 保存操作系统基本信息
	 * @return
	 */
	public Map<String, String> saveOsBasic();
	
	
	/**
	 * 读取操作系统基本信息
	 * @return
	 */
	public Map<String, String> getOsShell();

}
