package com.sinosoft.one.sqlparser.test.delete;

import java.io.StringReader;

import junit.framework.TestCase;
import com.sinosoft.one.sqlparser.JSQLParserException;
import com.sinosoft.one.sqlparser.parser.CCJSqlParserManager;
import com.sinosoft.one.sqlparser.statement.delete.Delete;

public class DeleteTest extends TestCase {
	CCJSqlParserManager parserManager = new CCJSqlParserManager();

	public DeleteTest(String arg0) {
		super(arg0);
	}

	public void testDelete() throws JSQLParserException {
		String statement = "DELETE FROM mytable WHERE mytable.col = 9";

		Delete delete = (Delete) parserManager.parse(new StringReader(statement));
		assertEquals("mytable", delete.getTable().getName());
		assertEquals(statement, ""+delete);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(DeleteTest.class);
	}

}
