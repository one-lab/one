package com.sinosoft.one.monitor.controllers.alarm.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.application.domain.ApplicationService;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.attribute.domain.AttributeService;
import com.sinosoft.one.monitor.attribute.model.Attribute;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-3-5
 * Time: 上午10:56
 * To change this template use File | Settings | File Templates.
 */
@Path("configemergency")
public class ConfigEmergencyController {
    @Autowired
    AttributeService attributeService;
    @Autowired
    ApplicationService applicationService;

    @Get("config")
    public String configEmergencyForm(Invocation inv){
        return "setEmergency";
    }

    @Post("attributenames/{resourceType}")
    public void getAttributeNames(@Param("resourceType") String resourceType,Invocation inv) throws Exception {
        List<Attribute> attributes=attributeService.findAllAttributesWithResourceType(resourceType);
        Page page=new PageImpl(attributes);
        Gridable<Attribute> gridable=new Gridable<Attribute>(page);
        gridable.setIdField("id");
        gridable.setCellStringField("attributeCn,threshold,action");
        try {
            UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
        } catch (Exception e) {
            throw new Exception("Json数据转换出错!",e);
        }
    }

    @Post("monitornames/{resourceType}")
    public Reply getMonitorNames(@Param("resourceType") String resourceType, Invocation inv) throws Exception {
        List<Application> applications = applicationService.findAllApplicationNames();
        JSONArray jsonArray = new JSONArray();
        if (applications != null) {
            for (Application application : applications) {
                JSONObject jsonObject = new JSONObject();
                //应用英文名
                jsonObject.put("monitorName", application.getApplicationName());
                jsonArray.add(jsonObject);
            }
            String jsonMonitorNames = jsonArray.toJSONString();
            System.out.println("============================================================\n" + jsonMonitorNames);
            return Replys.with(jsonMonitorNames);
        }
        return null;
    }
}
