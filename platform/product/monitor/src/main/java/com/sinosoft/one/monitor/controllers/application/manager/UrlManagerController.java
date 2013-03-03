package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.BizScenarioService;
import com.sinosoft.one.monitor.application.domain.UrlService;
import com.sinosoft.one.monitor.application.model.BizScenario;
import com.sinosoft.one.monitor.application.model.Url;
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
    @Get("update/{id}")
    @Post("errorUpdateUrl")
    public String urlForm(@Param("id") String id, Invocation inv) {
        inv.addModel("url", urlService.findUrl(id));
        //页面所在路径application/manager/
        return "urlForm";
    }

    /**
     * 更新URL.
     */
    @Post("update/{id}")
    public String updateUrl(@Validation(errorPath = "a:errorUpdateUrl") Url url, Invocation inv) {
        url.setModifierId(CurrentUserUtil.getCurrentUser().getId());
        url.setModifyTime(new Date());
        urlService.saveUrl(url);
        //Url列表页面
        //页面所在路径application/manager/
        return "a:urlList";
    }

    /**
     * 删除业务场景.
     */
    @Post("delete/{id}")
    public String deleteUrl(@Param("id") String id, Invocation inv) {
        urlService.deleteUrl(id);
        //业务场景列表页面
        //页面所在路径application/manager/
        return "a:urlList";
    }
}
