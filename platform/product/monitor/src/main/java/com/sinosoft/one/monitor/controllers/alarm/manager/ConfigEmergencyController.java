package com.sinosoft.one.monitor.controllers.alarm.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.action.model.MailAction;
import com.sinosoft.one.monitor.action.repository.MailActionRepository;
import com.sinosoft.one.monitor.application.domain.ApplicationService;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.attribute.domain.AttributeCache;
import com.sinosoft.one.monitor.attribute.domain.AttributeService;
import com.sinosoft.one.monitor.attribute.model.Attribute;
import com.sinosoft.one.monitor.attribute.model.AttributeAction;
import com.sinosoft.one.monitor.attribute.repository.AttributeActionRepository;
import com.sinosoft.one.monitor.attribute.repository.AttributeRepository;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.monitor.db.oracle.repository.InfoRepository;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.repository.OsRepository;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
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

import java.util.ArrayList;
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
    @Autowired
    InfoRepository infoRepository;
    @Autowired
    OsRepository osRepository;
    @Autowired
    AttributeCache attributeCache;
    @Autowired
    AttributeRepository attributeRepository;
    @Autowired
    MailActionRepository mailActionRepository;
    @Autowired
    AttributeActionRepository attributeActionRepository;

    @Get("config")
    public String configEmergencyForm(Invocation inv){
        return "setEmergency";
    }

    //配置告警页面，选择监视器类型时，得到相应类型下的所有可用的监视器
    @Post("monitornames/{resourceType}")
    public Reply getMonitorNames(@Param("resourceType") String resourceType, Invocation inv) throws Exception {
        JSONArray jsonArray = new JSONArray();
        String jsonMonitorNames="";
        if ("应用系统".equals(resourceType)) {
            List<Application> applications = applicationService.findAllApplicationNames();
            if (applications != null) {
                for (Application application : applications) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("monitorId",application.getId());
                    //获取应用中文名
                    jsonObject.put("monitorName", application.getCnName());
                    jsonArray.add(jsonObject);
                }
                jsonMonitorNames = jsonArray.toJSONString();
                return Replys.with(jsonMonitorNames);
            }
            return null;
        }else if("数据库".equals(resourceType)){
            List<Info> dbInfos= (List<Info>) infoRepository.findAll();
            if (dbInfos!=null){
                for (Info dbInfo : dbInfos) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("monitorId",dbInfo.getId());
                    //获取GE_MONITOR_ORACLE_INFO表的NAME字段值
                    jsonObject.put("monitorName", dbInfo.getName());
                    jsonArray.add(jsonObject);
                }
                jsonMonitorNames = jsonArray.toJSONString();
                return Replys.with(jsonMonitorNames);
            }
            return null;
        }else if("操作系统".equals(resourceType)){
            List<Os> oses= (List<Os>) osRepository.findAll();
            if (oses!=null){
                for (Os os : oses) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("monitorId",os.getOsInfoId());
                    //获取GE_MONITOR_OS表的NAME字段值
                    jsonObject.put("monitorName", os.getName());
                    jsonArray.add(jsonObject);
                }
                jsonMonitorNames = jsonArray.toJSONString();
                return Replys.with(jsonMonitorNames);
            }
            return null;
        }else {
            return null;
        }
    }

    @Post("attributenames/{resourceType}")
    public void getAttributeNames(@Param("resourceType") String resourceType,Invocation inv) throws Exception {
        /*String dbResourceType="";
        ResourceType[] resourceTypes=ResourceType.values();
        for (ResourceType newResourceType:resourceTypes){
            if (newResourceType.cnName().equals(resourceType)){
                dbResourceType=newResourceType.name();
                break;
            }
        }*/
        String dbResourceType=getResourceEnumString(resourceType);
        if(!"".equals(dbResourceType)){
            List<Attribute> attributes=attributeService.findAllAttributesWithResourceType(dbResourceType);
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
        Replys.with(null);
    }

    public String getResourceEnumString(String resourceName){
        String dbResourceType="";
        ResourceType[] resourceTypes=ResourceType.values();
        for (ResourceType newResourceType:resourceTypes){
            if (newResourceType.cnName().equals(resourceName)){
                dbResourceType=newResourceType.name();
                break;
            }
        }
        return dbResourceType;
    }

    //获得监视器名称，属性名称
    @Get("health/{resourceType}/{monitorId}/{attributeName}")
    public String setHealthForm(@Param("resourceType") String resourceType,@Param("monitorId") String monitorId,
                                @Param("attributeName") String attributeName,Invocation inv){
        //获得监视器名称（也就是应用中文名）
        inv.addModel("monitorName",applicationService.findApplication(monitorId).getCnName());
        //写回应用id
        inv.getRequest().setAttribute("monitorId",monitorId);
        String attributeId= attributeCache.getAttributeId(getResourceEnumString(resourceType),attributeName);
        //写回属性id
        inv.getRequest().setAttribute("attributeId",attributeId);
        //获得属性名字
        inv.addModel("attributeName",attributeRepository.findOne(attributeId).getAttributeCn());
        inv.getRequest().setAttribute("resourceType",resourceType);
        //返回配置告警--健康度页面
        return "setHealth";
    }

    //获得所有动作
    @Post("actions")
    public Reply getAllActions(Invocation inv){
        List<MailAction> mailActions= (List<MailAction>) mailActionRepository.findAll();
        if (mailActions!=null){
            JSONArray jsonArray = new JSONArray();
            String jsonActionNames="";
            for (MailAction mailAction : mailActions) {
                List<SeverityLevel> severityLevels=new ArrayList<SeverityLevel>();
                severityLevels=attributeActionRepository.findAllSeverityWithActionId(mailAction.getId());
                if(severityLevels!=null&&severityLevels.size()>0){
                    for(SeverityLevel severityLevel:severityLevels){
                        String severityLevelName=severityLevel.cnName();
                        if("严重".equals(severityLevelName)){

                        }else if("严重".equals(severityLevelName)){

                        }else if("严重".equals(severityLevelName)){

                        }
                    }
                }




                JSONObject jsonObject = new JSONObject();
                //获取动作关联属性的严重程度
                jsonObject.put("actionSeverity",mailAction.getSeverity());
                jsonObject.put("actionId",mailAction.getId());
                jsonObject.put("actionName", mailAction.getName());
                jsonArray.add(jsonObject);
            }
            jsonActionNames = jsonArray.toJSONString();
            return Replys.with(jsonActionNames);
        }
        return null;
    }

    @Post("save")
    public String saveHealthConfig(Invocation inv){

        return "setEmergency";
    }
}
