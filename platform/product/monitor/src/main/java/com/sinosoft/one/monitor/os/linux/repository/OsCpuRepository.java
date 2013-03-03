package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsCpu;

public interface OsCpuRepository extends PagingAndSortingRepository<OsCpu, String> {
	
	//根据时间
	@Query("from OsCpu o where o.sampleDate between to_date(?2,?4) and to_date(?3,?4) and o.os.osInfoId= ?1 ORDER by o.sampleDate")
	public List<OsCpu> findOsCpuByDate(String osid,String beginTime,String endTime,String dateFormat);
	
	//CPU利用率最大值
	@SQL("select MAX(UTILI_ZATION) from GE_MONITOR_OS_CPU where SAMPLE_DATE between to_date(?2,?4) and to_date(?3,?4) and OS_INFO_ID= ?1 ")
	public String findMaxCpuUtilZation(String osInfoId,String begin,String end,String dateFormat);
	
	//CPU利用率最小值
	@SQL("select MIN(UTILI_ZATION) from GE_MONITOR_OS_CPU where SAMPLE_DATE between to_date(?2,?4) and to_date(?3,?4) and OS_INFO_ID= ?1 ")
	public String findMinCpuUtilZation(String osInfoId,String begin,String end,String dateFormat);

}

