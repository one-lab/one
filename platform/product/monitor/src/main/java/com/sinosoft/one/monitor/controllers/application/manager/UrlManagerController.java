package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.BizScenarioService;
import com.sinosoft.one.monitor.application.domain.UrlService;
import com.sinosoft.one.monitor.application.model.BizScenario;
import com.sinosoft.one.monitor.application.model.Url;
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

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-2-28
 * Time: 下午3:26
 * To change this template use File | Settings | File Templates.
 */
@Path("urlmanager")
public class UrlManagerController {

    @Autowired
    UrlService urlService;
    @Autowired
    BizScenarioService bizScenarioService;

    /**
     * 管理url页面.
     */
    @Get("urllist/{bizScenarioId}")
    public String managerUrl(@Param("bizScenarioId") String bizScenarioId,Invocation inv) {
        inv.getRequest().setAttribute("bizScenarioId",bizScenarioId);
        inv.getRequest().setAttribute("bizScenarioName",bizScenarioService.findBizScenario(bizScenarioId).getName());
        //页面所在路径application/manager/
        return "managerUrl";
    }

    /**
     * 响应管理url页面发送的ajax请求.
     */
    @Post("urllist/{bizScenarioId}")
    public void getAllUrlOfBizScenario(@Param("bizScenarioId") String bizScenarioId,Invocation inv) throws Exception {
        BizScenario bizScenario=bizScenarioService.findBizScenario(bizScenarioId);
        inv.getRequest().setAttribute("bizScenarioId",bizScenarioId);
        inv.getRequest().setAttribute("bizScenarioName",bizScenario.getName());
        List<Url> urls=urlService.findAllUrlsOfBizScenario(bizScenario);
        Page page=new PageImpl(urls);
        Gridable<BizScenario> gridable=new Gridable<BizScenario>(page);
        String cellString=new String("url,description,status,threshold,operation");
        gridable.setIdField("id");
        gridable.setCellStringField(cellString);
        try {
            UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
        } catch (Exception e) {
            throw new Exception("json数据转换出错!",e);
        }
    }

    /**
     * 增加Url的表单页面(其中id是所属的业务场景的id).
     */
    @Get("createurl/{bizScenarioId}")
    @Post("errorcreateurl")
    public String createUrl(@Param("bizScenarioId") String bizScenarioId,Invocation inv) {
        inv.getRequest().setAttribute("bizScenarioId",bizScenarioId);
        inv.addModel("url", new Url());
        //页面所在路径application/manager/
        return "addUrl";
    }

    /**
     * 新增一个URL(其中id是所属的业务场景的id).
     */
    @Post("addurl/{bizScenarioId}")
    public String saveUrl(@Validation(errorPath = "a:errorcreateurl") Url url,
                          @Param("bizScenarioId") String bizScenarioId, Invocation inv) {
        inv.getRequest().setAttribute("bizScenarioId",bizScenarioId);
        BizScenario bizScenario = bizScenarioService.findBizScenario(bizScenarioId);
        List<Url> urlList = urlService.findAllUrl();
        List<String> urlAddresses = urlService.findAllUrlAddresses(urlList);
        //获得当前用户id
        /*String creatorId = CurrentUserUtil.getCurrentUser().getId();*/
        //如果新增加的url是库中已经存在的，那么只需更新此url所属的业务场景即可
        if (urlAddresses.contains(url.getUrl())) {
            url.setBizScenario(bizScenario);
            return "managerUrl";
        }
        //如果新增加的url是库中没有的，那么入库
        //当前Url所属的业务场景
        url.setBizScenario(bizScenario);
        url.setStatus(String.valueOf(1));
        //保存当前创建url的用户
        //开发阶段固定用户id
        url.setCreatorId("4028921a3cfba342013cfba4623e0000");
        url.setCreateTime(new Date());
        urlService.saveUrl(url);
        return "managerUrl";
    }

    /**
     * 新增一个URL(其中id是所属的业务场景的id).
     */
    //@todo 一次添加多个url，留待将来扩展
    /*@Post({"addurl/{bizScenarioId}","addUrl/{bizScenarioId}/{urlIds}"})
    public String saveUrl(@Validation(errorPath = "a:errorcreateurl") List<Url> urls,
                          @Param("urlIds") List<String> urlIds, @Param("bizScenarioId") String bizScenarioId, Invocation inv) {
        BizScenario bizScenario = bizScenarioService.findBizScenario(bizScenarioId);
        //如果是新增加的url
        if (urls != null) {
            List<Url> urlList = urlService.findAllUrl();
            List<String> urlAddresses = urlService.findAllUrlAddresses(urlList);
            //获得当前用户id
            *//*String creatorId = CurrentUserUtil.getCurrentUser().getId();*//*
            //开发阶段固定用户id
            String creatorId = "4028921a3cfba342013cfba4623e0000";
            for (Url url : urls) {
                //如果新增加的url是库中已经存在的，那么只需更新此url所属的业务场景即可
                if (urlAddresses.contains(url.getUrl())) {
                    url.setBizScenario(bizScenario);
                }
                //如果新增加的url是库中没有的，那么入库
                //当前Url所属的业务场景
                url.setBizScenario(bizScenario);
                //保存当前创建url的用户
                url.setCreatorId(creatorId);
                url.setCreateTime(new Date());
                urlService.saveUrl(url);
            }
        }
        //如果勾选的已经存在的url，只需更新url所属的业务场景
        //@todo 此处需要优化，否则或许会判断所有的url是否被勾选（应该只得到被勾选的就行）
        if (urlIds != null) {
            for (String urlId : urlIds) {
                if (!StringUtils.isBlank(urlId)) {
                    urlService.findUrl(urlId).setBizScenario(bizScenario);
                }
            }
        }
        //页面所在路径application/manager/
        return "@新增Method页面（或URL列表页面）";
    }*/

    /**
     * 更新URL的表单页面.
     */
    @Get("updateform/{bizScenarioId}/{urlId}")
    @Post("errorUpdateUrl")
    public String urlForm(@Param("bizScenarioId") String bizScenarioId,@Param("urlId") String urlId, Invocation inv) {
        inv.setAttribute("bizScenarioId",bizScenarioId);
        inv.addModel("url", urlService.findUrl(urlId));
        return "modifyUrl";
    }

    /**
     * 更新URL.
     */
    @Post("update/{bizScenarioId}/{urlId}")
    public String updateUrl(@Validation(errorPath = "a:errorUpdateUrl") Url url, @Param("bizScenarioId") String bizScenarioId,
                            @Param("urlId") String urlId, Invocation inv) {
        /*url.setModifierId(CurrentUserUtil.getCurrentUser().getId());*/
        //开发阶段固定用户id
        String modifierId="4028921a3cfb99be013cfb9ccf650000";
        urlService.updateUrlWithModifyInfo(urlId,url.getUrl(),url.getDescription(),modifierId);
        //Url列表页面
        return "managerUrl";
    }

    /**
     * 删除url.
     */
    @Get("delete/{bizScenarioId}/{urlId}")
    public String deleteUrl(@Param("bizScenarioId") String bizScenarioId,@Param("urlId") String urlId, Invocation inv) {
        //写回bizScenarioId，返回url列表页面时用到
        inv.getRequest().setAttribute("bizScenarioId",bizScenarioId);
        //先删除中间表GE_MONITOR_BIZ_SCENARIO_URL的记录
        urlService.deleteBizScenarioAndUrl(bizScenarioId,urlId);
        //先删除中间表GE_MONITOR_URL_METHOD的记录
        urlService.deleteUrlAndMethod(urlId);
        //删除GE_MONITOR_URL的记录
        urlService.deleteUrl(urlId);
        //url列表页面
        return "managerUrl";
    }

    /**
     * 批量删除url.
     */
    @Post("batchdelete/{bizScenarioId}")
    public String batchDeleteUrl(@Param("bizScenarioId") String bizScenarioId, Invocation inv) {
        //写回bizScenarioId，返回url列表页面时用到
        inv.getRequest().setAttribute("bizScenarioId",bizScenarioId);
        String[] urlIds=inv.getRequest().getParameterValues("urlIds[]");
        //先删除中间表GE_MONITOR_BIZ_SCENARIO_URL的记录
        urlService.batchDeleteBizScenarioAndUrl(bizScenarioId,urlIds);
        //先删除中间表GE_MONITOR_URL_METHOD的记录
        urlService.batchDeleteUrlAndMethod(urlIds);
        //删除GE_MONITOR_URL的记录
        urlService.batchDeleteUrl(urlIds);
        //url列表页面
        return "managerUrl";
    }
}
