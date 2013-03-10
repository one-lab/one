package com.sinosoft.one.monitor.controllers;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.data.jade.parsers.sqljep.function.Hash;
import com.sinosoft.one.monitor.os.linux.domain.OsAvailableServcie;
import com.sinosoft.one.monitor.os.linux.domain.OsProcessService;
import com.sinosoft.one.monitor.os.linux.domain.OsService;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsShell;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

@Path
public class OsAgentController {
	private static String ID = "";
	public static String pollingTime = "0";
	public static String osCmd_vmstat = "";
	public static String osCmd_ramInfo = "";
	public static String osCmd_diskInfo = "";
	public static String osCmd_getIp = "";
	public static String osAgentIp = "";
	public static String osAgentID = "";
	public static String ip = "";
	public static Map<String, String> shellAndIp = new HashMap<String, String>();

	public static String cpuInfo = "";
	public static String ramInfo = "";
	public static String diskInfo = "";
	public static String agentIp = "";
	public static Map<String, String[]> osAgentInfo = new HashMap<String, String[]>();

	/**
	 * 系统基本信息几脚本service
	 */
	@Autowired
	private OsService osService;
	
	@Autowired
	private OsProcessService osProcessService;


	/**
	 * 响应Angent，发送基本信息的脚本
	 */
	@Post("recieveOsInfo")
	public void recieveOsInfo(Invocation inv) {
		try {
			osAgentInfo = inv.getRequest().getParameterMap();
			osAgentIp = getValue("ip", osAgentInfo);
			Os  os = osService.getOsBasicByIp(osAgentIp);
			ObjectOutputStream oos = new ObjectOutputStream(inv.getResponse()
					.getOutputStream());
			System.out.println(getValue("ID", osAgentInfo));
			if(os!=null||os.getOsInfoId().toString().equals(getValue("ID", osAgentInfo))){
				shellAndIp.put("ID", os.getOsInfoId());
				shellAndIp.put("pollingTime", os.getIntercycleTime()+"");
				List<OsShell>osShells=osService.getOsShell();
				for (OsShell osShell : osShells) {
					shellAndIp.put(osShell.getType(),osShell.getTemplate());
				}
				
				System.out.println("正确返回");
//						break;
			}else {
				shellAndIp.put("ID", null);
			}
			oos.writeObject(shellAndIp);
			
//			if(null!=getValue("ID", osAgentInfo)&&!"".toString().equals(getValue("ID", osAgentInfo))){
//				for (Os os : oss) {
//					if(os.getOsInfoId().toString().equals(getValue("ID", osAgentInfo))){
//						shellAndIp.put("ID", os.getOsInfoId());
//						shellAndIp.put("pollingTime", os.getIntercycleTime()+"");
//						List<OsShell>osShells=osService.getOsShell();
//						for (OsShell osShell : osShells) {
//							shellAndIp.put(osShell.getType(),osShell.getTemplate());
//						}
//						oos.writeObject(shellAndIp);
//						System.out.println("正确返回");
//					}
//				}
//			}else {
//				shellAndIp.put("ID", null);
//				oos.writeObject(shellAndIp);
//			}
			
//			for (Os o : oss) {
//				if(o.getOsInfoId().toString().equals(getValue("ID", osAgentInfo))){
//					
//				}
//			}
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取系统所有监控数据
	 */
	@Post("recieveOsResult")
	public void recieveOsResult(Invocation inv) {
		try {
			osAgentInfo =  inv.getRequest().getParameterMap();
			osAgentID = getValue("ID", osAgentInfo);
			Os os = osService.getOsBasicById(osAgentID);
			ObjectOutputStream oos = new ObjectOutputStream(inv.getResponse().getOutputStream());
			Map<String, Object>requestInfo=new HashMap<String, Object>();//返回代理端的响应信息;
			if(os!=null){
				cpuInfo = getValue("cpuInfo", osAgentInfo);
				System.out.println("收集返回的CPU："+cpuInfo);
				ramInfo = getValue("ramInfo", osAgentInfo);
				System.out.println("收集返回的内存："+ramInfo);
				diskInfo = getValue("diskInfo", osAgentInfo);
				System.out.println("收集返回的磁盘："+diskInfo);
				String respondTime = getValue("respondTime", osAgentInfo);
				System.out.println("响应时间"+respondTime);
//				oos.writeObject("继续监控");
				//采样时间
				Date sampleTime=new Date();
				System.out.println(sampleTime.toLocaleString()+"1111111111111111111111");
				//保存采样数据
				osProcessService.saveSampleData(os.getOsInfoId(), cpuInfo, ramInfo, diskInfo, respondTime, sampleTime);
				//记录每次采样的可用性临时数据 此处为可用状态  状态码“1”
				osProcessService.savaAvailableSampleData(os.getOsInfoId(), sampleTime, os.getIntercycleTime(), "1");
				
				requestInfo.put("interCycle", os.getIntercycleTime());//返回轮询时间
			}else {
//				oos.writeObject("停止监控");
//				Date date=new Date();
//				//保存不可用状态起始点 状态码“0”
//				osProcessService.savaAvailableSampleData(os.getOsInfoId(), date,os.getIntercycleTime(),  "0");
			}
			oos.writeObject(requestInfo);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String getValue(String key, Map<String, String[]> osInfo) {
		return osInfo.get(key)[0];
	}
}
