package com.sinosoft.one.monitor.controllers.application.manager;

import com.sinosoft.one.monitor.application.domain.MethodService;
import com.sinosoft.one.monitor.application.domain.UrlService;
import com.sinosoft.one.monitor.application.model.Method;
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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-2-28
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
@Path("methodmanager")
public class MethodManagerController {

    @Autowired
    MethodService methodService;
    @Autowired
    UrlService urlService;

    /**
     * 管理Method页面.
     */
    @Get("methodlist/{urlId}")
    /*@Post("methodList")*/
    public String managerMethod(@Param("urlId") String urlId,Invocation inv) {
        inv.getRequest().setAttribute("urlId",urlId);
        Url url=urlService.findUrl(urlId);
        inv.getRequest().setAttribute("urlName",url.getDescription());
        inv.getRequest().setAttribute("urlAddress",url.getUrl());
        return "managerMethod";
    }

    /**
     * 获得Url下所有的Method.
     */
    @Post("methodlist/{urlId}")
    /*@Post("methodList")*/
    public void getAllMethodsOfUrl(@Param("urlId") String urlId,Invocation inv) throws Exception {
        inv.getRequest().setAttribute("urlId",urlId);
        Url url=urlService.findUrl(urlId);
/*        inv.getRequest().setAttribute("urlName",url.getDescription());
        inv.getRequest().setAttribute("urlAddress",url.getUrl());*/
        List<Method> methods=methodService.findAllMethodsOfUrl(url);
        Page page=new PageImpl(methods);
        Gridable<Method> gridable=new Gridable<Method>(page);
        String cellString=new String("className,methodName,description,operation");
        gridable.setIdField("id");
        gridable.setCellStringField(cellString);
        try {
            UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
        } catch (Exception e) {
            throw new Exception("json数据转换出错!",e);
        }
    }

    /**
     * 增加Method的表单页面(其中id是所属的Method的id).
     */
    @Get("createmethod/{urlId}")
    @Post("errorcreatemethod")
    public String createMethod(@Param("urlId") String urlId,Invocation inv) {
        inv.getRequest().setAttribute("urlId",urlId);
        inv.addModel("method", new Method());
        //页面所在路径application/manager/
        return "addMethod";
    }

    /**
     * 新增一个Method(其中id是所属的URL的id).
     * methods是新增加的method
     * methodIds是在已有的method列表中勾选的method的id
     */
    @Post("addmethod/{urlId}")
    public String saveMethod(@Validation(errorPath = "a:errorcreatemethod") Method method,
                             @Param("urlId") String urlId, Invocation inv) {
        Url url = urlService.findUrl(urlId);
        List<Method> methods = methodService.findAllMethod();
        //获得当前用户id
        String creatorId = CurrentUserUtil.getCurrentUser().getId();
        //开发阶段固定用户id
        /*String creatorId = "4028921a3cfba342013cfba4623e0000";*/
        String methodAndClassName=findClassAndMethodName(method);
        if(methods.size()>0){
            for(Method dbMethod:methods){
                String dbMethodAndClassName=findClassAndMethodName(dbMethod);
                //如果新增加的method是库中已存在的，那么只需更新此Method所属的URL即可.
                if (dbMethodAndClassName.equals(methodAndClassName)) {
                    dbMethod.setUrl(url);
                    methodService.saveMethod(dbMethod);
                    return "r:/application/manager/methodmanager/methodlist/"+urlId;
                }
            }
        }
        //如果是新增加的method，保存method入库
        //当前Method所属的Url
        method.setUrl(url);
        method.setStatus(String.valueOf(1));
        if(StringUtils.isBlank(method.getDescription())){
            method.setDescription("-");
        }
        //保存当前创建method的用户
        method.setCreatorId(creatorId);
        method.setCreateTime(new Date());
        methodService.saveMethod(method);
        return "r:/application/manager/methodmanager/methodlist/"+urlId;
    }

    /**
     * 得到的Method的全类名.
     */
    public String findClassAndMethodName(Method method) {
        if (method != null) {
            String methodAndClassName="";
            methodAndClassName = method.getMethodName() + "." + method.getClassName();
            return methodAndClassName;
        }
        return null;
    }

    /**
     * 新增一个Method(其中id是所属的URL的id).
     * methods是新增加的method
     * methodIds是在已有的method列表中勾选的method的id
     */
    /*@Post("addmethod/{urlId}/{methodIds}")
    public String saveMethod(@Validation(errorPath = "a:errorcreatemethod") List<Method> methods,
                             @Param("methodIds") List<String> methodIds, @Param("urlId") String urlId, Invocation inv) {
        Url url = urlService.findUrl(urlId);
        //如果是新增加的method
        if (methods != null) {
            List<Method> methodList = methodService.findAllMethod();
            String creatorId = CurrentUserUtil.getCurrentUser().getId();
            List<String> classAndMethodNames = methodService.findClassAndMethodName(methodList);
            for (Method method : methods) {
                //如果新增加的method是库中已存在的，那么只需更新此Method所属的URL即可.
                if (classAndMethodNames.contains(methodService.findClassAndMethodName(method))) {
                    method.setUrl(url);
                    //methods.remove(method);
                }
                //如果是新增加的method，保存method入库
                //当前Method所属的Url
                method.setUrl(url);
                //保存当前创建method的用户
                method.setCreatorId(creatorId);
                method.setCreateTime(new Date());
                methodService.saveMethod(method);
            }
        }
        //如果是勾选的已经存在的method，只需更新method所属的Url
        // 此处需要优化，否则或许会判断所有的method是否被勾选（应该只得到被勾选的就行）
        if (methodIds != null) {
            for (String methodId : methodIds) {
                if (!StringUtils.isBlank(methodId)) {
                    methodService.findMethod(methodId).setUrl(url);
                }
            }
        }
        //页面所在路径application/manager/
        return "业务场景列表页面（或Method列表页面）";
    }
*/
    /**
     * 更新Method的表单页面.
     */
    @Get("updatemethod/{urlId}/{methodId}")
    @Post("errorupdatemethod/{methodId}")
    public String methodForm(@Param("urlId") String urlId,@Param("methodId") String methodId, Invocation inv) {
        inv.getRequest().setAttribute("urlId",urlId);
        inv.addModel("method", methodService.findMethod(methodId));
        //页面所在路径application/manager/
        return "modifyMethod";
    }

    /**
     * 更新Method.
     */
    @Post("updatemethod/{urlId}/{methodId}")
    public String updateMethod(@Validation(errorPath = "a:errorupdatemethod/{methodId}") Method method,
                               @Param("urlId") String urlId, @Param("methodId") String methodId,Invocation inv) {
        //将urlId写回，managerMethod页面发送ajax请求时会用到
        inv.getRequest().setAttribute("urlId",urlId);
        //获得当前用户
        String modifierId=CurrentUserUtil.getCurrentUser().getId();
        methodService.updateMethodWithModifyInfo(methodId,method.getClassName(),method.getMethodName(),method.getDescription(),modifierId);
        return "r:/application/manager/methodmanager/methodlist/"+urlId;
    }

    /**
     * 单个删除Method.
     */
    @Get("delete/{urlId}/{methodId}")
    public String deleteMethod(@Param("urlId") String urlId, @Param("methodId") String methodId, Invocation inv) {
        //先删除中间表GE_MONITOR_URL_METHOD的记录
        methodService.deleteUrlAndMethod(urlId,methodId);
        //删除GE_MONITOR_METHOD的记录
        methodService.deleteMethod(methodId);
        //Method列表页面
        return "r:/application/manager/methodmanager/methodlist/"+urlId;
    }

    /**
     * 批量删除Method.
     */
    @Post("batchdelete/{urlId}")
    public String batchDeleteMethod(@Param("urlId") String urlId, Invocation inv) {
        String[] methodIds=inv.getRequest().getParameterValues("methodIds[]");
        //先删除中间表GE_MONITOR_URL_METHOD的记录
        methodService.batchDeleteUrlAndMethod(urlId,methodIds);
        //删除GE_MONITOR_METHOD的记录
        methodService.batchDeleteMethod(methodIds);
        //Method列表页面
        return "r:/application/manager/methodmanager/methodlist/"+urlId;
    }
}
