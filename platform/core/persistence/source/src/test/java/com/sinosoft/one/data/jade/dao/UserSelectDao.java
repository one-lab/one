package com.sinosoft.one.data.jade.dao;

import com.sinosoft.one.data.jade.annotation.RowHandler;
import com.sinosoft.one.data.jade.annotation.SQL;
import com.sinosoft.one.data.jade.model.SomePropertis;
import com.sinosoft.one.data.jade.model.User;
import com.sinosoft.one.data.jade.model.User1;
import com.sinosoft.one.data.jade.rowMapper.UserRowMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 * User: Chunliang.Han
 * Time: 12-9-5[上午10:55]
 */
public interface UserSelectDao  extends UserDao {
    //4.1.1
    User selectUserWithSqlQueryById(String id);

    //4.1.2
    @SQL("select name from t_user where id= ?1")
    String selectUserNameWithAnnoById(String id);

    //4.1.3
    int selectUserAgeWithSqlQueryById(String id);

    //4.1.4
    @SQL("select age from t_user where id= ?1")
    Integer selectUserAgeWithAnnoById(String id);

    //4.1.5
    Date selectUserBirthdayWithSqlQueryById(String id);

    //4.1.6
    @SQL("select money from t_user where id= ?1")
    Long selectUserMoneyWithAnnoById(String id);

    //4.1.7
    long selectUserMoneyWithSqlQUeryById(String id);

    //4.2.1
    @SQL("select * from t_user where groupIds in (?1)")
    List<User> selectUserWithAnnoByGroupid(Set<String> groups);

    //4.2.2
    @SQL("select * from t_user where groupIds in (?1)")
    List<User> selectUserWithAnnoByGroupid(List<String> groups);

    //4.2.3
    @SQL("select * from t_user where groupIds in (?1)")
    List<User> selectUserWithAnnoByGroupid(String[] groups);

    //4.2.4
    @SQL("select * from t_user where id = :idAndName.id and name = :idAndName.name")
    User selectUserWithAnnoByIdAndName(@Param("idAndName")Map<String,?> idAndName);

    //4.2.5
    @SQL("select * from t_user where id = ?1.id and name = ?1.name")
    List<User> selectUsersWithAnnoByIdAndName(Map<String,?> idAndName);

    //4.2.6
    @SQL("select u.id id,u.name from t_user u,t_code_group g where u.groupIds = g.id and g.name = :params.0 and u.birthday = :params.1")
    List<User> selectUsersWithAnnoByGnameAndUbirthday(@Param("params")Object[] params);

    //4.2.7
    @SQL("select u.id id,u.name from t_user u,t_code_group g where u.groupIds = g.id and g.name = ?1.0")
    User selectUserWithAnnoByGnameAndUbirthday(Object[] params);

    //4.3.1
    //@SQL("select u.id user_id,u.name user_name, g.name group_name, s.name gender_name from t_user u,t_code_group g,t_code_gender s where u.groupIds = g.id(+) and u.gender = s.id(+)")
    Page<SomePropertis> selectUsersWithSqlQueryForPage(Pageable pageable);

    //4.3.1
    @SQL("select * from t_user")
    Page<User> selectUsersWithAnooForPage(Pageable pageable);

    //4.3.2
    @SQL("select id, name from t_user where groupIds in (?1)")
    @RowHandler(rowMapper = UserRowMapper.class)
    List<User1> selectUser1WithAnnoByGroupid(Set<String> groups);

    //4.2.3
    @SQL("SELECT * FROM t_##(:table) #if(:gender=='0'){ where id=:id } ")
    List<User> selectUserForActiveSql(@Param("table")String table,@Param("gender")String  gender,@Param("id") String id);

    //4.2.4
    //@SQL("SELECT * FROM t_##(:table) #if(:gender=='0'){ #if(:gender=='0'){where id=:id} and name=:name } ")
    List<User> selectUserForActiveComplexSql(@Param("table")String table,@Param("gender")String  gender,@Param("id") String id,@Param("name") String name);

    //4.2.5
    @SQL("SELECT * FROM t_user where id='AAF000' #for(var in :params){ #if(:var==0) { and 0=:var} #if(:var==1) { and 1=:var}} ")
    User selectUserForActiveComplexSql1(@Param("params") int[] params);

}