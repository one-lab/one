package com.sinosoft.one.monitor.os.linux.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.OsStati;
import com.sinosoft.one.monitor.os.linux.repository.OsDiskRepository;
import com.sinosoft.one.monitor.os.linux.util.OsTransUtil;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

/**
 * 磁盘部分数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
@Component
public class OsDiskService {
	
	@Autowired
	private OsDiskRepository osDiskRepository;
	/**
	 * 保存磁盘采集数据
	 * @param disk
	 */
	public void saveDisk(String osInfoId, String diskInfo ,Date sampleTime){
		List<OsDisk> osDisks=OsTransUtil.getDiskInfo(diskInfo);
		Os os=new Os();
		for (OsDisk osDisk : osDisks) {
			os.setOsInfoId(osInfoId);
			osDisk.setOs(os);
			osDisk.setSampleDate(sampleTime);
		}
		osDiskRepository.save(osDisks);
	}
	
	/**
	 * 获取内存采集数据
	 * @param ram
	 * @param begin起始时间
	 * @param end 结束时间
	 */
	public List<OsDisk> getDiskByDate(String osInfoId,Date begin,Date end){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE);
		return osDiskRepository.findOsDiskByDate(osInfoId, simpleDateFormat.format(begin), simpleDateFormat.format(end), OsUtil.ORCL_DATEFORMATE);
	}
	
	/**
	 * 删除磁盘采集数据
	 * @param disk
	 */
	public void deleteDiskData(String osid,Date begin,Date end){
		
	}

	/**
	 * 保存磁盘统计数据
	 * @param disk
	 */
	public void saveDiskStati(OsStati disk){
		
	}
	
	/**
	 * 获取磁盘统计数据
	 * @param disk
	 */
	public OsStati getDiskStati(String osid,String type,Date begin ,Date end){
		
		return null;
	}
	
	/**
	 * 删除磁盘统计数据
	 * @param disk
	 */
	public void deleteDiskStati(String osid,String type,Date begin ,Date end){
		
	}
}
