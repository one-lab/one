package com.sinosoft.one.monitor.os.Agent.util;

import java.io.ObjectInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinosoft.one.monitor.os.Agent.config.OsConfig;

public class HttpConnectionUtil {
	private static Logger logger = LoggerFactory.getLogger(HttpConnectionUtil.class);
	public static Object request(String url, Map<String, Object> osInfo) {
		try {
			logger.debug(url.toString());
			HttpPost post = new HttpPost(url);
			logger.debug(post.toString());
			HttpResponse response = null;
			Object o = null;
			if (osInfo != null) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				Entry<String, String> entry = null;
				Iterator iterator = osInfo.entrySet().iterator();
				while (iterator.hasNext()) {
					entry = (Entry<String, String>) iterator.next();
					pairs.add(new BasicNameValuePair(entry.getKey(), entry
							.getValue()));
					post.setEntity(new UrlEncodedFormEntity(pairs, HTTP.UTF_8));
				}
			}
			DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
			response = defaultHttpClient.execute(post);
			defaultHttpClient.getConnectionManager().shutdown();
			System.out.println(response);
			ObjectInputStream ois = new ObjectInputStream(response.getEntity()
					.getContent());
			o = ois.readObject();
			ois.close();
			return o;
		} catch (Throwable  e) {
			logger.error("++",e);
			e.printStackTrace();
			
		} 
		return null;
	}
}
