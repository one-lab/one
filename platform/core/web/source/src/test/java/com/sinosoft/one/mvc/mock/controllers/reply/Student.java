package com.sinosoft.one.mvc.mock.controllers.reply;

import java.util.Date;

public  class Student {
	public Student() {}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	private String id;
	private String name;
	private Date birthday;
	private String ignoreField;
	private Address address;
	

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student(String id, String name) {
		this.id = id;
		this.name = name;
		this.birthday = new Date();
		this.ignoreField = "ignore";
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIgnoreField() {
		return ignoreField;
	}

	public void setIgnoreField(String ignoreField) {
		this.ignoreField = ignoreField;
	}
	
	@Override
	public String toString() {
		return "id:" + id + ", name: " + name + ", birthday:" + birthday;
	}
	
}