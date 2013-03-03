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
 * EventSta.
* ORACLE事件统计表
 */
@Entity
@Table(name="GE_MONITOR_ORACLE_EVENT_STA"
)
public class EventSta  implements java.io.Serializable {

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
    private String eventType;
    /**
    * 最小值
    */
    private int min;
    /**
    * 最大值.
    */
    private int max;
    /**
     * 平均值
     */
    private int avg;
    /**
    * 记录时间.
    */
    private Date enventRecordTime;

    public EventSta() {
    }

	
    public EventSta(String id) {
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
    
    @Column(name="event_type", length=2)
    public String getEventType() {
    return this.eventType;
    }

    public void setEventType(String eventType) {
    this.eventType = eventType;
    }
    
    @Column(name="min")
    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    @Column(name="max")
    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    @Column(name="avg")
    public int getAvg() {
        return this.avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="envent_record_time")
    public Date getEnventRecordTime() {
    return this.enventRecordTime;
    }

    public void setEnventRecordTime(Date enventRecordTime) {
    this.enventRecordTime = enventRecordTime;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


