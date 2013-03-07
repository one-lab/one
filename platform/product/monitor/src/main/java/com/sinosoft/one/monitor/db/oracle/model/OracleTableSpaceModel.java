package com.sinosoft.one.monitor.db.oracle.model;

import javax.persistence.Transient;

/**
 * User: Chunliang.Han
 * Date: 13-2-27
 * Time: 下午10:33
 * 表空间信息对象
 */
/*
表空间名称
总空间大小
总模块数
已使用
使用率
未使用
未使用率
表空间状态
 */
public class OracleTableSpaceModel {
	
	private String id;
	@Transient
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String statusBar = "<div class='bg_bar'><div class='red_bar' style='width:10%'></div></div>";
	@Transient
	public String getStatusBar() {
		return statusBar;
	}

	public void setStatusBar(String statusBar) {
		this.statusBar = statusBar;
	}

	/**
     * 表空间名称
     */
    private String tableSpaceName;
    /**
     * 总空间大小
     */
    private String totalSize;
    /**
     * 总模块数
     */
    private String totalBlock;
    /**
     * 已使用
     */
    private String used;
    /**
     * 使用率
     */
    private String usedRate;
    /**
     * 未使用
     */
    private String unused;
    /**
     * 未使用率
     */
    private String unusedRate;


    public String getTableSpaceName() {
        return tableSpaceName;
    }

    public void setTableSpaceName(String tableSpaceName) {
        this.tableSpaceName = tableSpaceName;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public String getTotalBlock() {
        return totalBlock;
    }

    public void setTotalBlock(String totalBlock) {
        this.totalBlock = totalBlock;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getUsedRate() {
        return usedRate;
    }

    public void setUsedRate(String usedRate) {
        this.usedRate = usedRate;
    }

    public String getUnused() {
        return unused;
    }

    public void setUnused(String unused) {
        this.unused = unused;
    }

    public String getUnusedRate() {
        return unusedRate;
    }

    public void setUnusedRate(String unusedRate) {
        this.unusedRate = unusedRate;
    }

}
