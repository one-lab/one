package com.sinosoft.one.monitor.application.repository;
// Generated 2013-3-4 15:45:31 by One Data Tools 1.0.0

import com.sinosoft.one.monitor.application.model.EumUrl;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EumUrlRepository extends PagingAndSortingRepository<EumUrl, String> {
    List<EumUrl> findByApplication_Id(String applicationId);

    List<EumUrl> findByUrlId(String urlId);
}

