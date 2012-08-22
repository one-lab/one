package com.sinosoft.one.mvc.mock.controllers.reply;

public  class Address {
	private String id;
	private String name;
	
	private Student student;
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
	
	public Address(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}