package com.sinosoft.one.monitor.application.repository;
// Generated 2013-2-27 18:41:37 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.application.model.Method;
import com.sinosoft.one.monitor.application.model.Url;
import com.sinosoft.one.mvc.web.annotation.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ApplicationRepository extends PagingAndSortingRepository<Application, String> {

    Application findByApplicationName(String applicationName);

    Application findByApplicationNameAndApplicationIpAndApplicationPort(@Param("applicationName") String applicationName, @Param("applicationIp") String applicationIp, @Param("applicationPort") String applicationPort);

    @SQL("select * from GE_MONITOR_URL a where a.id in (select distinct b.URL_ID from GE_MONITOR_BIZ_SCENARIO_URL b " +
            "right join GE_MONITOR_BIZ_SCENARIO c on b.BIZ_SCENARIO_ID=:bizScenarioIds)")
    List<Url> selectAllUrlsWithBizScenarioIds(@Param("bizScenarioIds") List<String> bizScenarioIds);

    @SQL("select * from GE_MONITOR_METHOD a where a.id in (select b.METHOD_ID from GE_MONITOR_URL_METHOD b " +
            "right join GE_MONITOR_URL c on b.URL_ID=:urlId)")
    List<Method> selectAllMethodsWithUrlId(@Param("urlId") String urlId);
}

