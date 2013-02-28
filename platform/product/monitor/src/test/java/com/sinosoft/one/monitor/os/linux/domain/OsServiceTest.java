package com.sinosoft.one.monitor.os.linux.domain;

import java.sql.Clob;

import oracle.sql.CLOB;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.monitor.os.linux.model.Os;

@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class OsServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private OsService osService;
	
	@Test
	public void saveOsBasic(){
		osService.saveOsBasic( "test", "linux", "192.168.18.217", "255.255.255.0", 5);
	}
	
	@Test
	public void getOsBasic(){
		Os os=osService.getOsBasic("402892163d1f4f23013d1f4f27220000"); 
		Assert.assertEquals("linux", os.getType());
	}
	
	@Test
	public void deleteOsBasic(){
		osService.deleteOsBasic("402892163d1f4f23013d1f4f27220000");
	}
	
	@Test
	public void saveShell(){
		String template="top -b -n 1 | head -5 | tail -2 |awk '{print $1,$2,$3,$4,$5,$6,$7,$8,$9}'";
		osService.saveShell("RM", template);
	}
	
	@Test
	public void getShell(){
		String template="top -b -n 1 | head -5 | tail -2 |awk '{print $1,$2,$3,$4,$5,$6,$7,$8,$9}'";
		template=osService.getOsShell("RM");
	}
	
}
