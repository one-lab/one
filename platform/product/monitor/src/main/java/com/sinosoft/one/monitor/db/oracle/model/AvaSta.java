package com.sinosoft.one.monitor.db.oracle.model;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0


import java.math.BigDecimal;
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
 * AvaSta.
* ORACLE可用性统计表
 */
@Entity
@Table(name="GE_MONITOR_ORACLE_AVA_STA"
)
public class AvaSta  implements java.io.Serializable {

    /**
    * 主键ID.
    */
    private String id;
    /**
    * 数据库ID.
    */
    private Info info;
    /**
        */
    private long normalRuntime;
    /**
        */
    private  long totalPoweroffTime;
    /**
        */
    private long poweroffCount;
    /**
        */
    private long avgFailureTime;
    /**
    * 记录时间.
    */
    private Date avaRecordTime;

    public AvaSta() {
    }

	
    public AvaSta(String id) {
        this.id = id;
    }
   
    @Id 
    
    @Column(name="id", unique=true, length=32)
    public String getId() {
    return this.id;
    }

    public void setId(String id) {
    this.id = id;
    }
    @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="database_id")
    public Info getInfo() {
    return this.info;
    }

    public void setInfo(Info info) {
    this.info = info;
    }
    
    @Column(name="normal_runtime")
    public long getNormalRuntime() {
    return this.normalRuntime;
    }

    public void setNormalRuntime(long normalRuntime) {
    this.normalRuntime = normalRuntime;
    }
    
    @Column(name="total_poweroff_time")
    public long getTotalPoweroffTime() {
    return this.totalPoweroffTime;
    }

    public void setTotalPoweroffTime(long totalPoweroffTime) {
    this.totalPoweroffTime = totalPoweroffTime;
    }
    
    @Column(name="poweroff_count")
    public long getPoweroffCount() {
    return this.poweroffCount;
    }

    public void setPoweroffCount(long poweroffCount) {
    this.poweroffCount = poweroffCount;
    }
    
    @Column(name="avg_failure_time")
    public long getAvgFailureTime() {
    return this.avgFailureTime;
    }

    public void setAvgFailureTime(long avgFailureTime) {
    this.avgFailureTime = avgFailureTime;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="ava_record_time", length=7)
    public Date getAvaRecordTime() {
    return this.avaRecordTime;
    }

    public void setAvaRecordTime(Date avaRecordTime) {
    this.avaRecordTime = avaRecordTime;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


