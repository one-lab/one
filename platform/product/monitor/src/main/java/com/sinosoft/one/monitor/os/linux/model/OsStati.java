package com.sinosoft.one.monitor.os.linux.model;
// Generated 2013-2-27 21:43:48 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * OsStati.

 */
@Entity
@Table(name="GE_MONITOR_OS_STATI"
)
public class OsStati  implements java.io.Serializable {

    /**
        */
    private String id;
    /**
        */
    private String osid;
    /**
        */
    private String type;
    /**
        */
    private Date statiTime;
    /**
        */
    private String leastValue;
    /**
        */
    private String maxValue;
    /**
        */
    private String averageValue;

    public OsStati() {
    }

	
    public OsStati(String id) {
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
    
    @Column(name="OSID", length=32)
    public String getOsid() {
    return this.osid;
    }

    public void setOsid(String osid) {
    this.osid = osid;
    }
    
    @Column(name="TYPE", length=2)
    public String getType() {
    return this.type;
    }

    public void setType(String type) {
    this.type = type;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="STATI_TIME", length=7)
    public Date getStatiTime() {
    return this.statiTime;
    }

    public void setStatiTime(Date statiTime) {
    this.statiTime = statiTime;
    }
    
    @Column(name="LEAST_VALUE", length=10)
    public String getLeastValue() {
    return this.leastValue;
    }

    public void setLeastValue(String leastValue) {
    this.leastValue = leastValue;
    }
    
    @Column(name="MAX_VALUE", length=10)
    public String getMaxValue() {
    return this.maxValue;
    }

    public void setMaxValue(String maxValue) {
    this.maxValue = maxValue;
    }
    
    @Column(name="AVERAGE_VALUE", length=10)
    public String getAverageValue() {
    return this.averageValue;
    }

    public void setAverageValue(String averageValue) {
    this.averageValue = averageValue;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


