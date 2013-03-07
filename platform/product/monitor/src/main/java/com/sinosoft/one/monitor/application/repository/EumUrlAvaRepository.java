package com.sinosoft.one.monitor.application.repository;
// Generated 2013-3-4 15:45:31 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.EumUrl;
import com.sinosoft.one.monitor.application.model.EumUrlAva;
import com.sinosoft.one.monitor.utils.AvailableCalculate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EumUrlAvaRepository extends PagingAndSortingRepository<EumUrlAva, String> {

     public Page<EumUrlAva> findByEumUrl_Id(String eumUrlId,Pageable pageable);

     public List<EumUrlAva> findByEumUrl_IdAndState(String eumUrlId,String state);

     @SQL("select count(*),interval from GE_MONITOR_EUM_URL_AVA where eum_url_id=?1 and state =?2 GROUP BY INTERVAL")
     public List<AvailableCalculate.AvailableDetail> countsGroupByInterval(String eumUrlId,String state);
}

