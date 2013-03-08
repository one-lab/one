package com.sinosoft.one.monitor.os.linux.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class OsViewDataHandleServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private OsAvailableViewHandle osViewDataHandleService;
	
	@Autowired
	private OsCpuViewHandle osCpuViewDataHanleService;
	
	@Autowired
	private OsService osService;
	
	@Autowired
	private OsViewHandle osViewHandle;
	
	
	@Test
	public void createlineView(){
		Map<String,  Map<String,List<Map<String, Object>>>> viewMap=osViewHandle.createlineView(new Date(), 5, 1);
		System.out.println(1);
	}
	
	
	@Test
	public void createCpuStaticLineView(){
	  	System.out.println(1);
	}
}
