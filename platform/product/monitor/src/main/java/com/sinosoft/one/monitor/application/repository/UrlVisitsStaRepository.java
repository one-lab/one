package com.sinosoft.one.monitor.application.repository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.UrlVisitsSta;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

/**
 * URL访问量统计持久化类
 * User: carvin
 * Date: 13-3-4
 * Time: 下午10:17
 */
public interface UrlVisitsStaRepository extends PagingAndSortingRepository<UrlVisitsSta, String> {
	UrlVisitsSta findByUrlId(String urlId);

	/**
	 * 统计访问数量
	 * @param applicationId 应用ID
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return 访问数量
	 */
	@SQL("select sum(visit_number) from ge_monitor_url_visits_sta where application_id=?1 and record_time between ?2 and ?3")
	int countVisits(String applicationId, Date startTime, Date endTime);
}
