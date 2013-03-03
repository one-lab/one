package com.sinosoft.one.monitor.alarm.repository;
// Generated 2013-3-1 10:29:54 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.common.AlarmMessage;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * 告警信息持久化接口
 */
public interface AlarmRepository extends PagingAndSortingRepository<Alarm, String> {

    @SQL("select * from ge_monitor_alarm where monitor_id = ?1 between ?2 and endTime = ?3")
    List<Alarm> findAlarmByMonitorId(String monitorId,Date startTime,Date endTime);
}

