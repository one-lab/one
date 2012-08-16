package com.sinosoft.one.data.jade.statement.pageExpression;

import org.springframework.data.domain.Pageable;

/**
 * Created with IntelliJ IDEA.
 * User: kylin
 * Date: 12-8-16
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public class SuiteOracle implements SuiteDataSourcePageSql {

    public String suiteSql(String sql,Pageable pageable) {
        StringBuilder newSql = new StringBuilder();
        newSql.append("select * from (select a.*, rownum rn from(")
                .append(sql)
                .append(") a where rownum <=")
                .append(pageable.getPageSize()*pageable.getPageNumber())
                .append(") where rn >")
                .append(pageable.getPageSize()*(pageable.getPageNumber()-1));
        return newSql.toString();
    }
}
