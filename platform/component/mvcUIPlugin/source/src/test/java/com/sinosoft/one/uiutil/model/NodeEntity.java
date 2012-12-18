package com.sinosoft.one.uiutil.model;

import java.util.List;

public class NodeEntity {
    private String id;
    private String title;
    private List<NodeEntity> children;
    private String state;
    private String classField;
    private String urlField;
    private String typeField;

    public NodeEntity() {

    }

    public NodeEntity(String id, String title, String state) {
        this.id = id;
        this.title = title;
        this.state = state;
    }

    public NodeEntity(String id, String title, List<NodeEntity> children, String state) {
        this(id, title, state);
        this.children = children;
    }

    public NodeEntity(String id, String title, String state, String classField, String urlField) {
        this(id, title, state);
        this.classField = classField;
        this.urlField = urlField;
    }

    public NodeEntity(String id, String title, List<NodeEntity> children, String state, String classField) {
        this(id, title, children, state);
        this.classField = classField;
    }

    public NodeEntity(String id, String title, List<NodeEntity> children, String state, String classField, String urlField) {
        this(id, title, children, state, classField);
        this.urlField = urlField;
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

    public String getTypeField() {
        return typeField;
    }

    public void setTypeField(String typeField) {
        this.typeField = typeField;
    }
}
