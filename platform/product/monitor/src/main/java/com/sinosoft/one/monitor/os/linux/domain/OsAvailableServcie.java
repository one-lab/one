package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;

import com.sinosoft.one.monitor.os.linux.model.OsAvailable;
import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;

public class OsAvailableServcie {

	/**
	 * 保存可用性数据
	 * @param ava
	 */
	public void saveAvailable(String osId,String nomorRun,String crashtime,String aveRepair,String aveFault ,String timeSpan){
		
		
	}
	
	/**
	 * 获取可用数据
	 * @param ava
	 */
	public OsAvailable getAvailable(){
		return null;
	}
	
	public void deleteAvailable(String osId,String timeSpan){
		
	}
	
	/**
	 * 保存可用性临时数据
	 * @param ava
	 */
	public void saveAvailableTemp(String osId,String type,Date time,String Status){
		
	}
	
	/**
	 * 获取可用性统计临时数据
	 * @param ava
	 */
	public OsAvailable getAvailableTemp(){
		return null;
	}
	
	/**
	 * 获取可用性统计临时数据
	 * @param ava
	 */
	public void deleteAvailableTemp(String osid,Date begin,Date end){
	}
}
