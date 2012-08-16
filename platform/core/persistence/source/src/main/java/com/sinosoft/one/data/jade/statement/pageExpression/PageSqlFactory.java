package com.sinosoft.one.data.jade.statement.pageExpression;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: kylin
 * Date: 12-8-16
 * Time: 下午2:39
 * To change this template use File | Settings | File Templates.
 */
public class PageSqlFactory {

    private static final String ORACLE=":oracle:";
    private static final String MYSQL=":mysql:";
    private static final String SQL_SERVER=":sqlserver:";

    public static SuiteDataSourcePageSql createPageSql(String URL) {
        if(URL.contains(ORACLE)){
            return new SuiteOracle();
        }   else if(URL.contains(MYSQL)) {
            return new SuiteMySql();
        }   else if (URL.contains(SQL_SERVER)) {
            return new SuiteSqlServer();
        }
        return null;
    }

}
