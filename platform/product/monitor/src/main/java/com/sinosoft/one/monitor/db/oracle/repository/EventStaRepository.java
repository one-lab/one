package com.sinosoft.one.monitor.db.oracle.repository;
// Generated 2013-2-27 18:10:19 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.db.oracle.model.EventSta;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;


public interface EventStaRepository extends PagingAndSortingRepository<EventSta, String> {
   
	@SQL("select max(e.max) max , min(e.min) min, avg(e.avg)  avg ,to_date(to_char(e.event_record_time, 'yyyy-MM-dd'),'yyyy-MM-dd') eventRecordTime from ge_monitor_oracle_event_sta e where e.event_record_time between ?1 and ?2 and e.event_type = ?3 group by to_char(e.event_record_time, 'yyyy-MM-dd')")
    List<EventSta> findAllByTimeAndType(Date time, Date now,String eventType);

    @SQL("select t.* from Ge_Monitor_Oracle_Event_Sta t where t.event_type='1' and t.database_id = ?1 and t.event_record_time = ?2")
	EventSta findConnectTimeSta(String monitorId, Date inserTime);
    
    @SQL("select t.* from Ge_Monitor_Oracle_Event_Sta t where t.event_type='2' and t.database_id = ?1 and t.event_record_time = ?2")
	EventSta findActiveCountSta(String monitorId, Date inserTime);
    
    @SQL("select t.* from Ge_Monitor_Oracle_Event_Sta t where t.event_type='3' and t.database_id = ?1 and t.event_record_time = ?2")
	EventSta findHitRateSta(String monitorId, Date inserTime);

    @SQL("delete from Ge_Monitor_Oracle_Event_Sta where database_id in (?1)")
    void deleteByMonitorIds(List<String> monitorId);
}

