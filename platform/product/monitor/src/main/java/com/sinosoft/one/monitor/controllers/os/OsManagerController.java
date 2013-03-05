package com.sinosoft.one.monitor.controllers.os;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.os.linux.domain.OsService;
import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsAvailableViewModel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.mvc.web.instruction.reply.transport.Json;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

@Path
public class OsManagerController {
	@Autowired
	private OsService osService;

	/**
	 * 新增一个操作系统监控器.
	 */
	@Post("isIpExists")
	public Reply isIpExists(Invocation inv) {
		String ip = inv.getParameter("ipAddr");
		System.out.println(osService.checkOsByIp(ip));
		if (osService.checkOsByIp(ip)) {
			return Replys.with(true).as(Json.class);
		} else
			return Replys.with(false).as(Json.class);
	}

	@Post("addApp")
	public String saveOs(@Validation(errorPath = "saveOs") @Param("os") Os os) {
		try {
			osService.saveOsBasic(os.getName(), os.getType(), os.getIpAddr(),
					os.getSubnetMask(), 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@Get("systemMonitor")
	public String toSystemMonitor(Invocation inv) {
		//0 hong 1 zheng 2wushuju
		OsAvailableViewModel model1 = new OsAvailableViewModel();
		model1.setIndex(1);
		model1.setPercentage("33%");
		model1.setStatus("2");
		OsAvailableViewModel model2 = new OsAvailableViewModel();
		model2.setIndex(2);
		model2.setPercentage("33%");
		model2.setStatus("1");
		OsAvailableViewModel model3 = new OsAvailableViewModel();
		model3.setIndex(3);
		model3.setPercentage("34%");
		model3.setStatus("0");
		List<OsAvailableViewModel> list = new ArrayList<OsAvailableViewModel>();
		list.add(model1);
		list.add(model2);
		list.add(model3);
		Map<String, List<OsAvailableViewModel>> map = new HashMap<String, List<OsAvailableViewModel>>();
		map.put("linux1",list );
		map.put("linux2", list);
		map.put("linux3", list);
		System.out.println("mapSize"+map.size());
		
		inv.addModel("map",map);
		return "systemMonitor";
	}
}
