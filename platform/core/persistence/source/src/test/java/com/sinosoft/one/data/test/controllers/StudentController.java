package com.sinosoft.one.data.test.controllers;

import com.sinosoft.one.data.test.dao.StudentDao;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-8-9
 * Time: 下午5:45
 * To change this template use File | Settings | File Templates.
 */
@Path("/student")
public class StudentController {
    @Autowired
    private StudentDao studentDao;
    @Get
    public String getStudents(Invocation invocation) {
        return "@student:" + (studentDao.findAll());
    }
}
