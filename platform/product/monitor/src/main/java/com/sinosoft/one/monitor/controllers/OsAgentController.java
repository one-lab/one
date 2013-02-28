package com.sinosoft.one.monitor.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;

@Path
public class OsAgentController {
	private static String ID = "";
	public static int pollingTime = 0;
	public static String osCmd_vmstat = "";
	public static String osCmd_ramInfo = "";
	public static String osCmd_diskInfo = "";
	public static String osCmd_getIp = "";
	public static String osAgentIp = "";
	public static String osAgentID = "";
	public static String ip = "";
	public static Map<String, String> shellAndIp = new HashMap<String, String>();

	public static String vmstat = "";
	public static String ramInfo = "";
	public static String diskInfo = "";
	public static String agentIp = "";
	public static Map<String, String> osAgentInfo = new HashMap<String, String>();

	/**
	 * 响应Angent，发送基本信息的脚本
	 */
	@Post("recieveOsInfo")
	public void recieveOsInfo(Invocation inv) {
		try {
			InputStream is = null;
			is = OsAgentController.class.getClassLoader().getResourceAsStream(
					"monitorInfo.properties");
			Properties properties = new Properties();
			properties.load(is);
			pollingTime = new Integer(properties.getProperty("pollingTime"));
			osCmd_vmstat = properties.getProperty("osCmd_vmstat");
			osCmd_ramInfo = properties.getProperty("osCmd_ramInfo");
			osCmd_getIp = properties.getProperty("osCmd_getIp");
			osCmd_diskInfo = properties.getProperty("osCmd_diskInfo");
			ip = properties.getProperty("ip");
			osAgentInfo = inv.getRequest().getParameterMap();
			osAgentIp = osAgentInfo.get("ip");
			if (ip.equals(osAgentIp)) {
				shellAndIp.put("osCmd_vmstat", osCmd_vmstat);
				shellAndIp.put("osCmd_ramInfo", osCmd_ramInfo);
				shellAndIp.put("osCmd_getIp", osCmd_getIp);
				shellAndIp.put("osCmd_diskInfo", osCmd_diskInfo);
				shellAndIp.put("ID", "1234567");
				ObjectOutputStream oos = new ObjectOutputStream(inv
						.getResponse().getOutputStream());
				oos.writeObject(shellAndIp);
				oos.flush();
				oos.close();
			}
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
			osAgentInfo = inv.getRequest().getParameterMap();
			ID = "1234567";
			osAgentID = osAgentInfo.get("ID");
			vmstat = osAgentInfo.get("vmstat");
			ramInfo = osAgentInfo.get("ramInfo");
			diskInfo = osAgentInfo.get("diskInfo");
			if (ID.equals(osAgentID)) {
				ObjectOutputStream oos = new ObjectOutputStream(inv
						.getResponse().getOutputStream());
				oos.writeObject("继续监控");
				oos.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
