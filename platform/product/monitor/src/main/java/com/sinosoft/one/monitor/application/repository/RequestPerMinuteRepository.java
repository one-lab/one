package com.sinosoft.one.monitor.application.repository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.RequestPerMinute;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * 每分钟请求数持久化类
 * User: carvin
 * Date: 13-3-4
 * Time: 下午4:57
 */
public interface RequestPerMinuteRepository extends PagingAndSortingRepository<RequestPerMinute, String> {
	@SQL("SELECT * FROM GE_MONITOR_REQUEST_PER_MINUTE t WHERE t.record_time >= ?1 AND t_record_time <= ?2")
	List<RequestPerMinute> selectRequestPerMinutes(Date startDate, Date endDate);
}
