package com.sinosoft.one.monitor.model;
// Generated 2013-1-8 17:51:26 by One Data Tools 1.0.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * Mailinfo.
* 监控邮件信息
 */
@Entity
@Table(name="GE_MONITOR_MAILINFO"
)
public class Mailinfo  implements java.io.Serializable {

    /**
    * 序号.
    */
    private String id;
    /**
    * 目的地.
    */
    private String sendto;
    /**
    * 内容.
    */
    private String content;
    /**
    * 附件路径.
    */
    private String filepath;
    /**
    * 邮件主题.
    */
    private String subject;

    public Mailinfo() {
    }

	
    public Mailinfo(String id) {
        this.id = id;
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
    
    @Column(name="SENDTO", length=50)
    public String getSendto() {
    return this.sendto;
    }

    public void setSendto(String sendto) {
    this.sendto = sendto;
    }
    
    @Column(name="CONTENT", length=1500)
    public String getContent() {
    return this.content;
    }

    public void setContent(String content) {
    this.content = content;
    }
    
    @Column(name="FILEPATH", length=100)
    public String getFilepath() {
    return this.filepath;
    }

    public void setFilepath(String filepath) {
    this.filepath = filepath;
    }
    
    @Column(name="SUBJECT", length=100)
    public String getSubject() {
    return this.subject;
    }

    public void setSubject(String subject) {
    this.subject = subject;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


