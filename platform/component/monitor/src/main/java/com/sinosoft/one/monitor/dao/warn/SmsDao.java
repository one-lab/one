package com.sinosoft.one.monitor.dao.warn;
// Generated 2012-12-26 16:15:21 by One Data Tools 1.0.0

import java.util.Date;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.model.warn.Sms;
import com.sinosoft.one.mvc.web.annotation.Param;


public interface SmsDao extends PagingAndSortingRepository<Sms, String>, QueryDslPredicateExecutor<Sms> {
    Sms findByOwnerAndPhoneNo(String owner, String phoneNo);

    @SQL("update GE_MONITOR_SMS set phone_no=?2 ,create_time=?3 where id=?1")
    void updateSmsPhonenoAndCreateTimeById(@Param("id") String id,@Param("phoneno") String phoneno,@Param("date") Date date);
}

