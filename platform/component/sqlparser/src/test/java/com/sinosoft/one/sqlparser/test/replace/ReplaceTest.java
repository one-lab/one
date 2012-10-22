package com.sinosoft.one.sqlparser.test.replace;

import java.io.StringReader;

import junit.framework.TestCase;
import com.sinosoft.one.sqlparser.JSQLParserException;
import com.sinosoft.one.sqlparser.expression.JdbcParameter;
import com.sinosoft.one.sqlparser.expression.LongValue;
import com.sinosoft.one.sqlparser.expression.StringValue;
import com.sinosoft.one.sqlparser.expression.operators.relational.ExpressionList;
import com.sinosoft.one.sqlparser.parser.CCJSqlParserManager;
import com.sinosoft.one.sqlparser.schema.Column;
import com.sinosoft.one.sqlparser.statement.replace.Replace;
import com.sinosoft.one.sqlparser.statement.select.SubSelect;

public class ReplaceTest extends TestCase {
	CCJSqlParserManager parserManager = new CCJSqlParserManager();

	public ReplaceTest(String arg0) {
		super(arg0);
	}

	public void testReplaceSyntax1() throws JSQLParserException {
		String statement = "REPLACE mytable SET col1='as', col2=?, col3=565";
		Replace replace = (Replace) parserManager.parse(new StringReader(statement));
		assertEquals("mytable", replace.getTable().getName());
		assertEquals(3, replace.getColumns().size());
		assertEquals("col1", ((Column) replace.getColumns().get(0)).getColumnName());
		assertEquals("col2", ((Column) replace.getColumns().get(1)).getColumnName());
		assertEquals("col3", ((Column) replace.getColumns().get(2)).getColumnName());
		assertEquals("as", ((StringValue)replace.getExpressions().get(0)).getValue());
		assertTrue(replace.getExpressions().get(1) instanceof JdbcParameter);
		assertEquals(565, ((LongValue)replace.getExpressions().get(2)).getValue());
		assertEquals(statement, ""+replace);

	}

	public void testReplaceSyntax2() throws JSQLParserException {
		String statement = "REPLACE mytable (col1, col2, col3) VALUES ('as', ?, 565)";
		Replace replace = (Replace) parserManager.parse(new StringReader(statement));
		assertEquals("mytable", replace.getTable().getName());
		assertEquals(3, replace.getColumns().size());
		assertEquals("col1", ((Column) replace.getColumns().get(0)).getColumnName());
		assertEquals("col2", ((Column) replace.getColumns().get(1)).getColumnName());
		assertEquals("col3", ((Column) replace.getColumns().get(2)).getColumnName());
		assertEquals("as", ((StringValue) ((ExpressionList)replace.getItemsList()).getExpressions().get(0)).getValue());
		assertTrue(((ExpressionList)replace.getItemsList()).getExpressions().get(1) instanceof JdbcParameter);
		assertEquals(565, ((LongValue) ((ExpressionList)replace.getItemsList()).getExpressions().get(2)).getValue());
		assertEquals(statement, ""+replace);
	}


	public void testReplaceSyntax3() throws JSQLParserException {
		String statement = "REPLACE mytable (col1, col2, col3) SELECT * FROM mytable3";
		Replace replace = (Replace) parserManager.parse(new StringReader(statement));
		assertEquals("mytable", replace.getTable().getName());
		assertEquals(3, replace.getColumns().size());
		assertEquals("col1", ((Column) replace.getColumns().get(0)).getColumnName());
		assertEquals("col2", ((Column) replace.getColumns().get(1)).getColumnName());
		assertEquals("col3", ((Column) replace.getColumns().get(2)).getColumnName());
		assertTrue(replace.getItemsList() instanceof SubSelect);
		//TODO:
		//assertEquals(statement, ""+replace);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(ReplaceTest.class);
	}

}
