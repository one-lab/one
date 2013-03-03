package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsAvailable;

public interface OsAvailableRepository extends PagingAndSortingRepository<OsAvailable, String> {
	
	//删除可用性统计记录
	@SQL("delete GE_MONITOR_OS_AVAILABLE where OS_INFO_ID=?1 and TIME_SPAN= to_date(?2,?3)")
	public void deleteOsAvailableByDate(String osInfoId,String timeSpan ,String dateFormat);
}

