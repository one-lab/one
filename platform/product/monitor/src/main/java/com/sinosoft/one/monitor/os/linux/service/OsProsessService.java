package com.sinosoft.one.monitor.os.linux.service;

import java.util.Date;
import java.util.Map;

import com.sinosoft.one.monitor.os.linux.model.OsAvailable;
import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.OsRam;

/**
 * @author bao
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
public interface OsProsessService {

	/**
	 * 判断CPU状态
	 * @param cpu
	 */
	public boolean decideCpuThreshold(OsCpu cpu);

	/**
	 * 判断磁盘状态
	 * @param disk
	 */
	public boolean decideDiskThreshold(OsDisk disk);

	/**
	 * 判断可用性状态
	 * @param date
	 * @param cpu
	 * @param disk
	 * @param ram
	 */
	public boolean decideOsAvailable(Date date, OsCpu cpu, OsDisk disk, OsRam ram);

	/**
	 * 判断内存状态
	 * @param ram
	 */
	public boolean decideRamThreshold(OsRam ram);

	/**
	 * 读取数据库基本信息
	 * @return
	 */
	public Map<String, String> getOsBasicDate();

	/**
	 * 保存可用性采集数据
	 * @param ava
	 */
	public void saveAvailable(OsAvailable ava);

	/**
	 * 保存CPU采集数据
	 * @param cpu
	 */
	public void saveCpuData(OsCpu cpu);

	/**
	 * 保存磁盘采集数据
	 * @param disk
	 */
	public void saveDiskData(OsDisk disk);

	/**
	 * 保存内存采集数据
	 * @param ram
	 */
	public void saveRamData(OsRam ram);

	public void sendMsg();

}