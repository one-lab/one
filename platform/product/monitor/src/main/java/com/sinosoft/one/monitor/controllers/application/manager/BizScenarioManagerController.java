package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.ApplicationService;
import com.sinosoft.one.monitor.application.domain.BizScenarioService;
import com.sinosoft.one.monitor.application.model.BizScenario;
import com.sinosoft.one.monitor.application.model.BizScenarioGrade;
import com.sinosoft.one.monitor.utils.CurrentUserUtil;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-2-28
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
@Path("bsmanager")
public class BizScenarioManagerController {

    @Autowired
    BizScenarioService bizScenarioService;
    @Autowired
    ApplicationService applicationService;

    /**
     * 管理业务场景页面.
     */
    @Get("list/{appId}")
    public String getAllApplication(@Param("appId") String appId,Invocation inv) {
        inv.getRequest().setAttribute("appId",appId);
        //管理业务场景页面
        return "managerBizScenario";
    }

    /**
     * 获得所有的业务场景(响应按下“管理业务场景”按钮时的ajax请求).
     */
    @Post({"bizscenariolist/{appId}","bizscenariolist"})
    public void getAllBizScenario(@Param("appId") String appId,Invocation inv) throws Exception {
        List<BizScenario> bizScenarioList=bizScenarioService.findUserNameAndBizScenario(applicationService.findApplication(appId).getBizScenarios());
        if(bizScenarioList!=null){
            List<BizScenario> bizScenarios=new ArrayList<BizScenario>();
            for(BizScenario bizScenario:bizScenarioList){
                bizScenario.setBizScenarioGrade(BizScenarioGrade.parseValue(bizScenario.getBizScenarioGrade()).getDisplayName());
                bizScenarios.add(bizScenario);
            }
            /*List<BizScenario> bizScenarios = bizScenarioService.findAllBizScenario();*/
            Page page=new PageImpl(bizScenarios);
            Gridable<BizScenario> gridable=new Gridable<BizScenario>(page);
            String cellString=new String("name,userName,createTime,bizScenarioGrade,operation");
            gridable.setIdField("id");
            gridable.setCellStringField(cellString);
            try {
                UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
            } catch (Exception e) {
                throw new Exception("json数据转换出错!",e);
            }
        }
    }

    /**
     * 获得当前应用下所有的业务场景.
     *//*
    @Get("bizscenariolist/{id}")
    @Post("bizscenariolist/{id}")
    public String getAllBizScenarioOfApplication(@Param("id") String id,Invocation inv) {
        List<BizScenario> bizScenarios = applicationService.findApplication(id).getBizScenarios();
        //构造gridable
        //UIUtil.
        inv.addModel("applicationId",id);
        //返回id，供新增业务场景时，用以确定属于哪个应用
        //应用列表页面
        //页面所在路径application/manager/
        return "manageBizScenario";
    }*/

    /**
     * 增加业务场景的表单页面(其中id是所属的应用的id).
     */
    @Get("createbizscenario/{appId}")
    @Post("errorcreatebizscenario")
    public String createBizScenario(@Param("appId") String appId,Invocation inv) {
        //将应用appId写回页面，保存应用时提交这个appId
        inv.getRequest().setAttribute("appId", appId);
        inv.addModel("bizScenario", new BizScenario());
        //页面所在路径application/manager/
        return "addBizScenario";
    }

    /**
     * 新增一个业务场景(其中id是所属的应用的id).
     */
    @Post("addbizscenario/{appId}")
    public String saveBizScenario(@Validation(errorPath = "a:errorcreatebizscenario") BizScenario bizScenario,
                                  @Param("appId") String appId, Invocation inv) {
        //当前业务场景所属的应用
        bizScenario.setApplication(applicationService.findApplication(appId));
        bizScenario.setBizScenarioGrade(BizScenarioGrade.parseDisplayName(bizScenario.getBizScenarioGrade()).getValue());
        bizScenario.setStatus(String.valueOf(1));
        //获得当前用户
       /* bizScenario.setCreatorId(CurrentUserUtil.getCurrentUser().getId());*/
        //开发阶段，用户Id固定值
        bizScenario.setCreatorId("4028921a3cfb99be013cfb9ccf650000");
        bizScenario.setCreateTime(new Date());
        bizScenarioService.saveBizScenario(bizScenario);
        //将应用appId写回页面，保存应用时提交这个appId
        inv.addModel("appId", appId);
        return "managerBizScenario";
    }

    /**
     * 更新业务场景的表单页面.
     */
    @Get("update/{id}")
    @Post("errorUpdateBizScenario")
    public String bizScenarioForm(@Param("id") String id, Invocation inv) {
        inv.addModel("bizScenario", bizScenarioService.findBizScenario(id));
        //页面所在路径application/manager/
        return "bizScenarioForm";
    }

    /**
     * 更新业务场景.
     */
    @Post("update/{id}")
    public String updateBizScenario(@Validation(errorPath = "a:errorUpdateBizScenario") BizScenario bizScenario, Invocation inv) {
        bizScenario.setModifierId(CurrentUserUtil.getCurrentUser().getId());
        bizScenario.setModifyTime(new Date());
        bizScenarioService.saveBizScenario(bizScenario);
        //业务场景列表页面
        //页面所在路径application/manager/
        return "a:bizScenarioList";
    }

    /**
     * 删除业务场景.
     */
    @Post("delete/{id}")
    public String deleteBizScenario(@Param("id") String id, Invocation inv) {
        bizScenarioService.deleteBizScenario(id);
        //业务场景列表页面
        //页面所在路径application/manager/
        return "a:bizScenarioList";
    }
}
