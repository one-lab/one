package com.sinosoft.one.monitor.controllers.db.oracle;


import java.util.Date;

import com.sinosoft.one.monitor.resources.model.Resource;
import com.sinosoft.one.monitor.resources.repository.ResourcesRepository;
import com.sinosoft.one.mvc.web.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.db.oracle.domain.OracleInfoService;
import com.sinosoft.one.monitor.db.oracle.model.Info;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;

@Path
public class AddOracleController {

	
	@Autowired
	private OracleInfoService oracleInfoService;
	//添加监视器
	@Post("add")
	public Reply addOracleMonitor(Info info){
		Date sysTime = new Date();
		info.setSysTime(sysTime);
        System.out.println(info);
        oracleInfoService.saveMonitor(info);
		return Replys.simple().success() ;
	}
}
