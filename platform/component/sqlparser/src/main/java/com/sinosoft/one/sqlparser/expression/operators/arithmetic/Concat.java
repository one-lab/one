package com.sinosoft.one.sqlparser.expression.operators.arithmetic;

import com.sinosoft.one.sqlparser.expression.BinaryExpression;
import com.sinosoft.one.sqlparser.expression.ExpressionVisitor;

public class Concat extends BinaryExpression {

	public void accept(ExpressionVisitor expressionVisitor) {
		expressionVisitor.visit(this);
	}
	
	public String getStringExpression() {
		return "||";
	}

}
