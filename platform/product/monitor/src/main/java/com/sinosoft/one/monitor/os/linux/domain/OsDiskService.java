package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;

import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.OsStati;

/**
 * 磁盘部分数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
public interface OsDiskService {
	
	/**
	 * 保存磁盘采集数据
	 * @param disk
	 */
	public void saveDiskData(OsDisk disk);
	
	/**
	 * 获取磁盘采集数据
	 * @param disk
	 */
	public OsDisk getDiskData();

	/**
	 * 保存磁盘统计数据
	 * @param disk
	 */
	public void saveDiskStatiData(OsStati disk);
	
	/**
	 * 获取磁盘统计数据
	 * @param disk
	 */
	public OsStati getDiskStatiData(String osid,String type,Date begin ,Date end);
}
