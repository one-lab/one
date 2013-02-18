package com.sinosoft.one.monitor.model;
// Generated 2013-1-8 17:51:26 by One Data Tools 1.0.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * App.

 */
@Entity
@Table(name="GE_MONITOR_APP"
)
public class App  implements java.io.Serializable {

    /**
        */
    private String id;
    /**
        */
    private String name;
    /**
        */
    private String status;

    public App() {
    }

	
    public App(String id) {
        this.id = id;
    }
   
    @Id 
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name="ID", unique=true, length=32)
    public String getId() {
    return this.id;
    }

    public void setId(String id) {
    this.id = id;
    }
    @Column(name="NAME", length=100)
    public String getName() {
    return this.name;
    }

    public void setName(String name) {
    this.name = name;
    }
    
    @Column(name="STATUS", length=1)
    public String getStatus() {
    return this.status;
    }

    public void setStatus(String status) {
    this.status = status;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


