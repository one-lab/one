package com.sinosoft.one.monitor.application.repository;
// Generated 2013-2-27 18:41:37 by One Data Tools 1.0.0

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.monitor.application.model.BizScenario;
import com.sinosoft.one.mvc.web.annotation.Param;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BizScenarioRepository extends PagingAndSortingRepository<BizScenario, String> {

    BizScenario findByName(String name);

    @SQL("select a.*,b.NAME as userName from GE_MONITOR_BIZ_SCENARIO a left join GE_MONITOR_ACCOUNT b on a.CREATOR_ID=b.id where a.ID in (?1)")
    List<BizScenario> selectUserNameOfBizScenarioByIds(@Param("bizScenarioIds") List<String> bizScenarioIds);
}

