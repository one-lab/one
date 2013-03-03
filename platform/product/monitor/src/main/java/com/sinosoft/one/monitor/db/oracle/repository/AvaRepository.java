package com.sinosoft.one.monitor.db.oracle.repository;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.db.oracle.model.Ava;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface AvaRepository extends PagingAndSortingRepository<Ava, String> {

    @SQL("select b.state from GE_MONITOR_ORACLE_AVA b where  rownum=1 order by b.record_time desc")
    String findState();
}

