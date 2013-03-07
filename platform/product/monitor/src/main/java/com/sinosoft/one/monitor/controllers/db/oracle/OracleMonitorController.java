package com.sinosoft.one.monitor.controllers.db.oracle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.db.oracle.domain.OracleBatchInfoService;
import com.sinosoft.one.monitor.db.oracle.model.Lastevent;
import com.sinosoft.one.monitor.db.oracle.model.StaGraphModel;
import com.sinosoft.one.mvc.web.annotation.Path;
@Path
public class OracleMonitorController {
	@Autowired
	private OracleBatchInfoService oracleBatchInfoService;
	
	public String viewConnectTimeChart(){
		//连接时间
		JSONObject jsonObj = new JSONObject();
		JSONArray monitorNames = new JSONArray();
		JSONArray xAxis = new JSONArray();
		JSONArray yAxisArry = new JSONArray();
		List<StaGraphModel> staGraphInfo = oracleBatchInfoService.listMonitorEventSta();
		for(StaGraphModel staGraphModel : staGraphInfo){
			String monitorName = staGraphModel.getName();
			monitorNames.add(monitorName);
			List<Lastevent> events = staGraphModel.getLasteventList();
			JSONArray yaliaxs = new JSONArray();
			for(Lastevent envent:events){
				xAxis.add(envent.getRecordTime());
				yaliaxs.add(envent.getConnectTime());
			}
			yAxisArry.add(yaliaxs);
		}
		jsonObj.put("names", monitorNames);
		jsonObj.put("xAxis", xAxis);
		jsonObj.put("yAxisArry", yAxisArry);
		return "@"+jsonObj.toJSONString();
	}
}
