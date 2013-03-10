package com.sinosoft.one.monitor.controllers;

import com.sinosoft.one.monitor.application.domain.ApplicationService;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.resources.domain.ResourcesService;
import com.sinosoft.one.monitor.resources.model.Resource;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-3-4
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
@Path("addapplication")
public class AddApplicationController {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    ResourcesService resourcesService;

    @Get("add")
    @Post("errorcreate")
    public String addApplication(Invocation inv){
        return "addSystem";
    }

    /**
     * 新增一个应用.
     */
    @Post("add")
    public String saveApplication(@Validation(errorPath = "a:errorcreate") Application application, Invocation inv) {
        //获得当前用户
        //测试时固定CreatorId
        /*application.setCreatorId(CurrentUserUtil.getCurrentUser().getId());*/
        application.setCreatorId("4028921a3cfb99be013cfb9ccf650000");
        application.setCreateTime(new Date());
        application.setStatus(String.valueOf('1'));
        applicationService.saveApplication(application);
        String resourceName=application.getCnName()+"["+application.getApplicationName()+"]";
        Resource resource=new Resource();
        resource.setResourceId(application.getId());
        resource.setResourceName(resourceName);
        resource.setResourceType(ResourceType.APPLICATION.name());
        //RESOURCES表中保存应用信息
        resourcesService.saveResource(resource);
        //页面所在路径application/manager/@应用性能页面
        return "r:application/manager/appmanager/appperformance";
    }
}
