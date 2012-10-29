package com.sinosoft.one.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-10-18
 * Time: 下午7:22
 * To change this template use File | Settings | File Templates.
 */
public class NodeEntity {
    private String id;
    private String title;
    private String classTag;
    private String url;
    private List<NodeEntity> children;
    private String state;

    public NodeEntity(){}
    public NodeEntity(String id,String title,String classTag,String url,String state){
        this.id =id;
        this.title =title;
        this.classTag =classTag;
        this.url =url;
        this.state =state;
    }
    public NodeEntity(String id,String title,String classTag,String url,String state,List<NodeEntity> children){
        this(id, title ,classTag,url ,state );
        this.children =children;
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

    public List<NodeEntity> getChildren() {
        return children;
    }

    public void setChildren(List<NodeEntity> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
