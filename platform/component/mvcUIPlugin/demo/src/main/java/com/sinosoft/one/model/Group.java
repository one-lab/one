package com.sinosoft.one.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-11
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public class Group {
    private Long id;
    private String groupName;
    private String position;
    private Date createDate;
    private Date  updateDate;
    private String operation;

    public Group(Long id, String groupName, String position, Date createDate, Date updateDate, String operation) {
        this.id = id;
        this.groupName = groupName;
        this.position = position;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.operation = operation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
