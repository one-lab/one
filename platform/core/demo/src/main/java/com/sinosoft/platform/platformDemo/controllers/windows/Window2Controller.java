package com.sinosoft.platform.platformDemo.controllers.windows;

import java.util.ArrayList;
import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Window;

@Path("win2")
public class Window2Controller {
	
	private int count;
	@Get("m2")
	public String m2(Invocation inv, Window window){
		 List<String> list = new ArrayList<String>();            
		 list.add("吃饭");            
		 list.add("睡觉");            
		 list.add(String.valueOf(count++));            
		 inv.addModel("todolist", list);
		return "todo";//"@  yes! </br>  是的！";
	}

}
