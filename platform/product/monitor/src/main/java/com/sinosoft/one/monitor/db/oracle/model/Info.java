package com.sinosoft.one.monitor.db.oracle.model;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * Info.
 * Oracle数据库信息表
 */
@Entity
@Table(name = "GE_MONITOR_ORACLE_INFO"
)
public class Info implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3237826912763771365L;
	/**
     * 主键ID.
     */
    private String id;
    /**
     * 版本.
     */
    private String version;
    /**
     * 数据库启动时间
     */
    private String startTime;
    /**
     * 名称.
     */
    private String name;
    /**
     * IP地址.
     */
    private String ipAddress;
    /**
     * 子网掩码.
     */
    private String subnetMask;
    /**
     * 端口.
     */
    private String port;
    /**
     * 轮询间隔.
     */
    private int pullInterval;
    /**
     * 用户名.
     */
    private String username;
    /**
     * 密码.
     */
    private String password;
    /**
     * 服务名.
     */
    private String instanceName;
    /**
     * 系统时间
     */
    private Date sysTime;
    /**
     *  可用性统计表
     */
    private List<AvaSta> avaStas = new ArrayList<AvaSta>(0);
    /**
     *  事件统计表
     */
    private List<EventSta> eventStas = new ArrayList<EventSta>(0);
    /**
     *  事件临时表
     */
    private List<Lastevent> lastevents = new ArrayList<Lastevent>(0);
    /**
     * 可用性临时表
     */
    private List<Ava> avas = new ArrayList<Ava>(0);

    public Info() {
    }


    public Info(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", unique = true, length = 32)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "version", length = 50)
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Column(name = "name", length = 80)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ip_address", length = 30)
    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Column(name = "subnet_mask", length = 30)
    public String getSubnetMask() {
        return this.subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    @Column(name = "port", length = 5)
    public String getPort() {
        return this.port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Column(name = "pull_interval")
    public int getPullInterval() {
        return this.pullInterval;
    }

    public void setPullInterval(int pullInterval) {
        this.pullInterval = pullInterval;
    }

    @Column(name = "username", length = 100)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "instance_name", length = 20)
    public String getInstanceName() {
        return this.instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "sys_time")
    public Date getSysTime() {
        return this.sysTime;
    }

    public void setSysTime(Date sysTime) {
        this.sysTime = sysTime;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "info", cascade = CascadeType.ALL)
    public List<AvaSta> getAvaStas() {
        return this.avaStas;
    }

    public void setAvaStas(List<AvaSta> avaStas) {
        this.avaStas = avaStas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "info", cascade = CascadeType.ALL)
    public List<EventSta> getEventStas() {
        return this.eventStas;
    }

    public void setEventStas(List<EventSta> eventStas) {
        this.eventStas = eventStas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "info", cascade = CascadeType.ALL)
    public List<Lastevent> getLastevents() {
        return this.lastevents;
    }

    public void setLastevents(List<Lastevent> lastevents) {
        this.lastevents = lastevents;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "info", cascade = CascadeType.ALL)
    public List<Ava> getAvas() {
        return this.avas;
    }

    public void setAvas(List<Ava> avas) {
        this.avas = avas;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getStartTime() {
        return startTime;
    }
    @Column(name = "start_time")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}


