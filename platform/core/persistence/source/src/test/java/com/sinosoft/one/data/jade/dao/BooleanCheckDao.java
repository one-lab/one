package com.sinosoft.one.data.jade.dao;

import com.sinosoft.one.data.jade.annotation.SQL;

/**
 * User: Chunliang.Han
 * Time: 12-9-5[上午11:21]
 */
public interface BooleanCheckDao extends UserDao {

    //4.1.8
    @SQL("select boolean_int from t_check_boolean where id= ?1")
    boolean selectBooleanIntWithAnnoById(String id);

    //4.1.10
    @SQL("select boolean_str from t_check_boolean where id= ?1")
    boolean selectBooleanStrWithAnnoById(String id);

}
