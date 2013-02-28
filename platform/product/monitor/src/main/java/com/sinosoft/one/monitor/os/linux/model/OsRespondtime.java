package com.sinosoft.one.monitor.os.linux.model;
// Generated 2013-2-28 10:40:23 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OsRespondtime.

 */
@Entity
@Table(name="GE_MONITOR_OS_RESPONDTIME"
)
public class OsRespondtime  implements java.io.Serializable {

    /**
        */
    private String id;
    /**
        */
    private String osInfoId;
    /**
        */
    private Date sampleDate;
    /**
        */
    private String respondTime;

    public OsRespondtime() {
    }

	
    public OsRespondtime(String id) {
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
    
    @Column(name="OS_INFO_ID", length=32)
    public String getOsInfoId() {
    return this.osInfoId;
    }

    public void setOsInfoId(String osInfoId) {
    this.osInfoId = osInfoId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="SAMPLE_DATE", length=7)
    public Date getSampleDate() {
    return this.sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
    this.sampleDate = sampleDate;
    }
    
    @Column(name="RESPOND_TIME", length=32)
    public String getRespondTime() {
    return this.respondTime;
    }

    public void setRespondTime(String respondTime) {
    this.respondTime = respondTime;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


