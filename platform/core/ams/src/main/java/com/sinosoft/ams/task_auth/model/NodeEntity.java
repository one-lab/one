package com.sinosoft.ams.task_auth.model;

import java.util.List;


public class NodeEntity {
    private String id;
    private String title;
    private List<NodeEntity> children;
    private String state;

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

  
}
