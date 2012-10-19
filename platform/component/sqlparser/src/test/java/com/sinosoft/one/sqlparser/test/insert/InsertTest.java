package com.sinosoft.one.sqlparser.test.insert;

import java.io.StringReader;

import junit.framework.TestCase;
import com.sinosoft.one.sqlparser.JSQLParserException;
import com.sinosoft.one.sqlparser.expression.DoubleValue;
import com.sinosoft.one.sqlparser.expression.JdbcParameter;
import com.sinosoft.one.sqlparser.expression.LongValue;
import com.sinosoft.one.sqlparser.expression.StringValue;
import com.sinosoft.one.sqlparser.expression.operators.relational.ExpressionList;
import com.sinosoft.one.sqlparser.parser.CCJSqlParserManager;
import com.sinosoft.one.sqlparser.schema.Column;
import com.sinosoft.one.sqlparser.schema.Table;
import com.sinosoft.one.sqlparser.statement.insert.Insert;
import com.sinosoft.one.sqlparser.statement.select.PlainSelect;
import com.sinosoft.one.sqlparser.statement.select.SubSelect;

public class InsertTest extends TestCase {
	CCJSqlParserManager parserManager = new CCJSqlParserManager();

	public InsertTest(String arg0) {
		super(arg0);
	}

	public void testRegularInsert() throws JSQLParserException {
		String statement = "INSERT INTO mytable (col1, col2, col3) VALUES (?, 'sadfsd', 234)";
		Insert insert = (Insert) parserManager.parse(new StringReader(statement));
		assertEquals("mytable", insert.getTable().getName());
		assertEquals(3, insert.getColumns().size());
		assertEquals("col1", ((Column) insert.getColumns().get(0)).getColumnName());
		assertEquals("col2", ((Column) insert.getColumns().get(1)).getColumnName());
		assertEquals("col3", ((Column) insert.getColumns().get(2)).getColumnName());
		assertEquals(3, ((ExpressionList) insert.getItemsList()).getExpressions().size());
		assertTrue (((ExpressionList) insert.getItemsList()).getExpressions().get(0) instanceof JdbcParameter);
		assertEquals("sadfsd", ((StringValue) ((ExpressionList) insert.getItemsList()).getExpressions().get(1)).getValue());
		assertEquals(234, ((LongValue) ((ExpressionList) insert.getItemsList()).getExpressions().get(2)).getValue());
		assertEquals(statement, ""+insert);

		 statement = "INSERT INTO myschema.mytable VALUES (?, ?, 2.3)";
		 insert = (Insert) parserManager.parse(new StringReader(statement));
		assertEquals("myschema.mytable", insert.getTable().getWholeTableName());
		assertEquals(3, ((ExpressionList) insert.getItemsList()).getExpressions().size());
		assertTrue (((ExpressionList) insert.getItemsList()).getExpressions().get(0) instanceof JdbcParameter);
		assertEquals(2.3, ((DoubleValue) ((ExpressionList) insert.getItemsList()).getExpressions().get(2)).getValue(), 0.0);
		assertEquals(statement, ""+insert);

	}

	public void testInsertFromSelect() throws JSQLParserException {
		String statement = "INSERT INTO mytable (col1, col2, col3) SELECT * FROM mytable2";
		Insert insert = (Insert) parserManager.parse(new StringReader(statement));
		assertEquals("mytable", insert.getTable().getName());
		assertEquals(3, insert.getColumns().size());
		assertEquals("col1", ((Column) insert.getColumns().get(0)).getColumnName());
		assertEquals("col2", ((Column) insert.getColumns().get(1)).getColumnName());
		assertEquals("col3", ((Column) insert.getColumns().get(2)).getColumnName());
		assertTrue (insert.getItemsList() instanceof SubSelect);
		assertEquals("mytable2", ((Table) ((PlainSelect) ((SubSelect)insert.getItemsList()).getSelectBody()).getFromItem()).getName());
		
		//toString uses brakets
		String statementToString = "INSERT INTO mytable (col1, col2, col3) (SELECT * FROM mytable2)";
		assertEquals(statementToString, ""+insert);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(InsertTest.class);
	}

}
