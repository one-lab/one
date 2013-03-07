package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;
import com.sinosoft.one.monitor.utils.AvailableCalculate;
import com.sinosoft.one.monitor.utils.AvailableCalculate.AvailableDetail;

public interface OsAvailabletempRepository extends PagingAndSortingRepository<OsAvailabletemp, String> {
	
	//根据时间
	@Query("from OsAvailabletemp o where o.sampleDate between to_date(?2,?4) and to_date(?3,?4) and o.os.osInfoId= ?1 ORDER by o.sampleDate")
	public List<OsAvailabletemp> findOsAvailabletempByDate(String osid,String beginTime,String endTime,String dateFormat);

	//根据时间和状态
	@Query("from OsAvailabletemp o where o.sampleDate between to_date(?2,?4) and to_date(?3,?4) and o.os.osInfoId= ?1 and o.status= ?5 ORDER by o.sampleDate")
	public List<OsAvailabletemp> findAvailabletempByDateAndSt(String osid,String beginTime,String endTime,String dateFormat ,String status);
	
	//根据时间段删除
	@SQL("delete from GE_MONITOR_OS_AVAILABLETEMP o where o.record_time between ?2 and ?3 and o.OS_INFO_ID= ?1 ")
	public void deleteOsAvailabletempByDate(String osid,Date beginTime,Date endTime );
	
	//获取最后一次轮询记录点时间
//	@SQL("select * from GE_MONITOR_OS_AVAILABLETEMP o where o.sample_date=(select max(sample_date) from GE_MONITOR_OS_AVAILABLETEMP where sample_date<to_date(?2,?3)) and o.OS_INFO_ID= ?1")
	@Query("from OsAvailabletemp o where o.sampleDate=(select max(sampleDate) from OsAvailabletemp where sampleDate<to_date(?2,?3)) and o.os.osInfoId = ?1")
	public OsAvailabletemp findLastAvailable(String osid,String currentTime,String dateFormat );

	//小于目标时间删除
	@SQL("delete from GE_MONITOR_OS_AVAILABLETEMP o where o.SAMPLE_DATE< ?2 and o.OS_INFO_ID= ?1 ")
	public void deleteTempByLessThanTime(String osid,Date date);
	
	
	//统计临时表的 轮询时间改变次数
	@SQL("select count(intercycle_time) \"count\",intercycle_time \"interval\" from ge_monitor_os_availabletemp where OS_INFO_ID= ?1 and SAMPLE_DATE > to_date(?2,?3) group by intercycle_time")
	public List<AvailableDetail> findGroupByInterCycleTime(String osid,String time,String dateformat);
	
}

