package com.sinosoft.one.monitor.test.osAgentTest;

import java.util.HashMap;
import java.util.Map;

import com.sinosoft.one.monitor.os.Agent.util.HttpConnectionUtil;


public class Test {
	public static void main(String[] args) {
//		 HttpUtil httpUtil = new HttpUtil();
		// int a = httpUtil.post("http://localhost:8080/postTest/test");
		// System.out.println(a);
		// httpUtil.request("http://localhost:8080/postTest/request");
		// httpUtil.post("http://localhost:8080/postTest/post");
//		 String url = "http://localhost:8080/postTest/recieveOsInfo";
//		 Map<String, String> map = new HashMap<String, String>();
//		 map.put("cpu", "1");
//		 map.put("ip", "2");
//		 map.put("ram", "3");
//		 Object o = httpUtil.request(url, null);
//		 System.out.println(o);

		HttpConnectionUtil httpConnectionUtil = new HttpConnectionUtil();
		String url = "http://localhost:8080/monitor/recieveOsInfo";
		Object o = httpConnectionUtil.request(url, null);
		Map<String, String> shellAndIp = new HashMap<String, String>();
		shellAndIp = (Map<String, String>) o;
		System.out.println(shellAndIp.get("osCmd_vmstat"));
		System.out.println(shellAndIp.get("osCmd_ramInfo"));
		System.out.println(shellAndIp.get("osCmd_getIp"));
		System.out.println(shellAndIp.get("osCmd_diskInfo"));
		System.out.println(shellAndIp.get("ip"));
////
//		
//		
//		Map<String, String> osInfo = new HashMap<String, String>();
//		osInfo.put("vmstat", "vmstat");
//		osInfo.put("ramInfo", "ramInfo");
//		osInfo.put("diskInfo", "diskInfo");
//		osInfo.put("agentIp", "agentIp");
//		String url = "http://localhost:8080/monitor/recieveOsResult";
//		Object o = httpUtil.request(url, osInfo);
//		System.out.println(o);
	}
}
