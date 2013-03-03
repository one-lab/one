package com.sinosoft.one.monitor.os.linux.model;
// Generated 2013-2-27 21:43:48 by One Data Tools 1.0.0


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * OsAvailabile.

 */
@Entity
@Table(name="GE_MONITOR_OS_AVAILABLE"
)
public class OsAvailable  implements java.io.Serializable {

    /**
        */
    private String id;
    /**
        */
    private Os os;
    /**
        */
    private String normalRun;
    /**
        */
    private String crashTime;
    /**
        */
    private String aveRepairTime;
    /**
        */
    private String aveFaultTime;
    /**
        */
    private Date timeSpan;

    public OsAvailable() {
    }

	
    public OsAvailable(String id, Os os) {
        this.id = id;
        this.os = os;
    }
   
    @Id 
    
    @Column(name="ID", unique=true, length=32)
    @GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")	
    public String getId() {
    return this.id;
    }

    public void setId(String id) {
    this.id = id;
    }
    @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="OS_INFO_ID")
    public Os getOs() {
    return this.os;
    }

    public void setOs(Os os) {
    this.os = os;
    }
    
    @Column(name="NORMAL_RUN", length=20)
    public String getNormalRun() {
    return this.normalRun;
    }

    public void setNormalRun(String normalRun) {
    this.normalRun = normalRun;
    }
    
    @Column(name="CRASH_TIME", length=20)
    public String getCrashTime() {
    return this.crashTime;
    }

    public void setCrashTime(String crashTime) {
    this.crashTime = crashTime;
    }
    
    @Column(name="AVE_REPAIR_TIME", length=20)
    public String getAveRepairTime() {
    return this.aveRepairTime;
    }

    public void setAveRepairTime(String aveRepairTime) {
    this.aveRepairTime = aveRepairTime;
    }
    
    @Column(name="AVE_FAULT_TIME", length=20)
    public String getAveFaultTime() {
    return this.aveFaultTime;
    }

    public void setAveFaultTime(String aveFaultTime) {
    this.aveFaultTime = aveFaultTime;
    }
    
    @Column(name="TIME_SPAN")
    public Date getTimeSpan() {
    return this.timeSpan;
    }

    public void setTimeSpan(Date timeSpan) {
    this.timeSpan = timeSpan;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


