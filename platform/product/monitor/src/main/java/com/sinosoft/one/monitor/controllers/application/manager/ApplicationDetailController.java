package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.ApplicationDetailService;
import com.sinosoft.one.monitor.application.model.UrlResponseTime;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationDetailAlarmViewModel;
import com.sinosoft.one.monitor.application.model.viewmodel.ApplicationDetailPieViewModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 应用明细处理Controller.
 * User: carvin
 * Date: 13-3-6
 * Time: 下午8:15
 */
@Path("detail")
public class ApplicationDetailController {
	@Autowired
	private ApplicationDetailService applicationDetailService;


	@Get("/alarm/{applicationId}")
	public String alarm(@Param("applicationId") String applicationId, Invocation invocation) {
		ApplicationDetailAlarmViewModel applicationDetailAlarmViewModel = applicationDetailService.generateAlarmViewModel(applicationId);
		invocation.addModel("alarmViewModel", applicationDetailAlarmViewModel);
		return "applicationDetailAlarm";
	}

	@Get("/pie/{applicationId}")
	public String pie(@Param("applicationId") String applicationId, Invocation invocation) {
		ApplicationDetailPieViewModel applicationDetailPieViewModel = applicationDetailService.generatePieViewModel(applicationId);
		invocation.addModel("pieViewModel", applicationDetailPieViewModel);
		return "applicationDetailPie";
	}

	@Get("/urls/{applicationId}")
	public void urls(@Param("applicationId") String applicationId, HttpServletResponse response) throws  Exception{
		List<UrlResponseTime> urlResponseTimeList = applicationDetailService.queryUrlResponseTimes(applicationId);
		Page page=new PageImpl(urlResponseTimeList);
		Gridable<UrlResponseTime> gridable=new Gridable<UrlResponseTime>(page);
		String cellString = "url,minResponseTime,avgResponseTime,maxResponseTime";
		gridable.setIdField("urlId");
		gridable.setCellStringField(cellString);
		UIUtil.with(gridable).as(UIType.Json).render(response);
	}
}
