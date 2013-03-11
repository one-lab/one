package com.sinosoft.one.monitor.db.oracle.repository;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.db.oracle.model.Lastevent;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;


public interface LasteventRepository extends PagingAndSortingRepository<Lastevent, String> {
    @SQL("select t.record_time from ge_monitor_oracle_lastevent t where rownum=1 order by t.record_time desc")
    Date findLastExecTime();
    @SQL("select t1.* from ge_monitor_oracle_lastevent t1 WHERE record_time between ?2 AND ?3 order by record_time")
    List<Lastevent> findLastEventList(String monitorId, Date start, Date end);
    @SQL("delete from GE_MONITOR_ORACLE_LASTEVENT  where record_time < ?1")
	void clear(Date timePoint);
    @SQL("delete from GE_MONITOR_ORACLE_LASTEVENT  where DATABASE_ID in (?1)")
    void deleteByMonitorIds(List<String> monitorId);
}

