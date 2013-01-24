package com.sinosoft.one.monitor.dao;
// Generated 2012-12-20 16:34:06 by One Data Tools 1.0.0

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.monitor.model.Mailinfo;


public interface MailinfoDao extends PagingAndSortingRepository<Mailinfo, String> {
	 public Mailinfo findById(String id);
}

