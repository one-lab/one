package com.sinosoft.one.monitor.application.repository;
// Generated 2013-3-4 15:45:31 by One Data Tools 1.0.0

import com.sinosoft.one.monitor.application.model.EumUrl;
import com.sinosoft.one.monitor.application.model.EumUrlAvaSta;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;
import java.util.List;


public interface EumUrlAvaStaRepository extends PagingAndSortingRepository<EumUrlAvaSta, String> {

    List<EumUrlAvaSta> findByRecordtimeAndEumUrl(Date Date,EumUrl eumUrl);
}

