package com.sinosoft.one.monitor.dao.warn;

// Generated 2012-12-26 16:15:21 by One Data Tools 1.0.0

import java.util.Date;
import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.model.warn.Email;
import com.sinosoft.one.mvc.web.annotation.Param;

public interface EmailDao extends PagingAndSortingRepository<Email, String>,
		QueryDslPredicateExecutor<Email> {
	Email findByOwnerAndAddress(String owner, String address);

	@SQL("update GE_MONITOR_EMAIL set address=?2 ,create_time=?3 where id=?1")
	void updateEmailAddressAndCreateTimeById(@Param("id") String id,
			@Param("address") String address, @Param("date") Date date);

	@SQL("select * from GE_MONITOR_EMAIL where appname is null #if(:appName!=null) {and appname=:appName}")
	List<Email> findAllByAppname(@Param("appName") String appname);

}
