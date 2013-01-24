package com.sinosoft.one.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.dao.WarnDao;
import com.sinosoft.one.monitor.model.Warn;


@Component
public class WarnService {
	private WarnDao warnDao;

	public void save(Warn warn){
		warnDao.save(warn);
	}
	
	public List<Warn> getAllByAppId(String appId){
		return warnDao.findAllByAppId(appId);
	}
	
	public List<Warn> getAllWarns(){
		return (List<Warn>)warnDao.findAll();
	}
//	public List<Warn> 
	@Autowired
	public void setWarnDao(WarnDao warnDao) {
		this.warnDao = warnDao;
	}
	
	
}
