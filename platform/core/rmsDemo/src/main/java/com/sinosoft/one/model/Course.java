package com.sinosoft.one.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-24
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
public class Course {
    private String id;
    private String title;
    private String classTag;
    private List<Course> children;
    private String url;
    private String state;

    public Course(String id,String title,String classTag,String url,String state){
        this.id = id;
        this .title = title;
        this .classTag = classTag;
        this.url = url;
        this.state = state;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassTag() {
        return classTag;
    }

    public void setClassTag(String classTag) {
        this.classTag = classTag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Course> getChildren() {
        return children;
    }

    public void setChildren(List<Course> children) {
        this.children = children;
    }
}

