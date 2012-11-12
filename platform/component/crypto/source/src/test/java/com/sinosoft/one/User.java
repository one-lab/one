package com.sinosoft.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Morgan
 * Date: 12-11-8
 * Time: 下午4:50
 */
public class User {

	private String id;
	private String id2;
	private String id3;
	private Integer age;
	private Map aa;
	private List bb = new ArrayList();
	private boolean cc;

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId3() {
		return id3;
	}

	public void setId3(String id3) {
		this.id3 = id3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Map getAa() {
		return aa;
	}

	public void setAa(Map aa) {
		this.aa = aa;
	}

	public List getBb() {
		return bb;
	}

	public void setBb(List bb) {
		this.bb = bb;
	}

	public boolean isCc() {
		return cc;
	}

	public void setCc(boolean cc) {
		this.cc = cc;
	}
}
