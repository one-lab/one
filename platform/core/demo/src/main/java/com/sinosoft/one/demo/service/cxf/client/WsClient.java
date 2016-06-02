package com.sinosoft.one.demo.service.cxf.client;

import java.text.SimpleDateFormat;
import java.util.List;

//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.sinosoft.one.demo.model.SimpleModel;
import com.sinosoft.one.demo.service.cxf.WebServiceCXF;

public class WsClient {

	private WsClient(){} 

	public static void main(String[] args){ 
	//创建WebService客户端代理工厂 
//	JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//	//注册WebService接口
//	factory.setServiceClass(WebServiceCXF.class);
//	//设置WebService地址
//	factory.setAddress("http://localhost:8080/demo/ws/WsCXF");
//	WebServiceCXF helloWorld = (WebServiceCXF)factory.create();
//	System.out.println("invoke webservice..."); 
//	System.out.println("message context is:"+helloWorld.helloWorld(" sinosoft")); 
//	SimpleModel sm=helloWorld.findUser(null);
//	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//	System.out.println(sm.getName()+"---"+sdf.format(sm.getBirth())+"---"+(sm.isSex()==true?"男":"女"));
//	List<SimpleModel> list=helloWorld.findUsers();
//	for (SimpleModel simpleModel : list) {
//		System.out.println(simpleModel.getName()+"---"+sdf.format(simpleModel.getBirth())+"---"+(simpleModel.isSex()==true?"男":"女"));
//	}
	} 
}
