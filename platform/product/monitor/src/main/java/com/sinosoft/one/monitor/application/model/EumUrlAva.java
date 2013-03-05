package com.sinosoft.one.monitor.application.model;
// Generated 2013-3-4 15:45:30 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * EumUrlAva.
* 应用系统可用性临时表
 */
@Entity
@Table(name="GE_MONITOR_EUM_URL_AVA"
)
public class EumUrlAva  implements java.io.Serializable {

    /**
    * 主键ID.
    */
    private String id;
    /**
    * 业务仿真ID.
    */
    private EumUrl eumUrl;
    /**
    * 状态 1---可用 0---不可用.
    */
    private String state;
    /**
    * 记录时间.
    */
    private Date recordTime;

    public EumUrlAva() {
    }

	
    public EumUrlAva(String id) {
        this.id = id;
    }
   
    @Id 
    
    @Column(name="ID", unique=true, length=32)
    public String getId() {
    return this.id;
    }

    public void setId(String id) {
    this.id = id;
    }
    @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="EUM_URL_ID")
    public EumUrl getEumUrl() {
    return this.eumUrl;
    }

    public void setEumUrl(EumUrl eumUrl) {
    this.eumUrl = eumUrl;
    }
    
    @Column(name="STATE", length=1)
    public String getState() {
    return this.state;
    }

    public void setState(String state) {
    this.state = state;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="RECORD_TIME", length=7)
    public Date getRecordTime() {
    return this.recordTime;
    }

    public void setRecordTime(Date recordTime) {
    this.recordTime = recordTime;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


