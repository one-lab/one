package com.sinosoft.one.monitor.application.repository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.UrlResponseTime;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;

/**
 * URL响应时间持久化接口
 * User: carvin
 * Date: 13-3-4
 * Time: 下午4:55
 */
public interface UrlResponseTimeRepository extends PagingAndSortingRepository<UrlResponseTime, String> {
	@SQL("SELECT * FROM GE_MONITOR_URL_RESPONSE_TIME t WHERE t.record_time >= ?1 AND t_record_time <= ?2")
	List<UrlResponseTime> selectUrlResponseTimes(Date startDate, Date endDate);
}
