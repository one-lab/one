package com.sinosoft.one.monitor.db.oracle.model;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * Lastevent.
* ORACLE最近一小时事件记录
 */
@Entity
@Table(name="GE_MONITOR_ORACLE_LASTEVENT"
)
public class Lastevent  implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7132247988935876283L;
	/**
    * 主键ID.
    */

    private String id;
    /**
    * 数据库ID.
    */
    private Info info;
    /**
    * 活动连接数.
    */
    private int activeCount;
    /**
    * 连接时间.
    */
    private long connectTime;
    /**
    * 缓冲区命中率.
    */
    private Double bufferHitRate;
    /**
        */
    private Double dickHitRate;
    /**
        */
    private Double bufferLibHitRate;
    /**
    * 记录时间.
    */
    private Date recordTime;

    public Lastevent() {
    }

	
    public Lastevent(String id) {
        this.id = id;
    }
   
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
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
    
    @Column(name="active_count")
    public int getActiveCount() {
    return this.activeCount;
    }

    public void setActiveCount(int activeCount) {
    this.activeCount = activeCount;
    }
    
    @Column(name="connect_time")
    public long getConnectTime() {
    return this.connectTime;
    }

    public void setConnectTime(long connectTime) {
    this.connectTime = connectTime;
    }
    
    @Column(name="buffer_hit_rate")
    public Double getBufferHitRate() {
    return this.bufferHitRate;
    }

    public void setBufferHitRate(Double bufferHitRate) {
    this.bufferHitRate = bufferHitRate;
    }
    
    @Column(name="dick_hit_rate")
    public Double getDickHitRate() {
    return this.dickHitRate;
    }

    public void setDickHitRate(Double dickHitRate) {
    this.dickHitRate = dickHitRate;
    }
    
    @Column(name="buffer_lib_hit_rate")
    public Double getBufferLibHitRate() {
    return this.bufferLibHitRate;
    }

    public void setBufferLibHitRate(Double bufferLibHitRate) {
    this.bufferLibHitRate = bufferLibHitRate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="record_time")
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


