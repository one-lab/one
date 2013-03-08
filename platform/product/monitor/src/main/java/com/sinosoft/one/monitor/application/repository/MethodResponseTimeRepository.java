package com.sinosoft.one.monitor.application.repository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.MethodResponseTime;
import com.sinosoft.one.monitor.application.model.UrlResponseTime;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 方法响应时间持久化接口
 * User: carvin
 * Date: 13-3-4
 * Time: 下午4:55
 */
public interface MethodResponseTimeRepository extends PagingAndSortingRepository<MethodResponseTime, String> {
	@SQL("SELECT * FROM GE_MONITOR_METHOD_RESPONSETIME t WHERE t.application_id=?1 and t.url_id=?2" +
			" and t.method_name in (?3) and to_char(t.record_time, 'yyyy-MM-dd HH24')=?4")
	List<MethodResponseTime> selectMethodResponseTimes(String applicationId, String urlId, List<String> methodNames, String dateStr);


}
