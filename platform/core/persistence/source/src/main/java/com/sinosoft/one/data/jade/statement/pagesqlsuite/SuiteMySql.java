package com.sinosoft.one.data.jade.statement.pagesqlsuite;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: kylin
 * Date: 12-8-16
 * Time: 下午2:44
 * To change this template use File | Settings | File Templates.
 */
public class SuiteMySql implements SuiteDataSourcePageSql{

    public static final String COMMA = ",";
    public static final String SPACE = " ";
    public static final String ORDER = " order by ";

    public String suiteSql(String sql,Pageable pageable) {
    	StringBuilder newSql = new StringBuilder();
        newSql.append(sql);
        renderForOrders(pageable,newSql) ;
        newSql.append(SPACE);
    	newSql.append(" limit ")
    	.append((pageable.getPageNumber()-1)*pageable.getPageSize())
    	.append(",").append(pageable.getPageSize());
    	return newSql.toString();
    }
    private StringBuilder renderForOrders(Pageable pageable,StringBuilder sb){
        if(pageable.getSort()!=null){
            Iterator iterator = pageable.getSort().iterator();
            String sep = new String() ;
            sb.append(ORDER);
            while(iterator.hasNext()){
                sb.append(sep);
                Sort.Order order = (Sort.Order)iterator.next();
                sb.append(order.getProperty()).append(SPACE).append(order.getDirection());
                sep = COMMA;
            }
        }
        return sb;
    }
}
