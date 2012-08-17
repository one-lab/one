package com.sinosoft.one.data.test.dao;

import com.sinosoft.one.data.test.model.Student;
import com.sinosoft.one.data.test.model.User;
import com.sinosoft.one.data.jade.annotation.SQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

	@Query(value = "select s.id,s.name from Student s")
	@Transactional(readOnly = true)
	List<User> selectUser3();

	@Query(value = "select * from t_student",nativeQuery = true)
	@Transactional(readOnly = true)
	List<User> selectUser2();
	@Transactional(readOnly = true)
	List<User> sqlQuery1();
	@Transactional(readOnly = true)
	List<User> sqlQuery2(String id);
	@Transactional(readOnly = true)
	List<User> sqlQuery3(@Param("id") String id);
	@SQL("select * from t_student where id=:user.id")
	@Transactional(readOnly = true)
	List<User> sqlQuery4(@Param("user") User user,@Param("user2") User user2);
	List<User> getSSS();

}
