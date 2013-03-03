package com.sinosoft.one.monitor.os.linux.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
@DirtiesContext
@ContextConfiguration(locations = {"/spring/applicationContext-test.xml"})
public class OsProcessServiceTest extends AbstractJUnit4SpringContextTests{
	@Autowired
	private OsProcessService osProcessService;
}
