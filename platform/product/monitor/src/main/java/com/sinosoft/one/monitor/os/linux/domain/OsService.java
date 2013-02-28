package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Map;

import javax.annotation.Resource;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.repository.OsRepository;
/**
 * 数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
public class OsService {
	@Resource(name="osRepository")
	private OsRepository osRepository;

	/**
	 * 读取操作系统基本信息
	 * @return
	 */
	public Map<String, String> getOsBasic(){
		return  null;
	}

	/**
	 * 保存操作系统基本信息
	 * @return
	 */
	public void saveOsBasic(String id,String name,String type,String ipAddr,String subnetMask,int interCycle){
		Os os =new Os();
		os.setName(name);
		os.setType(type);
		os.setIpAddr(ipAddr);
		os.setSubnetMask(subnetMask);
		os.setIntercycleTime(interCycle);
		osRepository.save(os);
	}
	
	
	/**
	 * 读取操作系统基本信息
	 * @return
	 */
	public Map<String, String> getOsShell(){
		return null;
	}

}
