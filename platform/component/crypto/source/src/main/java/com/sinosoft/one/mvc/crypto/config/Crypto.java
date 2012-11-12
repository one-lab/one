package com.sinosoft.one.mvc.crypto.config;


/**
 * User: Morgan
 * Date: 12-11-6
 * Time: 下午7:17
 */

public class Crypto {

	private String url;

	private String includes;

	private String excludes;

	private String name;

	public Crypto(String url,String includes,String excludes, String name) {
		this.url = url;
		this.includes = includes;
		this.excludes = excludes ;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIncludes() {
		return includes;
	}

	public void setIncludes(String includes) {
		this.includes = includes;
	}

	public String getExcludes() {
		return excludes;
	}

	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}
}
