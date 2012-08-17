package com.sinosoft.one.data.test.dao;

import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.data.test.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.util.List;

/**
 * User: Morgan
 * Date: 12-8-17
 * Time: 下午3:34
 */
public interface TeacherDao extends CrudRepository<Teacher,Integer> {

	List<Teacher> getSSS();

	@Query(value="select s from Teacher s")
	List<Teacher> getSSS2();

	List<Teacher> findById(String id);

	@Transactional(readOnly = true)
	List<Teacher> sqlQueryName1();
	@Transactional(readOnly = true)
	Teacher sqlQueryName2(String id);

	@SQL("select * from teacher where id=?1")
	@Transactional(readOnly = true)
	Teacher sqlQueryName3(String id);

}
