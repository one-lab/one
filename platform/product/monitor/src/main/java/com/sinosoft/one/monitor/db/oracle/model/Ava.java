package com.sinosoft.one.monitor.db.oracle.model;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0


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
 * Ava.
* ORACLE可用性临时表
 */
@Entity
@Table(name="GE_MONITOR_ORACLE_AVA"
)
public class Ava  implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8796911059465980475L;
	/**
    * 主键ID.
    */
    private String id;
    /**
    * 数据库ID.
    */
    private Info info;
    /**
    * 记录时间.
    */
    private Date recordTime;
    /**
        */
    private String state;

    public Ava() {
    }

	
    public Ava(String id) {
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
    @Temporal(TemporalType.DATE)
    @Column(name="record_time", length=7)
    public Date getRecordTime() {
    return this.recordTime;
    }

    public void setRecordTime(Date recordTime) {
    this.recordTime = recordTime;
    }
    
    @Column(name="state", length=1)
    public String getState() {
    return this.state;
    }

    public void setState(String state) {
    this.state = state;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


