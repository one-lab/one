package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.ApplicationService;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.application.model.BizScenario;
import com.sinosoft.one.monitor.application.model.Url;
import com.sinosoft.one.monitor.utils.CurrentUserUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-2-27
 * Time: 下午10:14
 * To change this template use File | Settings | File Templates.
 */
@Path("appmanager")
public class ApplicationManagerController {

    Log logger= LogFactory.getLog(ApplicationManagerController.class);

    @Autowired
    ApplicationService applicationService;

    /**
     * 获得所有的应用.
     */
    @Get("applist")
    @Post("applist")
    public String getAllApplication(Invocation inv) {
        List<Application> applications = applicationService.findAllApplication();
        inv.addModel("applications", applications);
        //应用性能列表页面
        return "performance";
    }

    /**
     * 增加应用的表单页面.
     */
    @Get("create")
    @Post("errorcreate")
    public String createApplication(Invocation inv) {
        inv.addModel("application", new Application());
        //页面所在路径application/manager/
        /*return "applicationForm";*/
        return "addSystem";
    }

    /**
     * 新增一个应用.
     */
    @Post("add")
    public String saveApplication(@Validation(errorPath = "a:errorCreateApp") Application application, Invocation inv) {
        //获得当前用户
        //测试时固定CreatorId
        /*application.setCreatorId(CurrentUserUtil.getCurrentUser().getId());*/
        application.setCreatorId(inv.getRequest().getSession().getId());
        application.setCreateTime(new Date());
        application.setStatus(String.valueOf('1'));
        applicationService.saveApplication(application);
        //页面所在路径application/manager/@应用性能页面
        return "a:/appperformance";
    }

    /**
     * 应用性能.
     */
    @Get("appperformance")
    @Post("appperformance")
    public String applicationPerformance(Invocation inv){
        inv.addModel("applications",applicationService.findAllApplication());
        return "performance";
    }

    /**
     * 更新应用的表单页面.
     */
    @Get("update/{id}")
    @Post("errorUpdateApp")
    public String applicationForm(@Param("id") String id, Invocation inv) {
        inv.addModel("application", applicationService.findApplication(id));
        //页面所在路径application/manager/
        return "applicationForm";
    }

    /**
     * 更新应用.
     */
    @Post("update/{id}")
    public String updateApplication(@Validation(errorPath = "a:errorUpdateApp") Application application, Invocation inv) {
        application.setModifierId(CurrentUserUtil.getCurrentUser().getId());
        application.setModifyTime(new Date());
        applicationService.saveApplication(application);
        //页面所在路径application/manager/
        return "应用性能页面(应用列表页面)的action";
    }

    /**
     * 删除应用.
     */
    @Get("delete/{id}")
    public String deleteApplication(@Param("id") String id, Invocation inv) {
        applicationService.deleteApplication(id);
        //页面所在路径application/manager/
        return "r:/application/manager/appmanager/applist";
    }

    /**
     * agent首次启动时，校验agent发送来的应用信息
     * 获得应用id，应用下的所有Url和Method，供agent匹配所监控的应用系统.
     */
    @Post("match")
    public void initMatchMap(Invocation inv){
        try {
            String appName=inv.getRequest().getParameter("appName");
            String ip=inv.getRequest().getParameter("ip");
            String port=inv.getRequest().getParameter("port");
            Application application=applicationService.findApplicationWithAppInfo(appName,ip,port);
            if(application!=null){
                    List<String> bizScenarioIds=new ArrayList<String>();
                    List<BizScenario> bizScenarios=application.getBizScenarios();
                    for(BizScenario bizScenario:bizScenarios){
                        bizScenarioIds.add(bizScenario.getId());
                    }
                    List<Url> urls=applicationService.findAllUrlsOfApplication(bizScenarioIds);
                    //URL.id,URL.url(address),URL.Method
                    //Method.id,Method.className,Method.methodName
                    String jsonString=applicationService.getJsonDataOfUrlsAndMethods(application.getId(),urls);
                    Replys.with(jsonString);
            }
            Replys.simple().fail("NotExist");
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            Replys.simple().fail("Exception");
        }
    }
}
