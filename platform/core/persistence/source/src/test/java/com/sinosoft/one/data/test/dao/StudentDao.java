package com.sinosoft.one.data.test.dao;

import com.sinosoft.one.data.test.model.Student;
import com.sinosoft.one.data.test.model.User;
import com.sinosoft.one.data.jade.annotation.SQL;

import org.springframework.data.domain.Pageable;
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
    List<User> selectUser();

	@Query(value = "select s.id,s.name from Student s")
	List<User> selectUser3();

	@Query(value = "select * from t_student",nativeQuery = true)
	List<User> selectUser2();
	int sqlQuery1(String id, String name);
	List<User> sqlQuery2(String id);
	List<User> sqlQuery3(@Param("id") String id);
	@SQL("select * from t_student where id=:user.id")
	List<User> sqlQuery4(@Param("user") User user,@Param("user2") User user2);
	List<User> getSSS();

    @SQL("insert into t_student values(?1, ?2)")
    int saveStudent(String id, String name);

}
