package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.Os;

public interface OsRepository extends PagingAndSortingRepository<Os, String> {
	
	@Query("from Os where ipAddr= ?1")
    public Os findOsbyIp(String ipAddr);
	
	@SQL("select count(*) from GE_MONITOR_OS where IP_ADDR= ?1")
	public int checkOsByIp(String ipAddr);
}

