package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsAvailable;

public interface OsAvailableRepository extends PagingAndSortingRepository<OsAvailable, String> {
	
	//删除可用性统计记录
	@SQL("delete GE_MONITOR_OS_AVAILABLE where OS_INFO_ID=?1 and TIME_SPAN= ?2")
	public void deleteOsAvailableByDate(String osInfoId,Date timeSpan );
	
	//根据时间获取可用性统计记录
	@Query("from OsAvailable o where o.os.osInfoId=?1 and o.timeSpan = to_date(?2,?3)")
	public OsAvailable getOsAvailableByDate(String osInfoId,String timeSpan ,String dateFormat);
}

