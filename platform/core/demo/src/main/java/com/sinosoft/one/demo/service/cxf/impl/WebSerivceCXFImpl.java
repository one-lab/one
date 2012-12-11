package com.sinosoft.one.demo.service.cxf.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sinosoft.one.demo.model.SimpleModel;
import com.sinosoft.one.demo.service.cxf.WebServiceCXF;

public class WebSerivceCXFImpl implements WebServiceCXF {

	public String helloWorld(String name) {
		return "HelloWorld,I'm "+name;
	}

	public SimpleModel findUser(SimpleModel user) {
		SimpleModel simpleModel=new SimpleModel();
		simpleModel.setName("张老三");
		simpleModel.setSex(true);
		simpleModel.setBirth(new Date());
		return simpleModel;
	}
	
	public List<SimpleModel> findUsers() {
		SimpleModel simpleModel=new SimpleModel();
		simpleModel.setName("大李子");
		simpleModel.setSex(true);
		simpleModel.setBirth(new Date());
		
		SimpleModel simpleModel2=new SimpleModel();
		simpleModel2.setName("王小五");
		simpleModel2.setSex(false);
		simpleModel2.setBirth(new Date());
		List<SimpleModel> list=new ArrayList<SimpleModel>();
		list.add(simpleModel);
		list.add(simpleModel2);
		return list;
	}

}
