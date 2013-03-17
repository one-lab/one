package com.sinosoft.one.monitor.os.Agent.util;

import java.io.ObjectInputStream;
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

public class HttpConnectionUtil {

	public Object request(String url, Map<String, Object> osInfo) {
		HttpPost post = new HttpPost(url);
		HttpResponse response = null;
		Object o = null;
		try {
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
			response = new DefaultHttpClient().execute(post);
			ObjectInputStream ois = new ObjectInputStream(response.getEntity()
					.getContent());
			o = ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
