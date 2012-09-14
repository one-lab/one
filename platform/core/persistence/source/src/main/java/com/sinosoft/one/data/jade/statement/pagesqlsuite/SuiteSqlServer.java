package com.sinosoft.one.data.jade.statement.pagesqlsuite;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created with IntelliJ IDEA.
 * User: kylin
 * Date: 12-8-16
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public class SuiteSqlServer extends AbstractSuiteDataSourceSql implements SuiteDataSourceSql {

    public String suiteSql(String sql,Pageable pageable,Sort sort) {
    	throw new UnsupportedOperationException("this method is not implements now!");
    }

    //@Override
    String renderForPage(String sql, Pageable pageable) {
        return null;
    }

    //@Override
    String renderForSort(String sql, Sort sort) {
        return null;
    }
}
