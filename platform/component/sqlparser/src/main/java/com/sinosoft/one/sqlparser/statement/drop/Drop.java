package com.sinosoft.one.sqlparser.statement.drop;

import java.util.List;

import com.sinosoft.one.sqlparser.statement.Statement;
import com.sinosoft.one.sqlparser.statement.StatementVisitor;
import com.sinosoft.one.sqlparser.statement.select.PlainSelect;


public class Drop implements Statement {
	private String type;
	private String name;
	private List parameters;
	
	public void accept(StatementVisitor statementVisitor) {
		statementVisitor.visit(this);
	}

	public String getName() {
		return name;
	}

	public List getParameters() {
		return parameters;
	}

	public String getType() {
		return type;
	}

	public void setName(String string) {
		name = string;
	}

	public void setParameters(List list) {
		parameters = list;
	}

	public void setType(String string) {
		type = string;
	}

	public String toString() {
		String sql = "DROP "+type+" "+name;
		
		if( parameters != null && parameters.size() > 0) {
			sql += " "+PlainSelect.getStringList(parameters);
		}
		
		return sql;
	}
}
