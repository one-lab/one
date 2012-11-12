package com.sinosoft.one.mvc.crypto.wapper;

import com.sinosoft.one.mvc.crypto.CryptoCodec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

/**
 * User: Morgan
 * Date: 12-11-8
 * Time: 下午2:21
 */
public class CryptoRequestWapper extends HttpServletRequestWrapper {

	private Map<String, String[]> params;
	private String key;
	private String unCryptoParams;

	public CryptoRequestWapper(HttpServletRequest request,
								   Map<String, String[]> newParams,String key,String unCryptoParams) {
		super(request);
		this.key = key;
		this.params = newParams;
		this.unCryptoParams = unCryptoParams;
	}

	public CryptoRequestWapper(HttpServletRequest request) {
		super(request);
	}


	public String getParameter(String name) {
		String result = "";
		boolean isCrypto = false;
		Object v = params.get(name);
		if(unCryptoParams == null || unCryptoParams.equals("") || unCryptoParams.contains(name))
			isCrypto = true;
		if (v == null) {
			result = null;
		} else if (v instanceof String[]) {
			String[] strArr = (String[]) v;
			if (strArr.length > 0) {
				if(isCrypto)
					result = CryptoCodec.decode(key,strArr[0]);
				else
					result =  strArr[0];
			} else {
				result = null;
			}
		} else if (v instanceof String) {
			if(isCrypto)
				result = CryptoCodec.decode(key,(String) v);
			else
				result = (String) v;
		} else {
			result =  v.toString();
		}

		return result;
	}

	public Map getParameterMap() {
		return params;
	}

	public Enumeration getParameterNames() {
		return new Vector(params.keySet()).elements();
	}

	public String[] getParameterValues(String name) {
		String[] result = null;
		boolean isCrypto = false;
		if(unCryptoParams == null || unCryptoParams.equals("") || unCryptoParams.contains(name))
			isCrypto = true;
		Object v = params.get(name);
		if (v == null) {
			result =  null;
		} else if (v instanceof String[]) {
			if(isCrypto)
				result = CryptoCodec.decode(key,(String[])v);
			else
				result =  (String[]) v;
		} else if (v instanceof String) {
			if(isCrypto)
				result =  new String[] { CryptoCodec.decode(key,(String) v) };
			else
				result =  new String[] { (String) v };
		} else {
			if(isCrypto)
				result =  new String[] { CryptoCodec.decode(key,v.toString()) };
			else
				result =  new String[] { v.toString() };
		}

		return result;
	}

}
