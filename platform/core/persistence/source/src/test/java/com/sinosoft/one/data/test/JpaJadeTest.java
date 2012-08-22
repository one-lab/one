package com.sinosoft.one.data.test;

import com.sinosoft.one.data.test.dao.StudentDao;
import com.sinosoft.one.data.test.dao.TeacherDao;
import com.sinosoft.one.data.test.model.Student;
import com.sinosoft.one.data.test.model.User;
import junit.framework.Assert;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

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

	@Autowired
	private TeacherDao teacherDao;

    @Test
    public void testJade() {
        long currentTimeMillis = System.currentTimeMillis();
        Student student = studentDao.save(new Student(String.valueOf(System.currentTimeMillis()), "carvin_" + currentTimeMillis));
        Assert.assertNotNull(currentTimeMillis + "", student.getId());

        String id = currentTimeMillis + RandomUtils.nextInt() + "";
        Assert.assertEquals(1, studentDao.saveStudent(id, "carvin_" + id));
        Assert.assertNotNull(studentDao.selectUser());
		Assert.assertNotNull(studentDao.selectUser2());
		Assert.assertNotNull(studentDao.selectUser3());
		Assert.assertNotNull(studentDao.findAll());
		Assert.assertNotNull(studentDao.getSSS());

        id = currentTimeMillis + RandomUtils.nextInt() + "";
		Assert.assertEquals(1, studentDao.sqlQuery1(id, "carvin_" + id));
		Assert.assertTrue(studentDao.sqlQuery2("123").size() == 0);
		Assert.assertNotNull(studentDao.sqlQuery3("123"));
		User user = new User();
		user.setId("123");
		Assert.assertNotNull(studentDao.sqlQuery4(user, user));
		//System.out.println(studentDao.sqlQuery4(user,user)+"================================");
    }

	@Test
	public void testTeacher() {
		Assert.assertNotNull("teacherDao.getSSS()===",teacherDao.getSSS());
		Assert.assertNotNull("teacherDao.getSSS2()===",teacherDao.getSSS2());
		Assert.assertNotNull("teacherDao.findById(\"123\")===",teacherDao.findById("123"));
		Assert.assertNotNull("teacherDao.sqlQueryName1()===",teacherDao.sqlQueryName1());
		Assert.assertNotNull("teacherDao.sqlQueryName2(\"1\")===",teacherDao.sqlQueryName2("1"));
		Assert.assertNotNull("teacherDao.sqlQueryName3(\"2\")===",teacherDao.sqlQueryName3("2"));
	}
}
