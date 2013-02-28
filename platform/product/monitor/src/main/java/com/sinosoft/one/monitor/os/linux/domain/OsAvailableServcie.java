package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;

import com.sinosoft.one.monitor.os.linux.model.OsAvailable;
import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;

public interface OsAvailableServcie {

	/**
	 * 保存可用性采集数据
	 * @param ava
	 */
	public void saveAvailable(OsAvailable ava);
	
	
	/**
	 * 获取可用性采集数据
	 * @param ava
	 */
	public OsAvailable getAvailable();
	
	/**
	 * 保存可用性临时数据
	 * @param ava
	 */
	public void saveAvailableTemp(OsAvailabletemp osAvailabletemp);
	
	/**
	 * 获取可用性统计临时数据
	 * @param ava
	 */
	public OsAvailable getAvailableTemp(String osid,String type,Date begin ,Date end);
}
