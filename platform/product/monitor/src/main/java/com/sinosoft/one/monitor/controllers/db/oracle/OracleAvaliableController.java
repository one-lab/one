package com.sinosoft.one.monitor.controllers.db.oracle;

import com.sinosoft.one.monitor.db.oracle.domain.OracleBatchInfoService;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.model.OracleAvaInfoModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Path
public class OracleAvaliableController {

    @Autowired
    OracleBatchInfoService oracleBatchInfoService;

    @Get("viewOracleAvaInfo")
    public String listAvaInfo (Invocation inv){
        List<OracleAvaInfoModel> oracleAvaInfoModelList = oracleBatchInfoService.avaInfoList(StaTimeEnum.LAST_24HOUR);
        inv.getRequest().setAttribute("oaiml",oracleAvaInfoModelList);
        return "oracleMonitor";
    }
}
