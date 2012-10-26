package com.sinosoft.one.sqlparser.expression;

import com.sinosoft.one.sqlparser.statement.select.SubSelect;

public class AnyComparisonExpression implements Expression {
	private SubSelect subSelect;
	
	public AnyComparisonExpression(SubSelect subSelect) {
		this.subSelect = subSelect;
	}
	
	public SubSelect GetSubSelect() {
		return subSelect;
	}

	public void accept(ExpressionVisitor expressionVisitor) {
		expressionVisitor.visit(this);
	}
}
