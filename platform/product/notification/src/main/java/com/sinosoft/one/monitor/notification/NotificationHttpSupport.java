package com.sinosoft.one.monitor.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * NotificationHTTP支持类
 * User: carvin
 * Date: 13-3-2
 * Time: 下午4:00
 * 处理HTTP连接信息
 */
final class NotificationHttpSupport {
	private NotificationHttpSupport() {}
	private static Logger logger = LoggerFactory.getLogger(NotificationHttpSupport.class);

	private static HttpURLConnection getHttpConnection(String url) {
		HttpURLConnection httpConnection = null;
		try {
			URL urlPost = new URL(url);
			httpConnection = (HttpURLConnection) urlPost.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setDoInput(true);
			httpConnection.setUseCaches(false);
			httpConnection.setInstanceFollowRedirects(true);
			httpConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		} catch (Exception e) {
			logger.error("connect url [" + url + " failure.", e);
		}
		return httpConnection;
	}

	public static String post(String url, Map<String, String> params) {
		return connect(url, params, "POST");
	}

	public static String get(String url, Map<String, String> params) {
		return connect(url, params, "GET");
	}

	public static String connect(String url, Map<String, String> params, String requestMethod) {
		HttpURLConnection httpURLConnection = getHttpConnection(url);
		if(httpURLConnection == null) {
			return "failure";
		}

		StringBuilder responseStrBuilder = new StringBuilder();
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {
			httpURLConnection.setRequestMethod(requestMethod);
			// 要注意的是connection.getOutputStream会隐含的进行connect。
			// 实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。
			// 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
			String content = getParamsContent(params);
			if("GET".equalsIgnoreCase(requestMethod)) {
				url += "?" + content;
			}
			logger.debug("打开连接:" + url);
			httpURLConnection.connect();

			if("POST".equalsIgnoreCase(requestMethod)) {
				out = new DataOutputStream(httpURLConnection.getOutputStream());
				// The URL-encoded contend
				// // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
				out.writeBytes(content);
				//flush and close
				out.flush();
			}
			reader = new BufferedReader(new InputStreamReader(
					httpURLConnection.getInputStream()));
			logger.debug("get response .");
			String responseMessage = "";
			while ((responseMessage = reader.readLine()) != null) {
				responseStrBuilder.append(responseMessage);
			}
			return responseStrBuilder.toString();
		} catch (Exception e) {
			logger.error("connect url exception : [" + url + "]", e);
			return "";
		} finally {
			try {
				if (null != out) {
					out.close();
				}
				if (null != reader) {
					reader.close();
				}
				if (null != httpURLConnection) {
					httpURLConnection.disconnect();

				}
			} catch (Exception e) {
				logger.warn("close connector info exception [" + e.getMessage() + "]");
			}
		}
	}

	private static String getParamsContent(Map<String, String> params) {
		StringBuilder paramsBuilder = new StringBuilder();
		for(String key : params.keySet()) {
			paramsBuilder.append("&").append(key).append("=").append(params.get(key));
		}
		return paramsBuilder.substring(1);
	}
}
