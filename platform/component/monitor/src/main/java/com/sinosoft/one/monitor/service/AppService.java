package com.sinosoft.one.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.dao.AppDao;
import com.sinosoft.one.monitor.model.App;
@Component
public class AppService {
	@Autowired
	private AppDao appDao;
	
	public List<App> getAllApp(){
		 return (List<App>) appDao.findAll(new Sort(Direction.ASC, "id"));
	}
	
	public App getAppById(String id){
		return appDao.findOne(id);
	}

	public App getAppByName(String appName) {
		return appDao.findOneByName(appName);
	}
}
