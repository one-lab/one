package com.sinosoft.one.rmsdemo.controllers.account;

import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.rmsdemo.model.LoadTask;
import com.sinosoft.one.rmsdemo.service.LoginManager;
import com.sinosoft.one.rmsdemo.service.loadTask.LoadTaskManager;
import com.sinosoft.one.rmsdemo.uiUtils.UIUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: seline
 * Date: 12-9-20
 * Time: 下午4:46
 * To change this template use File | Settings | File Templates.
 */
@Path("user")
public class UserController {
    @Autowired
    LoginManager loginManager;
    @Autowired
    LoadTaskManager loadTaskManager;
    @Get("list")
    public String UserIndex(Invocation invocation){
        invocation.addModel("userIndex",loginManager.findByLoginName("admin"));
        return "index";
    }

    @Post("save")
    public String addLoadTask(LoadTask loadTask, Invocation invocation){
        loadTaskManager.addLoadTask(loadTask);
        String ctx = invocation.getRequest().getContextPath();
        return "r:/loadTask";
    }
    @Get
    public String listLoadTask(Invocation invocation){
        invocation.addModel("loadTask",loadTaskManager.findAllLoadTask());
        return "loadTask";
    }
    @Get
    public String listFunctionList(Invocation invocation){

        invocation.addModel("functionList",loadTaskManager.findAllFunctionList());
        return "loadTask";
    }
    @Get("treeNodes")
        public Reply getTreeNodes(){
       return Replys.with(loadTaskManager.getAllTreeNodeList()).as(Json.class);
    //    return "@"+UIUtil.convertTreeNodeList2TreeString(loadTaskManager.getAllTreeNodeList());
    }

}
