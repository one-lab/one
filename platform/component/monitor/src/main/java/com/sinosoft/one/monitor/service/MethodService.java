package com.sinosoft.one.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.dao.MethodDao;
import com.sinosoft.one.monitor.model.Method;


@Component
public class MethodService {
	@Autowired
	private MethodDao methodDao;
	
	public List<Method> getAllMethod(String appId){
		return methodDao.findAllByAppId(appId);
	}
	public List<Method> getAllMethod(){
		return (List<Method>)methodDao.findAll();
	}
	public void deleteMethod(String id){
		methodDao.delete(id);
	}
	public Method save(Method method) {
		return methodDao.save(method);
	}
}
