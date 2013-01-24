package com.sinosoft.one.monitor.model;
// Generated 2013-1-8 17:51:26 by One Data Tools 1.0.0


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * Url.
* 监控URL配置
 */
@Entity
@Table(name="GE_MONITOR_URL"
)
public class Url  implements java.io.Serializable {

    /**
    * 序号.
    */
    private String id;
    /**
    * 应用序号.
    */
    private String appId;
    /**
    * url名称.
    */
    private String name;
    /**
    * url路径.
    */
    private String url;
    /**
    * 阀值.
    */
    private BigDecimal threshold;
    /**
    * 环境 TEST DEVELOP  PRODUCT.
    */
    private String environment;
    /**
    * 状态0:锁定1正常.
    */
    private String status;

    /**
     * 频率
     */
    private String interval;
    
    public Url() {
    }

	
    public Url(String id) {
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
    
    @Column(name="APP_ID", length=50)
    public String getAppId() {
    return this.appId;
    }

    public void setAppId(String appId) {
    this.appId = appId;
    }
    
    @Column(name="NAME", length=100)
    public String getName() {
    return this.name;
    }

    public void setName(String name) {
    this.name = name;
    }
    
    @Column(name="URL", length=150)
    public String getUrl() {
    return this.url;
    }

    public void setUrl(String url) {
    this.url = url;
    }
    
    @Column(name="THRESHOLD", precision=22, scale=0)
    public BigDecimal getThreshold() {
    return this.threshold;
    }

    public void setThreshold(BigDecimal threshold) {
    this.threshold = threshold;
    }
    
    @Column(name="ENVIRONMENT", length=10)
    public String getEnvironment() {
		return environment;
	}


	public void setEnvironment(String environment) {
		this.environment = environment;
	}
    @Column(name="STATUS", length=1)
    public String getStatus() {
    return this.status;
    }
    @Column(name="INTERVAL", length=10)
	public String getInterval() {
		return interval;
	}


	public void setInterval(String interval) {
		this.interval = interval;
	}


	public void setStatus(String status) {
    this.status = status;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


