package com.sinosoft.one.monitor.application.repository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.UrlResponseTime;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * URL响应时间持久化接口
 * User: carvin
 * Date: 13-3-4
 * Time: 下午4:55
 */
public interface UrlResponseTimeRepository extends PagingAndSortingRepository<UrlResponseTime, String> {
	@SQL("SELECT * FROM GE_MONITOR_URL_RESPONSE_TIME t WHERE t.application_id=?1 and t.record_time >= ?2 AND t.record_time <= ?3")
	List<UrlResponseTime> selectUrlResponseTimes(String applicationId, Date startDate, Date endDate);

	/**
	 * 查询URL响应时间
	 * @param applicationId 应用ID
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return URL响应时间列表
	 */
	@SQL("select u.id as url_Id, u.url, min(urt.min_response_time) as min_response_time," +
			"       max(urt.max_response_time) as max_response_time," +
			"       round(sum(urt.total_response_time)/sum(total_count), 0) as avg_response_time" +
			"  from ge_monitor_application       a," +
			"       ge_monitor_biz_scenario      bs," +
			"       ge_monitor_biz_scenario_url  bsu," +
			"       ge_monitor_url               u," +
			"       ge_monitor_url_response_time urt" +
			"  where a.id=bs.application_id" +
			"  and   bs.id=bsu.biz_scenario_id" +
			"  and   bsu.url_id=u.id" +
			"  and   u.id=urt.url_id(+)" +
			"  and   a.id=?1" +
			"  and   a.status='1'" +
			"  and   bs.status='1'" +
			"  and   u.status='1'" +
			"  and   urt.record_time >= ?2" +
			"  and   urt.record_time < ?3" +
			"  group by u.id, u.url")
	List<UrlResponseTime> selectUrlResponseTimesForMonitorUrl(String applicationId, Date startDate, Date endDate);

	/**
	 * 统计平均响应时间
	 * @param applicationId 应用ID
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return 平均响应时间
	 */
	@SQL("select sum(urt.total_response_time) / sum(urt.total_count) from ge_monitor_url_response_time urt where urt.application_id=?1 and urt.record_time >= ?2 AND urt.record_time <= ?3")
	BigDecimal staAvgResponseTimeSta(String applicationId, Date startDate, Date endDate);

	/**
	 * 根据应用ID，URLID 以及开始结束时间查询响应时间列表
	 * @param applicationId 应用ID
	 * @param urlId URLID
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return 响应时间列表
	 */
	@SQL("SELECT * FROM GE_MONITOR_URL_RESPONSE_TIME t WHERE t.application_id=?1 and t.url_id=?2 and t.record_time >= ?3 AND t.record_time <= ?4")
	List<UrlResponseTime> selectUrlResponseTimes(String applicationId, String urlId, Date startDate, Date endDate);
}
