package com.sinosoft.one.monitor.alarm.model;
// Generated 2013-3-1 10:29:53 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.*;

import com.sinosoft.one.monitor.common.AlarmSource;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Alarm.
* 应用系统预警信息表
 */
@Entity
@Table(name="GE_MONITOR_ALARM"
)
public class Alarm  implements java.io.Serializable {

    /**
    * 主键ID.
    */
    private String id;
    /**
    * 严重级别(severity).
    */
    private SeverityLevel severity;
    /**
    * 警报信息(message).
    */
    private String message;
    /**
    * 警报来源(日志,异常,OS,DB)
    */
    private AlarmSource alarmSource;
    /**
    * 监视器ID.
    */
    private String monitorId;
    /**
    * 监视器类型.
    */
    private String monitorType;
    /**
    * 属性ID.
    */
    private String attributeId;
    /**
    * 创建时间(createtime).
    */
    private Date createTime;
    /**
    * 所有者(ownername).
    */
    private String ownerName;

    public Alarm() {
    }

	
    public Alarm(String id) {
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
    
    @Column(name="severity", length=1)
    @Enumerated(value = EnumType.STRING)
    public SeverityLevel getSeverity() {
    return this.severity;
    }

    public void setSeverity(SeverityLevel severity) {
    this.severity = severity;
    }
    
    @Column(name="message", length=3000)
    public String getMessage() {
    return this.message;
    }

    public void setMessage(String message) {
    this.message = message;
    }
    
    @Column(name="alarm_from", length=20)
    @Enumerated(value = EnumType.STRING)
    public AlarmSource getAlarmSource() {
    return this.alarmSource;
    }

    public void setAlarmSource(AlarmSource alarmSource) {
    this.alarmSource = alarmSource;
    }
    
    @Column(name="monitor_id", length=32)
    public String getMonitorId() {
    return this.monitorId;
    }

    public void setMonitorId(String monitorId) {
    this.monitorId = monitorId;
    }
    
    @Column(name="monitor_type", length=50)
    public String getMonitorType() {
    return this.monitorType;
    }

    public void setMonitorType(String monitorType) {
    this.monitorType = monitorType;
    }
    
    @Column(name="attribute_id", length=32)
    public String getAttributeId() {
    return this.attributeId;
    }

    public void setAttributeId(String attributeId) {
    this.attributeId = attributeId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="create_time", length=7)
    public Date getCreateTime() {
    return this.createTime;
    }

    public void setCreateTime(Date createTime) {
    this.createTime = createTime;
    }
    
    @Column(name="owner_name", length=100)
    public String getOwnerName() {
    return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


