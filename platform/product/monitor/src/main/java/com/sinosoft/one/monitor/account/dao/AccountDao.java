package com.sinosoft.one.monitor.account.dao;
// Generated 2012-12-21 10:49:05 by One Data Tools 1.0.0

import com.sinosoft.one.monitor.account.model.Account;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface AccountDao extends PagingAndSortingRepository<Account, String>, QueryDslPredicateExecutor<Account> {
    Account findByLoginName(String loginName);
}

