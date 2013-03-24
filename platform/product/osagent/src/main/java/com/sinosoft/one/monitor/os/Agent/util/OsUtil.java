package com.sinosoft.one.monitor.os.Agent.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.monitor.os.Agent.config.OsConfig;

/**
 * 实用类
 * 
 * @author chenxiongxi
 * 
 */
public class OsUtil {
	private static Logger logger = LoggerFactory.getLogger(OsUtil.class);

	/**
	 * 执行shell 有返回结果
	 * 
	 * @param command
	 * @return
	 */
	public static String executeWithResult(String command) {
		String result = "";
		try {
			String[] cmd = new String[] { "/bin/sh", "-c", command };
			Process ps = Runtime.getRuntime().exec(cmd);

			BufferedReader br = new BufferedReader(new InputStreamReader(
					ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("");
			}
			result = sb.toString();
		} catch (Exception e) {
			logger.error("osutil :", e);
		}
		return result;
	}

	/**
	 * 执行shell 有返回结果
	 * 
	 * @param command
	 * @return
	 */
	public static String execute(String command) {
		String result = " ";
		try {
			String[] cmd = new String[] {};
 			Process ps = Runtime.getRuntime().exec( new String[]{ "/bin/sh", "-c", "CPULOG_1=$(cat /proc/stat | grep 'cpu ' | awk '{print $2\" \"$3\" \"$4\" \"$5\" \"$6\" \"$7\" \"$8}')" });
 			ps = Runtime.getRuntime().exec("SYS_IDLE_1=$(echo $CPULOG_1 | awk '{print $4}')");
 			ps = Runtime.getRuntime().exec("Total_1=$(echo $CPULOG_1 | awk '{print $1+$2+$3+$4+$5+$6+$7}')");
 			ps = Runtime.getRuntime().exec("CPULOG_2=$(cat /proc/stat | grep 'cpu ' | awk '{print $2\" \"$3\" \"$4\" \"$5\" \"$6\" \"$7\" \"$8}') ");
 			ps = Runtime.getRuntime().exec("SYS_IDLE_2=$(echo $CPULOG_2 | awk '{print $4}')" );
 			ps = Runtime.getRuntime().exec("Total_2=$(echo $CPULOG_2 | awk '{print $1+$2+$3+$4+$5+$6+$7}')");
 			ps = Runtime.getRuntime().exec("SYS_IDLE=`expr $SYS_IDLE_2 - $SYS_IDLE_1`");
 			ps = Runtime.getRuntime().exec("SYS_USAGE=`expr $SYS_IDLE/$Total*100 |bc -l`");
 			ps = Runtime.getRuntime().exec("Disp_SYS_Rate=`expr \"scale=3; $SYS_Rate/1\" |bc`");
 			ps = Runtime.getRuntime().exec("echo $Disp_SYS_Rate ");
 			BufferedReader br = new BufferedReader(new InputStreamReader(
 					ps.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("");
			}
//			result = sb.toString();
		} catch (Exception e) {
			logger.error("osutil :", e);
		}
		return result;
	}
	/**
	 * 获取cpu信息
	 * 
	 * @return
	 */
	public static String getCpuInfo() {
		System.out.println("执行cpu脚本：========"+OsConfig.osCmd_vmstat);
		return executeWithResult(OsConfig.osCmd_vmstat);
	}

	/**
	 * 获取cpu利用率
	 * 
	 * @return
	 */
	public static String getCpuUilitZation() {
		System.out.println("执行cpu利用率脚本：========"+OsConfig.osCmd_cpuUilitZation);
		return execute(OsConfig.osCmd_cpuUilitZation);
	}
	/**
	 * 获取内存信息
	 * 
	 * @return
	 */
	public static String getRamInfo() {
		System.out.println("执行ram脚本：========"+OsConfig.osCmd_ramInfo);
		return executeWithResult(OsConfig.osCmd_ramInfo);
	}

	/**
	 * 获取磁盘信息 主要是获取某块分区的剩余磁盘容量
	 * 
	 * @return
	 */
	public static String getDiskInfo() {
		System.out.println("执行disk脚本：========"+OsConfig.osCmd_diskInfo);
		return executeWithResult(OsConfig.osCmd_diskInfo);
	}

	
	/**
	 * 读取配置文件
	 * 
	 * @param propertiesConfigPath
	 * @return
	 */
	public static InputStream getFileStream(String propertiesConfigPath,Class clazz ) {
		InputStream is = null;
		is = clazz.getClassLoader().getResourceAsStream(
				propertiesConfigPath);
		return is;
	}
	 

public static  String readFile(String key, String fileName) {
	String value = null;
	try {
		String jarName = URLDecoder.decode(OsUtil.class
				.getProtectionDomain().getCodeSource().getLocation()
				.getFile(), "UTF-8");
		File jarFile = new File(jarName);
		String osInfoPath = jarFile.getParentFile().getAbsoluteFile()
				.getPath();
		File osInfoFile = new File(osInfoPath + File.separator + fileName);
		if (!osInfoFile.exists()) {
			writeFile("ip", "-1", "osAgentInfo/os.info");
		}
		Properties properties = new Properties();
		InputStream is = new FileInputStream(osInfoFile);
		properties.load(is);
		value = properties.getProperty(key);
		is.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return value;
}

public static void writeFile(String key, String value, String fileName) {
	try {
		String jarName = URLDecoder.decode(OsUtil.class
				.getProtectionDomain().getCodeSource().getLocation()
				.getFile(), "UTF-8");
		File jarFile = new File(jarName);
		String osInfoPath = jarFile.getParentFile().getAbsoluteFile()
				.getPath();
		File osInfoFile = new File(osInfoPath + File.separator + fileName);
		if (osInfoFile.exists()) {
			FileOutputStream fos = new FileOutputStream(osInfoFile);
			Properties properties = new Properties();
			properties.setProperty(key, value);
			properties.store(fos, null);
			fos.close();
		} else {
			if (!osInfoFile.getParentFile().exists()) {
				osInfoFile.getParentFile().mkdirs();
			}
			osInfoFile.createNewFile();
			Properties properties = new Properties();
			properties.put(key,value );
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(osInfoFile));
			properties.store(bufferedWriter, null);
			bufferedWriter.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

}
	
//	public static void main(String[] args) {
//		readProperty("ID", "config/os.info");
//		writeProperty("ID", "323", "config/os.info");
//	}
}
