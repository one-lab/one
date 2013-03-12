package com.sinosoft.one.monitor.db.oracle.repository;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.db.oracle.model.Ava;
import com.sinosoft.one.monitor.utils.AvailableCalculate.AvailableCountsGroupByInterval;
import com.sinosoft.one.monitor.utils.AvailableCalculate.AvailableInf;


public interface AvaRepository extends PagingAndSortingRepository<Ava, String> {

    @SQL("select b.state from " +
            "" +"(select * from GE_MONITOR_ORACLE_AVA order by record_time desc) b" +
            "  where  rownum=1")
    String findState();
    @SQL("select count(a.interval) \"count\", a.interval \"interval\" from GE_MONITOR_ORACLE_AVA a where a.state='1' and a.record_time > ?1 group by a.interval")
	List<AvailableCountsGroupByInterval> findAvCount(Date inserTime);
    @SQL("select count(a.interval) \"count\", a.interval \"interval\" from GE_MONITOR_ORACLE_AVA a where a.state='0' and a.record_time > ?1 group by a.interval")
	List<AvailableCountsGroupByInterval> findUnAvCount(Date inserTime);
    @SQL("delete from GE_MONITOR_ORACLE_AVA  where record_time < ?1")
	void clear(Date timePoint);
    @SQL("delete from GE_MONITOR_ORACLE_AVA  where DATABASE_ID in (?1)")
    void deleteByMonitorIds(List<String> monitorId);
    @SQL("select * from GE_MONITOR_ORACLE_AVA where record_time > ?1 order by record_time")
    List<Ava> find24Day(Date timeStart);
}

