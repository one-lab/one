package com.sinosoft.one.sqltest.sqring;

import java.io.StringReader;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.hql.QueryTranslatorFactory;
import org.hibernate.hql.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.ast.QueryTranslatorImpl;
import org.hibernate.hql.ast.SqlGenerator;
import org.hibernate.impl.SessionFactoryImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.sinosoft.one.sqlparser.JSQLParserException;
import com.sinosoft.one.sqlparser.parser.JSqlParser;
import com.sinosoft.one.sqlparser.statement.select.Limit;
import com.sinosoft.one.sqlparser.statement.select.OrderByElement;
import com.sinosoft.one.sqlparser.statement.select.PlainSelect;
import com.sinosoft.one.sqlparser.statement.select.Select;


@DirtiesContext
@ContextConfiguration(locations = { "/spring/applicationContext-test.xml"})
public class TestSpringSql  extends AbstractJUnit4SpringContextTests {
	@Autowired
	private JSqlParser jSqlParser;
	private String hql;  
	  
	private String sql;
	@Test
	public void test() throws JSQLParserException{
		String statement = "SELECT * FROM mytable WHERE mytable.col = 9  group by tab1.a  order BY tab1.a DESC, tab1.b ASC  LIMIT 3,? ";
		PlainSelect plainSelect = (PlainSelect) ((Select) jSqlParser.parse(new StringReader(statement))).getSelectBody();
		List groupBy=new ArrayList();
		if(plainSelect.getGroupByColumnReferences()!=null){
			groupBy=plainSelect.getGroupByColumnReferences();
			plainSelect.setGroupByColumnReferences(null);
			System.out.println(plainSelect.toString());
		}
		List orderBy=new ArrayList();
		if(plainSelect.getOrderByElements()!=null){
			orderBy=plainSelect.getOrderByElements();
			plainSelect.setOrderByElements(null);
			System.out.println(plainSelect.toString());
		}
		Limit limit=new Limit();
		if(plainSelect.getLimit()!=null){
			limit=plainSelect.getLimit();
			plainSelect.setLimit(null);
			System.out.println(plainSelect.toString());
		}
//		System.out.println();
//		System.out.println(plainSelect.getOrderByElements());
//		System.out.println(plainSelect.getLimit());
//		System.out.println(plainSelect.getHaving());
//		Limit limit=plainSelect.getLimit();
//		List<OrderByElement> orderby=plainSelect.getOrderByElements();
	}
	 
}
