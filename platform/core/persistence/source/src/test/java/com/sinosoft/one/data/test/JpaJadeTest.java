package com.sinosoft.one.data.test;

import com.sinosoft.one.data.test.dao.StudentDao;
import com.sinosoft.one.data.test.model.User;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class JpaJadeTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void testJade() {
        Assert.assertNotNull(studentDao.selectUser());
		Assert.assertNotNull(studentDao.selectUser2());
		Assert.assertNotNull(studentDao.selectUser3());
		Assert.assertNotNull(studentDao.findAll());
		Assert.assertNotNull(studentDao.getSSS());
		Assert.assertNotNull(studentDao.sqlQuery1());
		Assert.assertNotNull(studentDao.sqlQuery2("123") );

		Assert.assertNotNull(studentDao.sqlQuery3("123") );
		User user = new User();
		user.setId("123");
		Assert.assertNotNull(studentDao.sqlQuery4(user) );
    }
}
