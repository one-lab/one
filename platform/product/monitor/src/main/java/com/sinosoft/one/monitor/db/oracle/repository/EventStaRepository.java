package com.sinosoft.one.monitor.db.oracle.repository;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.db.oracle.model.EventSta;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;


public interface EventStaRepository extends PagingAndSortingRepository<EventSta, String> {
   
	@SQL("select * from GE_MONITOR_ORACLE_EVENT_STA where event_type = ?3 and envent_record_time between ?1 and ?2")
    List<EventSta> findAllByTimeAndType(Date time, Date now,String eventType);

    @SQL("select t.* from Ge_Monitor_Oracle_Event_Sta t where t.event_type='1' and t.database_id = ?1 and t.event_record_time = ?2")
	EventSta findConnectTimeSta(String monitorId, Date inserTime);
    
    @SQL("select t.* from Ge_Monitor_Oracle_Event_Sta t where t.event_type='2' and t.database_id = ?1 and t.event_record_time = ?2")
	EventSta findActiveCountSta(String monitorId, Date inserTime);
    
    @SQL("select t.* from Ge_Monitor_Oracle_Event_Sta t where t.event_type='3' and t.database_id = ?1 and t.event_record_time = ?2")
	EventSta findHitRateSta(String monitorId, Date inserTime);
}

