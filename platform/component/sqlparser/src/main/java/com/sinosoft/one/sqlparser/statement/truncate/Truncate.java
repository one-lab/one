package com.sinosoft.one.sqlparser.statement.truncate;

import com.sinosoft.one.sqlparser.schema.Table;
import com.sinosoft.one.sqlparser.statement.Statement;
import com.sinosoft.one.sqlparser.statement.StatementVisitor;


/**
 * A TRUNCATE TABLE statement
 */
public class Truncate implements Statement {
	private Table table;

	public void accept(StatementVisitor statementVisitor) {
		statementVisitor.visit(this);
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String toString() {
		return "TRUNCATE TABLE "+table;
	}
}
