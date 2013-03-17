package com.sinosoft.one.monitor.os.Agent.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.monitor.os.Agent.util.HttpConnectionUtil;
import com.sinosoft.one.monitor.os.Agent.util.OsUtil;

/**
 * 基本资源实例化 ，保存脚本等基本信息
 * 
 * @author chenxiongxi
 * 
 */
public class OsConfig {
	public static int interCycleTime = 1;
	public static String osCmd_vmstat = "";
	public static String osCmd_cpuUilitZation = "";
	public static String osCmd_ramInfo = "";
	public static String osCmd_getIp = "";
	public static String osCmd_diskInfo = "";
	public static String monitorAddress = "";
	public static String ip = "";
	public static String ID = "";
	public static int began = 1;
	public static String recieveOsResult = "";//
	public static String recieveOsInfo = "";

	
	public static boolean first=true;
	public static Map<String, String> shellAndId = new HashMap<String, String>();
	public static Map<String, Object> ipMap = new HashMap<String, Object>();
	public static Class clazz = OsConfig.class;
	
	private static Logger logger = LoggerFactory.getLogger(OsConfig.class);
	/**
	 * init
	 * 
	 * @param propertiesConfigPath
	 * @return
	 */
	public static void init(String propertiesConfigPath) {
		try {
			Properties properties = new Properties();
			properties.load(OsUtil.getFileStream("config/osConfig.properties",OsConfig.class));
			monitorAddress = properties.getProperty("monitorAddress");
			monitorAddress = monitorAddress + "recieveOsInfo";
			osCmd_getIp = properties.getProperty("osCmd_getIp");//读取本地文件获取monitor IP
			ip = OsUtil.executeWithResult(osCmd_getIp).split(":")[1];
			System.out.println(OsUtil.executeWithResult(osCmd_getIp)+"IP结果");
			ipMap.put("ip", ip);//把IP放入Map
			ID=OsUtil.readFile( "ID", "osAgentInfo/os.info");//读取本地OSID
			ipMap.put("ID", ID);//放入ID
			//连接MONITOR获取 脚本将ID 返回校验
			getConfigData(monitorAddress, ipMap);
			if (shellAndId.get("ID") != null) {//返回的ID是否为空 ---NULL不匹配
				OsUtil.writeFile("ID", shellAndId.get("ID"), "osAgentInfo/os.info");
				ID=shellAndId.get("ID");
				interCycleTime = new Integer(shellAndId.get("pollingTime"));
				osCmd_vmstat = shellAndId.get("CB");
				System.out.println(osCmd_vmstat+"返回的脚本");
				osCmd_ramInfo = shellAndId.get("RM");
				System.out.println(osCmd_ramInfo+"返回的脚本");
				osCmd_diskInfo = shellAndId.get("DK");
				System.out.println(osCmd_diskInfo+"返回的脚本");
				osCmd_cpuUilitZation=shellAndId.get("CU");
				System.out.println(osCmd_cpuUilitZation+"返回的脚本");
			} else {
				System.out.println("ip不匹配");
			}
		}  catch (Exception e) {
			logger.error("++++++++++++++++++++++++++", e);
			e.printStackTrace();
		}

	}
	/**
	 * 连接monitor读取基本信息（脚本，轮询间隔等）
	 * 
	 * @param monitorAddress
	 * @return
	 */
	private static void getConfigData(String monitorAddress,
			Map<String, Object> ipMap) {
		HttpConnectionUtil connectionUtil = new HttpConnectionUtil();
		shellAndId = (Map<String, String>) connectionUtil.request(
				monitorAddress, ipMap);
	}
	
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(OsUtil.getFileStream("config/osConfig.properties",OsConfig.class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
