package com.sinosoft.one.monitor.application.repository;

import com.sinosoft.one.monitor.application.model.UrlVisitsSta;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * URL访问量统计持久化类
 * User: carvin
 * Date: 13-3-4
 * Time: 下午10:17
 */
public interface UrlVisitsStaRepository extends PagingAndSortingRepository<UrlVisitsSta, String> {
	UrlVisitsSta findByUrlId(String urlId);
}
