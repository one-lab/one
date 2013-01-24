package com.sinosoft.one.monitoragent.notification;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class NotificationConfigureDealer {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 应用名称
	 */
	private String appName;
	/**
	 * 服务器ip
	 */
	private String ip;
	/**
	 * 服务器端口
	 */
	private String port;
	/**
	 * 请求的url路径
	 */
	private String url;
	/**
	 * 请求类型 
	 */
	private String type;
	private static Map<String,String> configureCache=new HashMap<String,String>();
	/**
	 * 向monitor发送notification请求,获取配置信息
	 */
	public String getConfigureInfo() {
		if("url".equals(type)){
			url="http://"+ip+":"+port+"/monitor/notification/urlConfigure/url";
		}else{
			url="http://"+ip+":"+port+"/monitor/notification/methodConfigure/method";
		}
		//查询缓存数据中是否存在该url的配置信息
		if(configureCache.get(url)!=null && !"".equals(configureCache.get(url))){
			return configureCache.get(url);
		}
		logger.debug("开始获取信息"+url);
		String responseMessage = "";
		StringBuffer resposne = new StringBuffer();
		HttpURLConnection httpConnection = null;
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {
			URL urlPost = new URL(url);
			httpConnection = (HttpURLConnection) urlPost.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			// 参数长度太大，不能用get方式
			httpConnection.setRequestMethod("POST");
			// 不使用缓存
			httpConnection.setUseCaches(false);
			// URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
			httpConnection.setInstanceFollowRedirects(true);
			// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
			// 意思是正文是urlencoded编码过的form参数
			httpConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
			// 要注意的是connection.getOutputStream会隐含的进行connect。
			// 实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。
			logger.debug("打开连接:"+url);
			httpConnection.connect();
			out = new DataOutputStream(httpConnection.getOutputStream());
			// The URL-encoded contend
			// 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
			String content = "appName=" + appName + "&type=" + type;
			// // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
			out.writeBytes(content);
			//flush and close
			out.flush();
			reader = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
			logger.debug("进入循环");
			while ((responseMessage = reader.readLine()) != null) {
				resposne.append(responseMessage);
			}
			
			if (!"failure".equals(resposne.toString())) {
				logger.error("success send to monitor  notification" + resposne);
			} else {
				logger.debug("failure send to monitor  notification");
			}
			//将该url的配置信息缓存起来
			configureCache.put(url, resposne.toString());
			return resposne.toString();
		} catch (IOException e) {
			logger.error("连接失败" + url);
			return "failed";
		} finally {
			try {
				if (null != out) {
					out.close();
				}
				if (null != reader) {
					reader.close();
				}
				if (null != httpConnection) {
					httpConnection.disconnect();
				}
			} catch (Exception e2) {
				logger.error("http connection close error:", e2);
			}
		}
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAppName() {
		return appName;
	}

	public String getUrl() {
		return url;
	}

	public String getType() {
		return type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
