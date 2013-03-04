package com.sinosoft.one.monitor.application.model;
// Generated 2013-2-28 10:28:19 by One Data Tools 1.0.0


import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Method.
 * 应用系统方法信息表
 */
@Entity
@Table(name = "GE_MONITOR_METHOD"
)
public class Method implements java.io.Serializable {

    /**
     * 主键ID.
     */
    private String id;
    /**
     * 方法描述.
     */
    private String description;
    /**
     * 方法所属类名.
     */
    private String className;
    /**
     * 方法名称.
     */
    private String methodName;
    /**
     * 方法阈值,单位ms.
     */
    private int threshold;
    /**
     * 创建时间.
     */
    private Date createTime;
    /**
     * 创建人ID.
     */
    private String creatorId;
    /**
     * 修改时间.
     */
    private Date modifyTime;
    /**
     * 修改人ID.
     */
    private String modifierId;
    /**
     * 有效状态:1有效,0删除.
     */
    private String status;
    /**
     * 关联的Url.
     */
    private List<Url> urls = new ArrayList<Url>(0);
    /**
     * 操作(为了页面显示，可管理url或者删除该条业务场景)
     */
    private String operation="<a href='javascript:void(0)' class='eid' onclick='eidRow(this)'>编辑 <a href='javascript:void(0)' class='del' onclick='delRow(this)'>删除";

    public Method() {
    }


    public Method(String id, String className, String methodName, int threshold, Date createTime, String creatorId, String status) {
        this.id = id;
        this.className = className;
        this.methodName = methodName;
        this.threshold = threshold;
        this.createTime = createTime;
        this.creatorId = creatorId;
        this.status = status;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy="uuid")
    @Column(name = "id", unique = true, length = 32)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "description", length = 300)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "class_name", length = 500)
    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Column(name = "method_name", length = 100)
    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Column(name = "threshold", precision = 6, scale = 0)
    public int getThreshold() {
        return this.threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", length = 7)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "creator_id", length = 32)
    public String getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_time", length = 7)
    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Column(name = "modifier_id", length = 32)
    public String getModifierId() {
        return this.modifierId;
    }

    public void setModifierId(String modifierId) {
        this.modifierId = modifierId;
    }

    @Column(name = "status", length = 1)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //设置Method为维护端(相对于U来说)
    //定义中间关联表的信息
    //inverseJoinColumns：被维护端的外键
    //joinColumns：维护端的外键
    @ManyToMany(cascade = {CascadeType.REFRESH})
    @JoinTable(name = "GE_MONITOR_URL_METHOD",
            inverseJoinColumns = @JoinColumn(name = "URL_ID"),
            joinColumns = @JoinColumn(name = "METHOD_ID"))


    public List<Url> getUrls() {
        return this.urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public void setUrl(Url url) {
        this.urls.add(url);
    }

    @Transient
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}


