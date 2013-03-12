package com.sinosoft.one.monitor.os.linux.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.monitor.os.linux.model.viewmodel.StatiDataModel;
import com.sinosoft.one.monitor.os.linux.repository.OsStatiRepository;
import com.sinosoft.one.monitor.os.linux.util.OsUtil;

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
	
	@Autowired
	private OsStatiRepository osStatiRepository;
	@Test
	public void createlineView(){
//		Map<String,  Map<String,List<Map<String, Object>>>> viewMap=osViewHandle.createlineView(new Date(), 5, 1);
		System.out.println(1);
	}
	
	@Test
	public void createCpuStaticLineView(){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat(OsUtil.DATEFORMATE_YEAR_MON_DAY);
		Date end=new Date();
		Date begin=new Date(end.getTime()-24*60*60*1000*30);
		List<StatiDataModel> osStatis=osStatiRepository.findStatiValue("402892163d208194013d208198790000", "DH", "2013-03-01", simpleDateFormat.format(end), OsUtil.ORCL_DATEFORMATE);
		for (StatiDataModel osStati : osStatis) {
			
		}
	}
}
