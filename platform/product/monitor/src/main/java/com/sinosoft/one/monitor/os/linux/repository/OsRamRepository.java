package com.sinosoft.one.monitor.os.linux.repository;
// Generated 2013-2-27 21:43:52 by One Data Tools 1.0.0

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.os.linux.model.OsRam;

public interface OsRamRepository extends PagingAndSortingRepository<OsRam, String> {

	//根据时间
	@Query("from OsRam o where o.sampleDate between to_date(?2,?4) and to_date(?3,?4) and o.os.osInfoId= ?1 ORDER by o.sampleDate")
	public List<OsRam> findOsRamByDate(String osid,String beginTime,String endTime,String dateFormat);
	
	//物理内存利用率最大值
	@SQL("select MAX(mem_utili_zation) from GE_MONITOR_OS_RAM where SAMPLE_DATE between to_date(?2,?4) and to_date(?3,?4) and OS_INFO_ID= ?1 ")
	public String findMaxMemUtilZation(String osInfoId,String begin,String end,String dateFormat);
	
	//物理内存内存利用率最小值
	@SQL("select MIN(mem_utili_zation) from GE_MONITOR_OS_RAM where SAMPLE_DATE between to_date(?2,?4) and to_date(?3,?4) and OS_INFO_ID= ?1 ")
	public String findMinMemUtilZation(String osInfoId,String begin,String end,String dateFormat);

	//交换内存利用率最大值
	@SQL("select MAX(SWAP_UTILI_ZATION) from GE_MONITOR_OS_RAM where SAMPLE_DATE between to_date(?2,?4) and to_date(?3,?4) and OS_INFO_ID= ?1 ")
	public String findMaxSwapUtilZation(String osInfoId,String begin,String end,String dateFormat);
	
	//交换内存内存利用率最小值
	@SQL("select MIN(SWAP_UTILI_ZATION) from GE_MONITOR_OS_RAM where SAMPLE_DATE between to_date(?2,?4) and to_date(?3,?4) and OS_INFO_ID= ?1 ")
	public String findMinSwapUtilZation(String osInfoId,String begin,String end,String dateFormat);

	
}

