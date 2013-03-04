package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsStati;

public interface OsStatiRepository extends PagingAndSortingRepository<OsStati, String> {

	@SQL("delete from GE_MONITOR_OS_STATI o where o.RECORD_TIME = to_date(?3,?4) and o.TYPE= ?2 and o.OSID= ?1")
	public void deleteStatiRmThisHour(String osInfoId,String type,String recordTime ,String dateFromat);
	
	@Query("from OsStati o where o.recordTime = to_date(?3,?4) and o.type= ?2 and o.osid= ?1")
	public OsStati getStatiRmThisHour(String osInfoId,String type,String recordTime ,String dateFromat);
}

