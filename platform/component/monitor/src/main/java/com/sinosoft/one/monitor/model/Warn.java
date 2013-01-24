package com.sinosoft.one.monitor.model;
// Generated 2013-1-8 17:51:26 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * Warn.
* 监控组件预警信息
 */
@Entity
@Table(name="GE_MONITOR_WARN"
)
public class Warn  implements java.io.Serializable {

    /**
    * 序列.
    */
    private String id;
    /**
    * 应用名称.
    */
    private String appId;
    /**
    * 标题.
    */
    private String title;
    /**
    * 内容.
    */
    private String content;
    /**
    * 发送短信状态.
    */
    private String sendsms;
    /**
    * 发送邮件状态.
    */
    private String sendemail;
    /**
    * 产生时间.
    */
    private Date occurdate;
    /**
    * 预警等级.
    */
    private String grade;
    /**
    * 备注.
    */
    private String remark;
    /**
        */
    private String module;

    public Warn() {
    }

	
    public Warn(String id, String content) {
        this.id = id;
        this.content = content;
    }
   
    @Id 
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name="ID", unique=true, length=32)
    public String getId() {
    return this.id;
    }

    public void setId(String id) {
    this.id = id;
    }
    
    @Column(name="APP_ID", length=50)
    public String getAppId() {
    return this.appId;
    }

    public void setAppId(String appId) {
    this.appId = appId;
    }
    
    @Column(name="TITLE", length=100)
    public String getTitle() {
    return this.title;
    }

    public void setTitle(String title) {
    this.title = title;
    }
    
    @Column(name="CONTENT", length=1500)
    public String getContent() {
    return this.content;
    }

    public void setContent(String content) {
    this.content = content;
    }
    
    @Column(name="SENDSMS", length=1)
    public String getSendsms() {
    return this.sendsms;
    }

    public void setSendsms(String sendsms) {
    this.sendsms = sendsms;
    }
    
    @Column(name="SENDEMAIL", length=1)
    public String getSendemail() {
    return this.sendemail;
    }

    public void setSendemail(String sendemail) {
    this.sendemail = sendemail;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="OCCURDATE", length=7)
    public Date getOccurdate() {
    return this.occurdate;
    }

    public void setOccurdate(Date occurdate) {
    this.occurdate = occurdate;
    }
    
    @Column(name="GRADE", length=10)
    public String getGrade() {
    return this.grade;
    }

    public void setGrade(String grade) {
    this.grade = grade;
    }
    
    @Column(name="REMARK", length=200)
    public String getRemark() {
    return this.remark;
    }

    public void setRemark(String remark) {
    this.remark = remark;
    }
    
    @Column(name="MODULE", length=20)
    public String getModule() {
    return this.module;
    }

    public void setModule(String module) {
    this.module = module;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


