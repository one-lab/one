package com.sinosoft.one.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.dao.UrlDao;
import com.sinosoft.one.monitor.model.Url;

/**
 * 监控url时效性的服务类
 */
@Component
public class UrlService {
	
	private UrlDao urlDao;

	public void updateUrl(Url url){
		urlDao.save(url);
	}
	
	public void saveUrl(Url url){
		urlDao.save(url);
	}

	public void delete(String id) {
		urlDao.delete(id);
		
	}
	
	public void delete(Url url){
		urlDao.delete(url);
	}
	public List<Url> getAllUrl(String appId){
		return urlDao.findAllUrlByAppId(appId);
	}
	
	public List<Url> getAllUrl(){
		return (List<Url>)urlDao.findAll();
	}
	
	public Url getUrlById(String id){
		return urlDao.findOne(id);
	}
	public UrlDao getUrlDao() {
		return urlDao;
	}
	@Autowired
	public void setUrlDao(UrlDao urlDao) {
		this.urlDao = urlDao;
	}
}
