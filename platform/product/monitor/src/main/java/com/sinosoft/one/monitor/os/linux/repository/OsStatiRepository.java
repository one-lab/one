package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsStati;

public interface OsStatiRepository extends PagingAndSortingRepository<OsStati, String> {

	@SQL("delete from GE_MONITOR_OS_STATI o where o.RECORD_TIME = to_date(?3,?4) and o.TYPE= ?2 and o.OSID= ?1")
	public void deleteStatiRmThisHour(String osInfoId,String type,String recordTime ,String dateFromat);
	
	//一个小时点统计表查询
	@Query("from OsStati o where o.recordTime = to_date(?3,?4) and o.type= ?2 and o.osid= ?1")
	public OsStati getStatiThisTime(String osInfoId,String type,String recordTime ,String dateFromat);
	
	
	//时间段内的所有某类型记录
	@Query("from OsStati o where o.recordTime between to_date(?3,?5) and to_date(?4,?5) and o.type= ?2 and o.osid= ?1 ORDER by o.recordTime")
	public  List<OsStati> findStatiByTimeSpan(String osInfoId,String type,String begin ,String end, String dateFromat);
	

	//时间段内的最大值
	@SQL("select Max(MAX_VALUE) from GE_MONITOR_OS_STATI where RECORD_TIME = to_date(?3,?4) and TYPE= ?2 and OSID= ?1 ")
	public String findStatiMaxByTimeSpan(String osInfoId,String type,String day , String dateFromat);
	
	//时间段内的所有某类型记录
	@SQL("select Min(MIN_VALUE) from GE_MONITOR_OS_STATI where RECORD_TIME = to_date(?3,?4) and TYPE= ?2 and OSID= ?1 ")
	public String findStatiMinByTimeSpan(String osInfoId,String type,String begin , String dateFromat);
	
	//时间段内的所有某类型记录
	@SQL("select SUM(AVERAGE_VALUE)/COUNT(*) from GE_MONITOR_OS_STATI where RECORD_TIME = to_date(?3,?4) and TYPE= ?2 and OSID= ?1 ")
	public String findStatiAveByTimeSpan(String osInfoId,String type,String begin , String dateFromat);
}

