package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;
import java.util.List;

import com.sinosoft.one.monitor.os.linux.model.OsCpu;

/**
 * 信息处理类
 * @author chenxiongxi
 * @version 1.0
 * @created 27-����-2013 14:42:30
 */
public interface OsProsessService {

	/**
	 * cpu最大值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  int cpuMax(Date bigin,Date end, List<OsCpu> osCpus);
	
	/**
	 * cpu最小值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  int cpuMin(Date bigin,Date end, List<OsCpu> osCpus);
	
	/**
	 * cpu平均值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  float cpuAve(Date bigin,Date end, List<OsCpu> osCpus);
	
	
	
	/**
	 * 内存最大值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  int ramMax(Date bigin,Date end, List<OsCpu> osCpus);
	
	/**
	 * 内存最小值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  int ramMin(Date bigin,Date end, List<OsCpu> osCpus);
	
	
	/**
	 * 内存平均值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  float ramAve(Date bigin,Date end, List<OsCpu> osCpus);
	
	/**
	 * 磁盘最大值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  int diskMax(Date bigin,Date end, List<OsCpu> osCpus);
	
	/**
	 * 磁盘最小值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  int diskMin(Date bigin,Date end, List<OsCpu> osCpus);
	/**
	 * 磁盘平均值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  float diskAve(Date bigin,Date end, List<OsCpu> osCpus);
	/**
	 * 磁盘最大值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  int respondTimeMax(Date bigin,Date end, List<OsCpu> osCpus);
	/**
	 * 磁盘最小值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public int respondTimeMin(Date bigin,Date end, List<OsCpu> osCpus);
	
	/**
	 * 磁盘平均值
	 * @param bigin
	 * @param end
	 * @param osCpus
	 */
	public  float respondTimeAve(Date bigin,Date end, List<OsCpu> osCpus);

	public void sendMsg();

}