package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.LogDetailService;
import com.sinosoft.one.monitor.application.model.LogDetail;
import com.sinosoft.one.monitor.application.model.MethodTraceLog;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Intro:
 * User: Kylin
 * Date: 13-3-9
 * Time: 上午11:41
 * To change this template use File | Settings | File Templates.
 */
@Path("appmethod")
public class ApplicationMethodController {

    @Autowired
    LogDetailService logDetailService;

    @Get("ViewLogDetail")
    public String ViewLogDetail(Invocation inv){
        return "logDetail";
    }

    @Get("getLogDetail/{logId}")
    public Reply getLogDetail(@Param("logId") String logId, Invocation inv){
        List<LogDetail> logDetails = logDetailService.getLogDetail(logId);
        if(logDetails != null){
            return Replys.with(logDetails).as(Json.class);
        }
        return Replys.simple().fail();
    }

    @Get("getParamDetail/{logId}")
    public String getParamDetail(@Param("logId") String logId, Invocation inv){
        String ParamData = logDetailService.getParamDetail(logId);
        return "@"+ ParamData;
    }

    @Get("getExceptionInfo/{logId}")
    public String getExceptionInfo(@Param("logId") String logId, Invocation inv){
        String exceptionInfo = logDetailService.getExceptionInfo(logId);
        return "@" + exceptionInfo;
    }

    @Get("getMethodDetail/{methodId}")
    public String getMethodDetail(@Param("methodId") String methodId, Invocation inv){
        MethodTraceLog methodTraceLog = logDetailService.getMethodDetail(methodId);
        String inParam = methodTraceLog.getInParam();
        String outParam = methodTraceLog.getOutParam();
        if("[]".equals(inParam)){
            inv.addModel("inParam" , "无");
        } else {
            inv.addModel("inParam" , inParam);
        }

        if("[]".equals(outParam)){
            inv.addModel("outParam" , "无");
        } else {
            inv.addModel("outParam" , outParam);
        }

        return "methodDetail";
    }
}
