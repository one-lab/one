package com.sinosoft.one.data.test;

import java.util.List;

import com.sinosoft.one.data.test.dao.UserDao;
import com.sinosoft.one.data.test.model.User;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-8-10
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class PageSqlTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testJade() {
    	//testMysql();
    	testOracle();
    }
    private void testMysql() {
    	Pageable pageable = new PageRequest(1, 10);
    	Page<User> page= userDao.selectUser(pageable);
		Assert.assertNotNull(page);
		Assert.assertEquals(10, page.getSize());
		Assert.assertEquals(14L, page.getTotalElements());
		Assert.assertEquals(2, page.getTotalPages());
		Assert.assertEquals(1, page.getNumber());
		List<User> users = page.getContent();
		User user = users.get(9);
		Assert.assertEquals("aab010", user.getId());
		Assert.assertEquals("content10", user.getName());
    }
    private void testOracle() {
    	Pageable pageable = new PageRequest(2, 10);
    	Page<User> page= userDao.selectUser(pageable);
		Assert.assertNotNull(page);
		Assert.assertEquals(10, page.getSize());
		Assert.assertEquals(60L, page.getTotalElements());
		Assert.assertEquals(6, page.getTotalPages());
		Assert.assertEquals(2, page.getNumber());
		List<User> users = page.getContent();
		User user = users.get(0);
		Assert.assertEquals("011", user.getId());
		Assert.assertEquals("kylin011", user.getName());
    }
}
