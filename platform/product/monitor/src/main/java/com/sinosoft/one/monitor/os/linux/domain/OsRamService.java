package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;

import com.sinosoft.one.monitor.os.linux.model.OsRam;
import com.sinosoft.one.monitor.os.linux.model.OsStati;
/**
 * 内存部分数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
public class OsRamService {
	
	/**
	 * 保存内存采集数据
	 * @param ram
	 */
	public void saveRam(OsRam ram){
		
	}
	/**
	 * 获取内存采集数据
	 * @param ram
	 */
	public OsRam getRam(){
		return null;
	}
	
	/**
	 * 删除内存采集数据
	 * @param ram
	 */
	public void deleteRam(String osid,Date begin,Date end){
	}
	/**
	 * 保存内存统计数据
	 * @param ram
	 */
	public void saveRamStati(OsStati ram){
		
	}
	
	/**
	 * 保存内存统计数据
	 * @param ram
	 */
	public void deleteRamStati(OsStati ram){
		
	}
	/**
	 * 获取内存统计数据
	 * @param ram
	 */
	public OsStati getRamStati(String osid,String type,Date begin ,Date end){
		return null;
	}
	
	/**
	 * 获取内存统计数据
	 * @param ram
	 */
	public void deleteRamStati(String osid,String type,Date begin ,Date end){

	}
}
