package com.sinosoft.one.monitor.model;
// Generated 2013-1-11 10:34:47 by One Data Tools 1.0.0


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Method.
* 监控方法配置
 */
@Entity
@Table(name="GE_MONITOR_METHOD"
)
public class Method  implements java.io.Serializable {

    /**
    * 序号.
    */
    private String id;
    /**
    * 方法全类名，需要定义到类.
    */
    private String className;
    /**
    * 定义方法例如 demo(String,String).
    */
    private String methodName;
    /**
    * 响应阀值.
    */
    private BigDecimal threshold;
    /**
    * 监控等级，分为DEPLOY 、TEST、PRODUCT.
    */
    private String environment;
    /**
    * 状态0：锁定 1 正常.
    */
    private String status;
    /**
    * 应用序号.
    */
    private String appId;
    /**
    * 频率.
    */
    private String interval;

    public Method() {
    }

	
    public Method(String id) {
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
    
    @Column(name="CLASS_NAME", length=100)
    public String getClassName() {
    return this.className;
    }

    public void setClassName(String className) {
    this.className = className;
    }
    
    @Column(name="METHOD_NAME", length=100)
    public String getMethodName() {
    return this.methodName;
    }

    public void setMethodName(String methodName) {
    this.methodName = methodName;
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
    return this.environment;
    }

    public void setEnvironment(String environment) {
    this.environment = environment;
    }
    
    @Column(name="STATUS", length=1)
    public String getStatus() {
    return this.status;
    }

    public void setStatus(String status) {
    this.status = status;
    }
    
    @Column(name="APP_ID", length=50)
    public String getAppId() {
    return this.appId;
    }

    public void setAppId(String appId) {
    this.appId = appId;
    }
    
    @Column(name="INTERVAL", length=10)
    public String getInterval() {
    return this.interval;
    }

    public void setInterval(String interval) {
    this.interval = interval;
    }


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}


