package com.sinosoft.one.monitor.alarm.repository;
// Generated 2013-3-1 10:29:54 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.common.AlarmMessage;
import com.sinosoft.one.monitor.common.HealthSta;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * 告警信息持久化接口
 */
public interface AlarmRepository extends PagingAndSortingRepository<Alarm, String> {

    @SQL("select * from ge_monitor_alarm where monitor_id = ?1 and create_time between ?2 and ?3")
    List<Alarm> findAlarmByMonitorId(String monitorId, Date startTime, Date endTime);

	/**
	 * 根据监视器ID，开始结束时间查询健康度统计数据
	 * @param monitorId 监视器ID
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return 健康度统计对象列表
	 */
	@SQL("select severity, count(1) from ge_monitor_alarm where monitor_id=?1 and create_time between ?2 and ?3 group by severity")
	List<HealthSta> selectHealthSta(String monitorId, Date startTime, Date endTime);
}

