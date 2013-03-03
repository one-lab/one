package com.sinosoft.one.monitor.application.repository;
// Generated 2013-2-27 18:41:37 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.Url;
import com.sinosoft.one.mvc.web.annotation.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UrlRepository extends PagingAndSortingRepository<Url, String> {

    Url findByUrl(String urlAddress);

    @SQL("select * from GE_MONITOR_URL a where a.ID in (select b.url_id from GE_MONITOR_BIZ_SCENARIO_URL b right join GE_MONITOR_BIZ_SCENARIO c on b.BIZ_SCENARIO_ID=?1)")
    List<Url> selectUrlsOfBizScenarioByIds(@Param("bizScenarioId") String bizScenarioId);
}

