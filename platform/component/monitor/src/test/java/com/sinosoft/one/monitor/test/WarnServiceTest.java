package com.sinosoft.one.monitor.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.sinosoft.one.monitor.dao.WarnDao;
import com.sinosoft.one.monitor.model.Warn;
import com.sinosoft.one.monitor.service.WarnService;
@DirtiesContext
@ContextConfiguration(locations = { "/applicationContext-test.xml",
		"/spring/applicationContext-log.xml" })
public class WarnServiceTest {
	
	private WarnService mockWarnService =new WarnService();
	@Mock
	private WarnDao warnDao;
	@Mock
	private Warn warn;
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockWarnService.setWarnDao(warnDao);
	}
	
	/*@Test
	public void save(){
		warnService.save(warn);
	}*/
	@Test
	public void findAllByAppname(){
		assertEquals(mockWarnService.getAllByAppId("epicc_ecar"), "");
	}
	@Test
	public void testMockInterface(){
		List<Warn> list=new ArrayList<Warn>();
		when(mockWarnService.getAllByAppId("epicc_ecar")).thenReturn(list);
		/*
		//①-1 对方法设定返回值
		　　when(mockWarnService.getAllByAppname("epicc_ecar")).thenReturn（
		　　new User(("tom", "1234"))；
		　　//①-2 对方法设定返回值
		　　doReturn（true）。when（mockServiceImpl）。hasMatchUser（"tom", "1234"）；
		　　//①-3 对void方法进行方法预期设定
		　　User u = new User（"John", "1234"）；
		　　doNothing().when（mockUserService）。registerUser（u）；
		　　//①-4 执行方法调用
		　　User user = mockUserService.findUserByUserName（"tom"）；
		　　boolean isMatch = mockUserService.hasMatchUser（"tom","1234"）；
		　　mockUserService.registerUser（u）；
		　　assertNotNull（user）；
		　　assertEquals（user.getUserName（）， "tom"）；
		　　assertEquals（isMatch, true）；
	*/}
}
