package com.sinosoft.one.monitor.controllers.notification;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.model.Response;
import com.sinosoft.one.monitor.service.ResponseService;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;

@Path("responseConfigure")
public class ResponseController {
	@Autowired
	ResponseService responseService;
	
	@Get("url")
	@Post("url")
	public Reply getAllResponses(@Param("appName") String appName) {
		List<Response> list=responseService.findAllUrls(appName);
		return Replys.with(list).as(Json.class);
	}
	
	@Get("list")
	public String getResponseList(@Param("appName")String appName,Invocation inv){
		List<Response> list=responseService.findAllUrls();
		inv.addModel("response", list);
		return "urllist";
	}
	@Get("delete/{id}")
	public String deleteResponse(@Param("id") String id){
		responseService.deleteReponse(id);
		return "r:/notification/urlConfigure/list";
		
	}
	@Post("save")
	public String saveUrl(Response response){
		response.setStatus("1");
		response.setStartDate(new Date());
		response.setEndDate(new Date());
		responseService.save(response);
		return "r:/notification/urlConfigure/list";
	}
}
