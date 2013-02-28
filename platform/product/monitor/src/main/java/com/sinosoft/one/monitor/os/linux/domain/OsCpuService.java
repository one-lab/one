package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;

import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsStati;

/**
 * Cpu部分数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
public class OsCpuService {

	/**
	 * 保存CPU采集数据
	 * @param cpu
	 */
	public void saveCpuData(OsCpu cpu){
		
	}
	
	/**
	 * 获取CPU采集数据
	 * @param cpu
	 */
	public OsCpu  GetCpuData(){
		return null;
	}

	/**
	 * 删除CPU采集数据
	 * @param cpu
	 */
	public void deleteCpuData(String osid,Date begin,Date end){
		
	}
	/**
	 * 保存CPU统计数据
	 * @param cpu
	 */
	public void saveCpuStatiData(OsStati cpu){
	}
	
	/**
	 * 保存CPU采集数据
	 * @param cpu
	 */
	public OsStati  getCpuOsStatiData(String osid,String type,Date begin ,Date end){
		return null;
	}
	
	/**
	 * 删除CPU采集数据
	 * @param cpu
	 */
	public void  deleteCpuOsStatiData(String osid,String type,Date begin ,Date end){
	}
}
