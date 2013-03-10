package com.sinosoft.one.monitor.controllers.db.oracle;

import com.sinosoft.one.monitor.db.oracle.domain.OracleBatchInfoService;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.model.OracleAvaInfoModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
@Path
public class OracleAvaliableController {

    @Autowired
    OracleBatchInfoService oracleBatchInfoService;

    @Get("viewOracleAvaInfo")
    public String listAvaInfo (Invocation inv){
        List<OracleAvaInfoModel> oracleAvaInfoModelList = oracleBatchInfoService.avaInfoList(StaTimeEnum.LAST_24HOUR);
        inv.getRequest().setAttribute("oaiml",oracleAvaInfoModelList);
        BigDecimal sum = BigDecimal.ZERO;
        for(String[] strs : oracleAvaInfoModelList.get(0).getGraphInfo()) {
        	sum = sum.add(new BigDecimal(strs[2]));
        }
        System.out.println(sum);
        return "oracleMonitor";
    }
}
