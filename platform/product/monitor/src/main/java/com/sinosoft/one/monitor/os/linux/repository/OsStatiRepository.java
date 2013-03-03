package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsStati;

public interface OsStatiRepository extends PagingAndSortingRepository<OsStati, String> {

	@SQL("delete GE_MONITOR_OS_STATI where OSID= ?1 and TYPE= ?2 and RECORD_TIME=to_date(?3,?4)")
	public void deleteStatiRmThisHour(String osInfoId,String type,String recordTime,String dateFormat);
}

