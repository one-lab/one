package com.sinosoft.one.sqlparser.expression.operators.relational;

import com.sinosoft.one.sqlparser.expression.BinaryExpression;
import com.sinosoft.one.sqlparser.expression.ExpressionVisitor;

public class Matches extends BinaryExpression {
	public void accept(ExpressionVisitor expressionVisitor) {
		expressionVisitor.visit(this);
	}

	public String getStringExpression() {
		return "@@";
	}
}
