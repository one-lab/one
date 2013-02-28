package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;

import com.sinosoft.one.monitor.os.linux.model.OsRespondtime;
import com.sinosoft.one.monitor.os.linux.model.OsStati;

public interface OsRespondTimeService {
	/**
	 * 保存响应时间采集数据
	 * @param ava
	 */
	public void saveRespondTime(OsRespondtime osRespondtime);
	
	
	/**
	 * 获取响应时间数据
	 * @param ava
	 */
	public OsRespondtime getRespondTime();
	
	/**
	 * 保存响应时间统计数据
	 * @param ava
	 */
	public void saveRespondTimeStati(OsStati respondTime);
	
	/**
	 * 获取响应时间统计数据
	 * @param ava
	 */
	public OsStati getRespondTimeStati(String osid,String type,Date begin ,Date end);
}
