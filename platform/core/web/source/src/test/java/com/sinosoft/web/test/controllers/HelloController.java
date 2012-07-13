package com.sinosoft.web.test.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.sinosoft.util.DateFormatMode;
import com.sinosoft.web.instruction.reply.Reply;
import com.sinosoft.web.instruction.reply.Replys;
import com.sinosoft.web.instruction.reply.transport.Json;
import com.sinosoft.web.instruction.reply.transport.Xml;


@Path("/hello")
public class HelloController {
	@Get("")
	public Reply getIndex() {
		return Replys.with("hello world");
	}
	
	@Post
    public Reply getJson() {
        return Replys.with(new Student("1", "carvin")).as(Json.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/list")
    public Reply getJsonList() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1", "carvin"));
		students.add(new Student("2", "carvin1"));
        return Replys.with(students).as(Json.class).includes("id,name,address.id,address.name").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/map")
    public Reply getJsonMap() {
		Map<String, Student> students = new HashMap<String, Student>();
		students.put("1", new Student("1", "carvin"));
		students.put("2", new Student("2", "carvin1"));
        return Replys.with(students).as(Json.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/exclude")
    public Reply getExcludeJson() {
        return Replys.with(new Student("1", "carvin")).as(Json.class).excludes("ignoreField").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/include")
    public Reply getIncludeJson() {
		Student student = new Student("1", "carvin");
		student.getAddress().setStudent(student);
        return Replys.with(student).as(Json.class).includes("id,name,address.student.id,address.id,address.name").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml")
    public Reply getXml() {
        return Replys.with(new Student("1", "carvin")).as(Xml.class);
    }
	
	@Get("/xml/list")
    public Reply getXmlList() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1", "carvin"));
		students.add(new Student("2", "carvin1"));
        return Replys.with(students).as(Xml.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml/map")
    public Reply getXmlMap() {
		Map<String, Student> students = new HashMap<String, Student>();
		students.put("1", new Student("1", "carvin"));
		students.put("2", new Student("2", "carvin1"));
        return Replys.with(students).as(Xml.class).dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml/exclude")
    public Reply getExcludeXml() {
        return Replys.with(new Student("1", "carvin")).as(Xml.class).excludes("ignoreField").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/xml/include")
    public Reply getIncludeXml() {
        return Replys.with(new Student("1", "carvin")).as(Xml.class).includes("id,name").dateFormatMode(DateFormatMode.YYYYMMDDHHMM);
    }
	
	@Get("/sample/success")
    public Reply getSampleSuccess() {
        return Replys.sample().success();
    }
	
	@Get("/sample/fail")
    public Reply getSampleFail() {
        return Replys.sample().fail("fail message");
    }
	
	@Get("/redirect")
    public Reply getRedirect(Invocation inv) {
		inv.addModel("name", "carvin");
        return Replys.saying().redirect(inv.getRequest().getContextPath() + "/redirect.jsp");
    }
	
	@Get("/forward")
    public Reply getForward(Invocation inv) {
		inv.addModel("name", "carvin");
        return Replys.saying().forward("/forward.jsp");
    }
}
