package com.sinosoft.one.data.test.dao;

import com.sinosoft.one.data.test.model.Student;
import com.sinosoft.one.data.test.model.User;
import com.sinosoft.one.data.jade.annotation.SQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-8-6
 * Time: 下午12:03
 * To change this template use File | Settings | File Templates.
 */

public interface StudentDao extends CrudRepository<Student, String> {

    @SQL("select * from t_student")
    @Transactional(readOnly = true)
    List<User> selectUser();

}
