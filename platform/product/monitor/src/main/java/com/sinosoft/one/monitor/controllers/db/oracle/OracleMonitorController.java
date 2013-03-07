package com.sinosoft.one.monitor.controllers.db.oracle;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.db.oracle.domain.OracleBatchInfoService;
import com.sinosoft.one.monitor.db.oracle.domain.StaTimeEnum;
import com.sinosoft.one.monitor.db.oracle.model.Highchart;
import com.sinosoft.one.monitor.db.oracle.model.HighchartSerie;
import com.sinosoft.one.monitor.db.oracle.model.Lastevent;
import com.sinosoft.one.monitor.db.oracle.model.OracleHealthInfoModel;
import com.sinosoft.one.monitor.db.oracle.model.StaGraphModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
@Path
public class OracleMonitorController {
	@Autowired
	private OracleBatchInfoService oracleBatchInfoService;
	
	/**
	 * 性能信息
	 * @return
	 */
	public Reply performance(){
		List<StaGraphModel> staGraphModels = oracleBatchInfoService.listMonitorEventSta();
		/* 已用的内存*/
		//Highchart memory_utilization = new Highchart("memory_utilization");
		/* 活动的远程连接数*/
		//Highchart CPU_utilization = new Highchart("CPU_utilization");
		/* 连接时间*/
		Highchart exchange_utilization = new Highchart("exchange_utilization");
		/* 活动的用户连接数*/
		Highchart reply_utilization = new Highchart("reply_utilization");
		for(StaGraphModel staGraphModel : staGraphModels) {
			HighchartSerie exchangeSerie = new HighchartSerie(staGraphModel.getName());
			HighchartSerie replySerie = new HighchartSerie(staGraphModel.getName());
			/* 判断x轴信息是否为空，如果为空填充x轴信息*/
			boolean exchangeFlag = exchange_utilization.getCategories().isEmpty();
			boolean replyFlag = reply_utilization.getCategories().isEmpty();
			for(Lastevent lastevent : staGraphModel.getLasteventList()) {
				exchangeSerie.addData(Double.valueOf(lastevent.getConnectTime()));
				replySerie.addData(Double.valueOf(lastevent.getActiveCount()));
				
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				String category = sdf.format(lastevent.getRecordTime());
				if(exchangeFlag) exchange_utilization.addCategory(category);
				if(replyFlag) reply_utilization.addCategory(category);
			}
			exchange_utilization.addSerie(exchangeSerie);
			reply_utilization.addSerie(replySerie);
		}
		return Replys.with(Arrays.asList(exchange_utilization, reply_utilization)).as(Json.class);
	}
	
	/**
	 * 健康状态列表
	 * @return
	 */
	public Reply healthList(Invocation inv) {
		List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
		List<OracleHealthInfoModel> oracleHealthInfoModels = oracleBatchInfoService.healthInfoList(StaTimeEnum.LAST_24HOUR);
		String messageFormat0 = "<a href='{0}'>{1}</a>";
		String messageFormat1 = "<span class={0}>{1}</span>";
		for(OracleHealthInfoModel oracleHealthInfoModel : oracleHealthInfoModels) {
			Map<String, Object> row = new HashMap<String, Object>();
			row.put("id", oracleHealthInfoModel.getMonitorID());
			List<String> cell = new ArrayList<String>();
			cell.add(MessageFormat.format(messageFormat0, "",oracleHealthInfoModel.getMonitorName()));
			for(int i=0; i<oracleHealthInfoModel.getGraphInfo().size(); i++) {
				String[] values = oracleHealthInfoModel.getGraphInfo().get(i);
				String cssClass = "";
				if("1".equals(values[0])) {
					cssClass = "normal";
				} else if("2".equals(values[0])) {
					cssClass = "warn";
				} else {
					cssClass = "";
				}
				String value = MessageFormat.format(messageFormat1, cssClass, values[1]);
				cell.add(value);
			}
			row.put("cell", cell);
			rows.add(row);
		}
		Map<String, Object> grid = new HashMap<String, Object>();
		grid.put("rows", rows);
		return Replys.with(grid).as(Json.class);
	}
}
