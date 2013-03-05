package com.sinosoft.one.monitor.db.oracle.model;
// Generated 2013-3-4 21:44:43 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * AvaSta.
* ORACLE可用性统计表
 */
@Entity
@Table(name="GE_MONITOR_ORACLE_AVA_STA"
)
public class AvaSta  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
    * 主键ID.
    */
    private String id;
    /**
    * 数据库ID.
    */
    private Info info;
    /**
    * 正常运行时间.
    */
    private long normalRuntime;
    /**
    * 总停机时间.
    */
    private long totalPoweroffTime;
    /**
    * 停机次数.
    */
    private long poweroffCount;
    /**
    * 平均故障间隔时间.
    */
    private long avgFailureTime;
    /**
    * 记录时间.
    */
    private Date avaRecordTime;
    /**
    * 统计次数.
    */
    private long recordCount;

    public AvaSta() {
    }

	
    public AvaSta(String id) {
        this.id = id;
    }
   
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="ID", unique=true, length=32)
    public String getId() {
    return this.id;
    }

    public void setId(String id) {
    this.id = id;
    }
    @ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="DATABASE_ID")
    public Info getInfo() {
    return this.info;
    }

    public void setInfo(Info info) {
    this.info = info;
    }
    
    @Column(name="NORMAL_RUNTIME")
    public long getNormalRuntime() {
    return this.normalRuntime;
    }

    public void setNormalRuntime(long normalRuntime) {
    this.normalRuntime = normalRuntime;
    }
    
    @Column(name="TOTAL_POWEROFF_TIME")
    public long getTotalPoweroffTime() {
    return this.totalPoweroffTime;
    }

    public void setTotalPoweroffTime(long totalPoweroffTime) {
    this.totalPoweroffTime = totalPoweroffTime;
    }
    
    @Column(name="POWEROFF_COUNT")
    public long getPoweroffCount() {
    return this.poweroffCount;
    }

    public void setPoweroffCount(long poweroffCount) {
    this.poweroffCount = poweroffCount;
    }
    
    @Column(name="AVG_FAILURE_TIME")
    public long getAvgFailureTime() {
    return this.avgFailureTime;
    }

    public void setAvgFailureTime(long avgFailureTime) {
    this.avgFailureTime = avgFailureTime;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="AVA_RECORD_TIME")
    public Date getAvaRecordTime() {
    return this.avaRecordTime;
    }

    public void setAvaRecordTime(Date avaRecordTime) {
    this.avaRecordTime = avaRecordTime;
    }
    
    @Column(name="RECORD_COUNT")
    public long getRecordCount() {
    return this.recordCount;
    }

    public void setRecordCount(long recordCount) {
    this.recordCount = recordCount;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


