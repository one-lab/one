package com.sinosoft.one.monitor.model;
// Generated 2013-1-11 10:34:47 by One Data Tools 1.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Response.
* 测试网站响应速度的表
 */
@Entity
@Table(name="GE_MONITOR_RESPONSE"
)
public class Response  implements java.io.Serializable {

    /**
    * 序号.
    */
    private String serialno;
    /**
    * url名称.
    */
    private String title;
    /**
    * url.
    */
    private String url;
    /**
    * 阀值.
    */
    private String threshold;
    /**
    * 开始测试时间.
    */
    private Date startDate;
    /**
    * 结束测试时间.
    */
    private Date endDate;
    /**
    * 监控状态.
    */
    private String status;
    /**
    * 最高值.
    */
    private String highestValue;
    /**
    * 平均值.
    */
    private String averageValue;
    /**
    * 请求次数.
    */
    private String requestCount;
    /**
    * 超过阀值次数.
    */
    private String overCount;
    /**
        */
    private String appId;
    /**
    * 上次统计是否有效.
    */
    private String isValid;
    /**
    * 频率.
    */
    private String interval;

    public Response() {
    }

	
    public Response(String serialno, String title, String url, String threshold, Date startDate, Date endDate, String status) {
        this.serialno = serialno;
        this.title = title;
        this.url = url;
        this.threshold = threshold;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
   
    @Id 
    
    @Column(name="SERIALNO", unique=true, length=32)
    public String getSerialno() {
    return this.serialno;
    }

    public void setSerialno(String serialno) {
    this.serialno = serialno;
    }
    
    @Column(name="TITLE", length=100)
    public String getTitle() {
    return this.title;
    }

    public void setTitle(String title) {
    this.title = title;
    }
    
    @Column(name="URL", length=1000)
    public String getUrl() {
    return this.url;
    }

    public void setUrl(String url) {
    this.url = url;
    }
    
    @Column(name="THRESHOLD", length=20)
    public String getThreshold() {
    return this.threshold;
    }

    public void setThreshold(String threshold) {
    this.threshold = threshold;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE", length=7)
    public Date getStartDate() {
    return this.startDate;
    }

    public void setStartDate(Date startDate) {
    this.startDate = startDate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE", length=7)
    public Date getEndDate() {
    return this.endDate;
    }

    public void setEndDate(Date endDate) {
    this.endDate = endDate;
    }
    
    @Column(name="STATUS", length=1)
    public String getStatus() {
    return this.status;
    }

    public void setStatus(String status) {
    this.status = status;
    }
    
    @Column(name="HIGHEST_VALUE", length=20)
    public String getHighestValue() {
    return this.highestValue;
    }

    public void setHighestValue(String highestValue) {
    this.highestValue = highestValue;
    }
    
    @Column(name="AVERAGE_VALUE", length=20)
    public String getAverageValue() {
    return this.averageValue;
    }

    public void setAverageValue(String averageValue) {
    this.averageValue = averageValue;
    }
    
    @Column(name="REQUEST_COUNT", length=20)
    public String getRequestCount() {
    return this.requestCount;
    }

    public void setRequestCount(String requestCount) {
    this.requestCount = requestCount;
    }
    
    @Column(name="OVER_COUNT", length=20)
    public String getOverCount() {
    return this.overCount;
    }

    public void setOverCount(String overCount) {
    this.overCount = overCount;
    }
    
    @Column(name="APP_ID", length=32)
    public String getAppId() {
    return this.appId;
    }

    public void setAppId(String appId) {
    this.appId = appId;
    }
    
    @Column(name="IS_VALID", length=1)
    public String getIsValid() {
    return this.isValid;
    }

    public void setIsValid(String isValid) {
    this.isValid = isValid;
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


