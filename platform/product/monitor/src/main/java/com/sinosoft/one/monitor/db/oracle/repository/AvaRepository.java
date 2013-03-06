package com.sinosoft.one.monitor.db.oracle.repository;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0

import java.util.Date;
import java.util.List;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.db.oracle.model.Ava;
import com.sinosoft.one.monitor.utils.AvailableCalculate.AvailableDetail;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface AvaRepository extends PagingAndSortingRepository<Ava, String> {

    @SQL("select b.state from GE_MONITOR_ORACLE_AVA b where  rownum=1 order by b.record_time desc")
    String findState();
    @SQL("select count(a.interval) \"count\", a.interval \"interval\" from GE_MONITOR_ORACLE_AVA a where a.state='1' and a.record_time > to_date(?1,'yyyy-MM-dd HH:mm:ss') group by a.interval")
	List<AvailableDetail> findAvCount(Date inserTime);
    @SQL("select count(a.interval) \"count\", a.interval \"interval\" from GE_MONITOR_ORACLE_AVA a where a.state='0' and a.record_time > to_date(?1,'yyyy-MM-dd HH:mm:ss') group by a.interval")
	List<AvailableDetail> findUnAvCount(Date inserTime);
    @SQL("delete from GE_MONITOR_ORACLE_AVA  where record_time < to_date(?1,'yyyy-MM-dd HH:mm:ss')")
	void clear(Date timePoint);
}

