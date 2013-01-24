package com.sinosoft.one.monitor.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class ResponseUtil {
	public static int getResponseCode(String urlString) {
		int responseCode = 404;
		HttpURLConnection httpConnection =null;
		try {
			URL url = new URL(urlString);
			httpConnection= (HttpURLConnection) url
					.openConnection();
//			httpConnection.getURL();
			System.out.println("-------------------"+httpConnection.getResponseCode());
			responseCode = httpConnection.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null!=httpConnection){
				httpConnection.disconnect();
				}
		}
		return responseCode;
	}
}
