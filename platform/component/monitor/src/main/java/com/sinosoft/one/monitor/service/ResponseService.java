package com.sinosoft.one.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sinosoft.one.monitor.dao.ResponseDao;
import com.sinosoft.one.monitor.model.Response;

@Component
@Service("responseService")
public class ResponseService {
	ResponseDao responseDao;
	public List<Response> findAllUrls(String appName){
		return responseDao.selectResponseForDynamicComplexSql(appName);
	}
	
	public List<Response> findAllUrls(){
		return (List<Response>)responseDao.findAll();
	}
	
	public void updateResponse(Response response){
		responseDao.save(response);
	}
	public Response getResponse(String id){
		return responseDao.findOne(id);
	}
	
	public void deleteReponse(String id){
		responseDao.delete(id);
	}

	public void save(Response response) {
		responseDao.save(response);
	}
	public ResponseDao getResponseDao() {
		return responseDao;
	}
	
	@Autowired
	public void setResponseDao(ResponseDao responseDao) {
		this.responseDao = responseDao;
	}
}
