package com.sinosoft.ams.utils.uiutil;

import java.util.List;


public class NodeEntity {
    private String id;
    private String title;
    private List<NodeEntity> children;
    private String state;
    
    private String classField;
    
    private String urlField;
    
    public NodeEntity() {

    }

    public NodeEntity(String id, String title, String state) {
        this.id = id;
        this.title = title;
        this.state = state;
    }

    public NodeEntity(String id, String titlle, String state, List<NodeEntity> children) {
        this(id, titlle, state);
        this.children = children;
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

	public String getClassField() {
		return classField;
	}

	public void setClassField(String classField) {
		this.classField = classField;
	}

	public String getUrlField() {
		return urlField;
	}

	public void setUrlField(String urlField) {
		this.urlField = urlField;
	}

  
}
