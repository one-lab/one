package com.sinosoft.web.test.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.sinosoft.util.DateFormatMode;
import com.sinosoft.web.instruction.reply.Reply;
import com.sinosoft.web.instruction.reply.transport.Json;
import com.sinosoft.web.instruction.reply.transport.Xml;


@Path("/hello")
public class HelloController {
	@Get("")
	public Reply<String> getIndex() {
		return Reply.with("hello world");
	}
	
	@Post
    public Reply<Student> getJson() {
        return Reply.with(new Student("1", "carvin")).as(Json.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/list")
    public Reply<List<Student>> getJsonList() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1", "carvin"));
		students.add(new Student("2", "carvin1"));
        return Reply.with(students).as(Json.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/map")
    public Reply<Map<String,Student>> getJsonMap() {
		Map<String, Student> students = new HashMap<String, Student>();
		students.put("1", new Student("1", "carvin"));
		students.put("2", new Student("2", "carvin1"));
        return Reply.with(students).as(Json.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/exclude")
    public Reply<Student> getExcludeJson() {
        return Reply.with(new Student("1", "carvin")).as(Json.class).excludes("ignoreField").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/include")
    public Reply<Student> getIncludeJson() {
        return Reply.with(new Student("1", "carvin")).as(Json.class).includes("id,name,address.id").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml")
    public Reply<Student> getXml() {
        return Reply.with(new Student("1", "carvin")).as(Xml.class);
    }
	
	@Get("/xml/list")
    public Reply<List<Student>> getXmlList() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1", "carvin"));
		students.add(new Student("2", "carvin1"));
        return Reply.with(students).as(Xml.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml/map")
    public Reply<Map<String,Student>> getXmlMap() {
		Map<String, Student> students = new HashMap<String, Student>();
		students.put("1", new Student("1", "carvin"));
		students.put("2", new Student("2", "carvin1"));
        return Reply.with(students).as(Xml.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml/exclude")
    public Reply<Student> getExcludeXml() {
        return Reply.with(new Student("1", "carvin")).as(Xml.class).excludes("ignoreField").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml/include")
    public Reply<Student> getIncludeXml() {
        return Reply.with(new Student("1", "carvin")).as(Xml.class).includes("id,name").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
    
    class Student {
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
    	private Address address = new Address("1", "bj");
    	
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
    }
    
    class Address {
    	private String id;
    	private String name;
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
    }
}
