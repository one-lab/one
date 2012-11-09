package com.sinosoft.one.demo.service.cxf;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.sinosoft.one.demo.model.SimpleModel;

@WebService
public interface WebServiceCXF {
	@WebMethod
	@WebResult
	String helloWorld(@WebParam String name);

	@WebMethod
	@WebResult
	SimpleModel findUser(@WebParam SimpleModel user);

	@WebMethod
	@WebResult
	List<SimpleModel> findUsers();
}
