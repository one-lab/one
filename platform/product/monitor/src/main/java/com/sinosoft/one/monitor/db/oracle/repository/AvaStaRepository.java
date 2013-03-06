package com.sinosoft.one.monitor.db.oracle.repository;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0

import java.util.Date;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.db.oracle.model.AvaSta;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AvaStaRepository extends PagingAndSortingRepository<AvaSta, String> {

    @SQL("select * from GE_MONITOR_ORACLE_AVA_STA a   where a.database_id=?1 and rownum=1 order by a.ava_record_time desc")
    AvaSta findAvaSta(String monitorId);
    @SQL("select * from GE_MONITOR_ORACLE_AVA_STA a   where a.database_id=?1 and rownum=1 and a.ava_record_time = ?2")
    AvaSta findAvaStaByTime(String monitorId,Date inserTime);
}

