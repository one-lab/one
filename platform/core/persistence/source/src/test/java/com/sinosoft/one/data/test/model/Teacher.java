package com.sinosoft.one.data.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User: Morgan
 * Date: 12-8-17
 * Time: 下午3:32
 */
@Entity
@Table(name="teacher")
public class Teacher {

	private String id;
	private String name;
	private Integer age;

	@Id
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
