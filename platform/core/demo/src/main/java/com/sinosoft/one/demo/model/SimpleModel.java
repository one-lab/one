package com.sinosoft.one.demo.model;

import java.io.Serializable;
import java.util.Date;

public class SimpleModel implements Serializable{
	
	private static final long serialVersionUID = 9188522268166880774L;
	private String name;
	private boolean sex;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "SimpleModel [name=" + name +", sex=" + sex
				+ ", birth=" + birth + "]";
	}
}
