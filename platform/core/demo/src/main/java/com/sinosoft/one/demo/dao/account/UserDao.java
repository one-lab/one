package com.sinosoft.one.demo.dao.account;

import com.sinosoft.one.data.jade.annotation.SQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sinosoft.one.demo.model.account.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 用户对象的Dao interface.
 *
 * @author calvin
 */
public interface UserDao extends PagingAndSortingRepository<User, Long> , QueryDslPredicateExecutor<User> {

    User findByLoginName(String loginName);

    @SQL("select * from acct_user where id is not null #if(:name!='') {and name like :name} #if(:email!='') {and email like :email} #if(:id!=null) {and id>=:id}")
    List<User> selectUserForDynamicComplexSql(@Param("name") String name,@Param("email") String email, @Param("id") Long id);

    @Query("select u from User u")
    List<User> findAllUserByJpql();

    List<User> findAllUseuByResourse();
}
