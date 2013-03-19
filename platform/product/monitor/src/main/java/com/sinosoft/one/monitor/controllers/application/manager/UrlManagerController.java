package com.sinosoft.one.monitor.controllers.application.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sinosoft.one.monitor.application.domain.BizScenarioService;
import com.sinosoft.one.monitor.application.domain.BusinessEmulation;
import com.sinosoft.one.monitor.application.domain.UrlService;
import com.sinosoft.one.monitor.application.model.Application;
import com.sinosoft.one.monitor.application.model.BizScenario;
import com.sinosoft.one.monitor.application.model.EumUrl;
import com.sinosoft.one.monitor.application.model.Url;
import com.sinosoft.one.monitor.application.repository.EumUrlRepository;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.resources.domain.ResourcesService;
import com.sinosoft.one.monitor.resources.model.Resource;
import com.sinosoft.one.monitor.resources.repository.ResourcesRepository;
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

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * URL的增删改查Controller.
 * User: zfb
 * Date: 13-2-28
 * Time: 下午3:26
 */
@Path("urlmanager")
public class UrlManagerController {

    @Autowired
    UrlService urlService;
    @Autowired
    BizScenarioService bizScenarioService;
    @Autowired
    ResourcesService resourcesService;
    @Autowired
    EumUrlRepository eumUrlRepository;
    @Autowired
    BusinessEmulation businessEmulation;
    @Autowired
    ResourcesRepository resourcesRepository;

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
        /*inv.getRequest().setAttribute("bizScenarioName",bizScenario.getName());*/
        List<Url> urls=urlService.findAllUrlsOfBizScenario(bizScenario);
        Page page=new PageImpl(urls);
        Gridable<BizScenario> gridable=new Gridable<BizScenario>(page);
        /*String cellString=new String("url,description,status,threshold,operation");*/
        String cellString=new String("url,description,operation");
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
                          @Param("bizScenarioId") String bizScenarioId, Invocation inv) throws IOException {
        BizScenario bizScenario = bizScenarioService.findBizScenario(bizScenarioId);
        List<Url> urls=urlService.findAllUrl();

        if(urls.size()>0){
            for(Url dbUrl:urls){
                //如果新增加的url是库中已经存在的，那么只需更新此url所属的业务场景即可
                if (dbUrl.getUrl().equals(url.getUrl())) {
                    dbUrl.setBizScenario(bizScenario);
                    //已经关联的中间表，不用再保存URL
                    /*urlService.saveUrl(dbUrl);*/
                    //向EUM_URL表中插入记录（url的application信息）
                    /*eumUrl.setUrlId(dbUrl.getId());
                    eumUrl.setRecordTime(new Date());
                    eumUrlRepository.save(eumUrl);*/
                    //资源表中已经有当前的URL，那么不需要再保存
                    urlService.saveUrl(dbUrl);
                    /*if(null!=resourcesService.getResource(dbUrl.getId())){
                        businessEmulation.restart(bizScenario.getApplication().getId());
                        return "r:/application/manager/urlmanager/urllist/"+bizScenarioId;
                    }
                    saveResourceWithUrl(dbUrl);
                    businessEmulation.restart(bizScenario.getApplication().getId());*/
                    return "r:/application/manager/urlmanager/urllist/"+bizScenarioId;
                }
            }
        }
        urlService.saveUrlWithTransactional(url,bizScenario);
        /*EumUrl eumUrl=new EumUrl();
        eumUrl.setUrl(url.getUrl());
        eumUrl.setApplication(bizScenario.getApplication());
        //获得当前用户id
        *//*String creatorId = CurrentUserUtil.getCurrentUser().getId();*//*
        //如果新增加的url是库中没有的，那么入库
        //当前Url所属的业务场景
        url.setBizScenario(bizScenario);
        url.setStatus(String.valueOf(1));
        //保存当前创建url的用户
        url.setCreatorId(CurrentUserUtil.getCurrentUser().getId());
        //开发阶段固定用户id
        *//*url.setCreatorId("4028921a3cfba342013cfba4623e0000");*//*
        url.setCreateTime(new Date());
        urlService.saveUrl(url);
        //向EUM_URL表中插入记录（url的application信息）
        eumUrl.setUrlId(url.getId());
        eumUrl.setRecordTime(new Date());
        eumUrlRepository.save(eumUrl);
        saveResourceWithUrl(url);*/
        Application application =bizScenario.getApplication();
        String monitorAddress=application.getApplicationIp()+":"+application.getApplicationPort()+"/"+application.getApplicationName();
        List<String> addUrlArgs=new ArrayList<String>();
        addUrlArgs.add(url.getId());
        addUrlArgs.add(url.getUrl());
        try {
            httpUrlConnectionOfUpdateUrl(monitorAddress, "addLogUrl", addUrlArgs);
        } catch (IOException e) {
            throw new IOException("发送http请求失败！");
        }
        businessEmulation.restart(bizScenario.getApplication().getId());
        return "r:/application/manager/urlmanager/urllist/"+bizScenarioId;
    }

    private void saveResourceWithUrl(Url url){
        //资源表存入新建业务场景的信息
        Resource resource=new Resource();
        resource.setResourceId(url.getId());
        resource.setResourceName(url.getDescription());
        resource.setResourceType(ResourceType.APPLICATION_SCENARIO_URL.name());
        resourcesService.saveResource(resource);
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
        // 此处需要优化，否则或许会判断所有的url是否被勾选（应该只得到被勾选的就行）
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
    @Post("errorupdateurl")
    public String urlForm(@Param("bizScenarioId") String bizScenarioId,@Param("urlId") String urlId, Invocation inv) {
        inv.setAttribute("bizScenarioId",bizScenarioId);
        inv.addModel("url", urlService.findUrl(urlId));
        return "modifyUrl";
    }

    /**
     * 更新URL.
     */
    @Post("update/{bizScenarioId}/{urlId}")
    public String updateUrl(@Validation(errorPath = "a:errorupdateurl") Url url, @Param("bizScenarioId") String bizScenarioId,
                            @Param("urlId") String urlId, Invocation inv) {
        String modifierId=CurrentUserUtil.getCurrentUser().getId();
        urlService.updateUrlWithModifyInfo(urlId,url.getUrl(),url.getDescription(),modifierId);
        //更新GE_MONITOR_EUM_URL表中的URL地址
        eumUrlRepository.updateEumUrlsWithUrlId(url.getUrl(),urlId);
        businessEmulation.restart(bizScenarioService.findBizScenario(bizScenarioId).getApplication().getId());
        //Url列表页面
        return "r:/application/manager/urlmanager/urllist/"+bizScenarioId;
    }

    /**
     * 删除url.
     */
    @Get("delete/{bizScenarioId}/{urlId}")
    public String deleteUrl(@Param("bizScenarioId") String bizScenarioId,@Param("urlId") String urlId, Invocation inv) {
	    urlService.deleteUrl(bizScenarioId, urlId);
        businessEmulation.restart(bizScenarioService.findBizScenario(bizScenarioId).getApplication().getId());
        //url列表页面
        return "r:/application/manager/urlmanager/urllist/"+bizScenarioId;
    }

    /**
     * 批量删除url.
     */
    @Post("batchdelete/{bizScenarioId}")
    public String batchDeleteUrl(@Param("bizScenarioId") String bizScenarioId, Invocation inv) {
        //写回bizScenarioId，返回url列表页面时用到
        String[] urlIds=inv.getRequest().getParameterValues("urlIds[]");
        for(int i=0;i<urlIds.length;i++){
            urlService.deleteUrl(bizScenarioId,urlIds[i]);
        }
        /*//先删除中间表GE_MONITOR_BIZ_SCENARIO_URL的记录
        urlService.batchDeleteBizScenarioAndUrl(bizScenarioId, urlIds);
        //先删除中间表GE_MONITOR_URL_METHOD的记录
        urlService.batchDeleteUrlAndMethod(urlIds);
        //删除GE_MONITOR_URL的记录
        urlService.batchDeleteUrl(urlIds);
        //删除Resource表中的记录
        List<Resource> dbResources=resourcesRepository.findAllResourcesWithUrlIds(urlIds);
        resourcesRepository.delete(dbResources);
        *//*for(Resource resource:dbResources){
            resourcesRepository.delete(resource);
        }*//*
        //删除EumUrl表中的记录
        List<EumUrl> dbEumUrls=eumUrlRepository.findAllEumUrlsWithUrlIds(urlIds);
        eumUrlRepository.delete(dbEumUrls);*/
        /*for(EumUrl eumUrl:dbEumUrls){
            eumUrlRepository.delete(eumUrl);
        }*/
        businessEmulation.restart(bizScenarioService.findBizScenario(bizScenarioId).getApplication().getId());
        //url列表页面
        return "r:/application/manager/urlmanager/urllist/"+bizScenarioId;
    }

    /**
     * 更新或刪除URL時，发送的http请求.
     */
    private void httpUrlConnectionOfUpdateUrl(String monitorAddress,String operation,List<String> arguments) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        BufferedReader bufferedReader = null;
        try {
            String requestUrl = "http://" + monitorAddress + "/jolokia/";
            URL postUrl = new URL(requestUrl);
            URLConnection urlConnection = postUrl.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            /*httpURLConnection.setRequestProperty("Content-Type", "application/json");*/
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputStream);
            //http正文begin
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("mbean", "log:name=LogConfigs");
            //addLogUrl或者removeLogUrl,addLogMethod或者removeLogMethod
            jsonObject.put("operation", operation);
            jsonObject.put("arguments", arguments);
            jsonObject.put("type", "exec");
            //http正文end
            objectOutputStream.write(jsonObject.toJSONString().getBytes());
            objectOutputStream.flush();
            objectOutputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String jsonString = "";
            String nextJsonString = null;
            while ((nextJsonString = bufferedReader.readLine()) != null) {
                jsonString = jsonString + nextJsonString;
            }
            System.out.println("===================================================================");
            System.out.println("返回的JSON字符串" + jsonString);
        } catch (IOException e) {
            throw new IOException("发送http请求失败！");
        } finally {
            if (null != objectOutputStream) {
                objectOutputStream.close();
            }
            if (null != bufferedReader) {
                bufferedReader.close();
            }
        }
    }
}
