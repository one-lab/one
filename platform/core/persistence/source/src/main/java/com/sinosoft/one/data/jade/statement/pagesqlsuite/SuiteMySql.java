package com.sinosoft.one.data.jade.statement.pagesqlsuite;

import org.springframework.data.domain.Pageable;

/**
 * Created with IntelliJ IDEA.
 * User: kylin
 * Date: 12-8-16
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public class SuiteMySql implements SuiteDataSourcePageSql{

    public String suiteSql(String sql,Pageable pageable) {
    	StringBuilder newSql = new StringBuilder();
    	newSql.append(sql).append(" limit ")
    	.append((pageable.getPageNumber()-1)*pageable.getPageSize())
    	.append(",").append(pageable.getPageSize());
    	return newSql.toString();
    }
}
