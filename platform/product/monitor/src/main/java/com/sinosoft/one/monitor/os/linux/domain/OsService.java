package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.repository.OsRepository;
/**
 * 数据库操作类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
@Component
public class OsService {
	@Autowired
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
	public void saveOsBasic(String name,String type,String ipAddr,String subnetMask,int interCycle){
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
