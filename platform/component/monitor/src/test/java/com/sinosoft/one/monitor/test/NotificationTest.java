package com.sinosoft.one.monitor.test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext*.xml" })
public class NotificationTest {
	
	@Test
	public void testNotification() throws JSONException{
		String responseMessage="";
		HttpURLConnection httpConnection = null;
		DataOutputStream out = null;
		BufferedReader reader = null;
		try {
			URL urlPost = new URL("http://localhost:8080/monitor/notification/urlConfigure/url");
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
			httpConnection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
			// 要注意的是connection.getOutputStream会隐含的进行connect。
			// 实际上只是建立了一个与服务器的tcp连接，并没有实际发送http请求。
			httpConnection.connect();
			out = new DataOutputStream(httpConnection.getOutputStream());
			// The URL-encoded contend
			// 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
			String content = "";
			// DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
			out.writeBytes(content);
			// flush and close
			out.flush();

			reader = new BufferedReader(new InputStreamReader(
					httpConnection.getInputStream()));
			StringBuffer resposne = new StringBuffer();
			while ((responseMessage = reader.readLine()) != null) {
				resposne.append(responseMessage);
			}
			JSONObject json=new JSONObject(resposne.toString());
			System.out.println(json);
		} catch (IOException e) {
			//
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
				//logger.error("http connection close error:", e2);
			}
		}
}
}