package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.ApplicationUrlService;
import com.sinosoft.one.monitor.application.model.MethodResponseTime;
import com.sinosoft.one.monitor.application.model.viewmodel.UrlTraceLogViewModel;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 应用URL Controller
 * User: carvin
 * Date: 13-3-9
 * Time: 下午11:31
 */
@Path("/url")
public class ApplicationUrlController {
	@Autowired
	private ApplicationUrlService applicationUrlService;

	@Get("/methodresponsetime/${applicationId}/${urlId}")
	public void queryMethodResponseTimes(@Param("applicationId") String applicationId, @Param("urlId") String urlId,
	                                     Invocation invocation) throws Exception {
		List<MethodResponseTime> methodResponseTimeList = applicationUrlService.queryMethodResponseTimes(applicationId, urlId);
		Page page = new PageImpl(methodResponseTimeList);
		Gridable<MethodResponseTime> gridable = new Gridable<MethodResponseTime>(page);
		String cellString = "methodName,minResponseTime,maxResponseTime,avgResponseTime";
		gridable.setIdField("id");
		gridable.setCellStringField(cellString);
		UIUtil.with(gridable).as(UIType.Json).render(invocation.getResponse());
	}

	@Get("/tracelog/${applicationId}/${urlId}")
	public void queryUrlTraceLogs(@Param("applicationId") String applicationId, @Param("urlId") String urlId,
	                                     Invocation invocation) throws Exception {
		Pageable pageable = new PageRequest(0, 10);
		Page<UrlTraceLogViewModel> urlTraceLogList = applicationUrlService.queryUrlTraceLogs(pageable, urlId);
		Gridable<UrlTraceLogViewModel> gridable = new Gridable<UrlTraceLogViewModel>(urlTraceLogList);
		String cellString = "userIp,userId,recordTime,state,operateStr";
		gridable.setIdField("id");
		gridable.setCellStringField(cellString);
		UIUtil.with(gridable).as(UIType.Json).render(invocation.getResponse());
	}
}
