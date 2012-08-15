package com.sinosoft.one.data.test;

import com.sinosoft.one.data.test.dao.StudentDao;
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
        Assert.assertEquals(2, studentDao.selectUser().size());
    }
}
