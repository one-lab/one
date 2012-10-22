package com.sinosoft.one.sqlparser.util.deparser;

import java.util.Iterator;
import java.util.List;

import com.sinosoft.one.sqlparser.expression.AllComparisonExpression;
import com.sinosoft.one.sqlparser.expression.AnyComparisonExpression;
import com.sinosoft.one.sqlparser.expression.BinaryExpression;
import com.sinosoft.one.sqlparser.expression.CaseExpression;
import com.sinosoft.one.sqlparser.expression.DateValue;
import com.sinosoft.one.sqlparser.expression.DoubleValue;
import com.sinosoft.one.sqlparser.expression.Expression;
import com.sinosoft.one.sqlparser.expression.ExpressionVisitor;
import com.sinosoft.one.sqlparser.expression.Function;
import com.sinosoft.one.sqlparser.expression.InverseExpression;
import com.sinosoft.one.sqlparser.expression.JdbcParameter;
import com.sinosoft.one.sqlparser.expression.LongValue;
import com.sinosoft.one.sqlparser.expression.NullValue;
import com.sinosoft.one.sqlparser.expression.Parenthesis;
import com.sinosoft.one.sqlparser.expression.StringValue;
import com.sinosoft.one.sqlparser.expression.TimeValue;
import com.sinosoft.one.sqlparser.expression.TimestampValue;
import com.sinosoft.one.sqlparser.expression.WhenClause;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.Addition;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.BitwiseAnd;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.BitwiseOr;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.BitwiseXor;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.Concat;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.Division;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.Multiplication;
import com.sinosoft.one.sqlparser.expression.operators.arithmetic.Subtraction;
import com.sinosoft.one.sqlparser.expression.operators.conditional.AndExpression;
import com.sinosoft.one.sqlparser.expression.operators.conditional.OrExpression;
import com.sinosoft.one.sqlparser.expression.operators.relational.Between;
import com.sinosoft.one.sqlparser.expression.operators.relational.EqualsTo;
import com.sinosoft.one.sqlparser.expression.operators.relational.ExistsExpression;
import com.sinosoft.one.sqlparser.expression.operators.relational.ExpressionList;
import com.sinosoft.one.sqlparser.expression.operators.relational.GreaterThan;
import com.sinosoft.one.sqlparser.expression.operators.relational.GreaterThanEquals;
import com.sinosoft.one.sqlparser.expression.operators.relational.InExpression;
import com.sinosoft.one.sqlparser.expression.operators.relational.IsNullExpression;
import com.sinosoft.one.sqlparser.expression.operators.relational.ItemsListVisitor;
import com.sinosoft.one.sqlparser.expression.operators.relational.LikeExpression;
import com.sinosoft.one.sqlparser.expression.operators.relational.Matches;
import com.sinosoft.one.sqlparser.expression.operators.relational.MinorThan;
import com.sinosoft.one.sqlparser.expression.operators.relational.MinorThanEquals;
import com.sinosoft.one.sqlparser.expression.operators.relational.NotEqualsTo;
import com.sinosoft.one.sqlparser.schema.Column;
import com.sinosoft.one.sqlparser.statement.select.SelectVisitor;
import com.sinosoft.one.sqlparser.statement.select.SubSelect;


/**
 * A class to de-parse (that is, tranform from JSqlParser hierarchy into a string)
 * an {@link com.sinosoft.one.sqlparser.expression.Expression}
 */
public class ExpressionDeParser implements ExpressionVisitor, ItemsListVisitor {

    protected StringBuffer buffer;
    protected SelectVisitor selectVisitor;
    protected boolean useBracketsInExprList = true;

    public ExpressionDeParser() {
    }

    /**
     * @param selectVisitor a SelectVisitor to de-parse SubSelects. It has to share the same<br>
     * StringBuffer as this object in order to work, as:
     * <pre>
     * <code>
     * StringBuffer myBuf = new StringBuffer();
     * MySelectDeparser selectDeparser = new  MySelectDeparser();
     * selectDeparser.setBuffer(myBuf);
     * ExpressionDeParser expressionDeParser = new ExpressionDeParser(selectDeparser, myBuf);
     * </code>
     * </pre>
     * @param buffer the buffer that will be filled with the expression
     */
    public ExpressionDeParser(SelectVisitor selectVisitor, StringBuffer buffer) {
        this.selectVisitor = selectVisitor;
        this.buffer = buffer;
    }

    public StringBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(StringBuffer buffer) {
        this.buffer = buffer;
    }

    public void visit(Addition addition) {
        visitBinaryExpression(addition, " + ");
    }

    public void visit(AndExpression andExpression) {
        visitBinaryExpression(andExpression, " AND ");
    }

    public void visit(Between between) {
        between.getLeftExpression().accept(this);
        if (between.isNot())
            buffer.append(" NOT");

        buffer.append(" BETWEEN ");
        between.getBetweenExpressionStart().accept(this);
        buffer.append(" AND ");
        between.getBetweenExpressionEnd().accept(this);

    }

    public void visit(Division division) {
        visitBinaryExpression(division, " / ");

    }

    public void visit(DoubleValue doubleValue) {
        buffer.append(doubleValue.getValue());

    }

    public void visit(EqualsTo equalsTo) {
        visitBinaryExpression(equalsTo, " = ");
    }

    public void visit(GreaterThan greaterThan) {
        visitBinaryExpression(greaterThan, " > ");
    }

    public void visit(GreaterThanEquals greaterThanEquals) {
        visitBinaryExpression(greaterThanEquals, " >= ");

    }

    public void visit(InExpression inExpression) {

        inExpression.getLeftExpression().accept(this);
        if (inExpression.isNot())
            buffer.append(" NOT");
        buffer.append(" IN ");

        inExpression.getItemsList().accept(this);
    }

    public void visit(InverseExpression inverseExpression) {
        buffer.append("-");
        inverseExpression.getExpression().accept(this);
    }

    public void visit(IsNullExpression isNullExpression) {
        isNullExpression.getLeftExpression().accept(this);
        if (isNullExpression.isNot()) {
            buffer.append(" IS NOT NULL");
        } else {
            buffer.append(" IS NULL");
        }
    }

    public void visit(JdbcParameter jdbcParameter) {
        buffer.append("?");

    }

    public void visit(LikeExpression likeExpression) {
        visitBinaryExpression(likeExpression, " LIKE ");

    }

    public void visit(ExistsExpression existsExpression) {
        if (existsExpression.isNot()) {
            buffer.append(" NOT EXISTS ");
        } else {
            buffer.append(" EXISTS ");
        }
        existsExpression.getRightExpression().accept(this);
    }

    public void visit(LongValue longValue) {
        buffer.append(longValue.getStringValue());

    }

    public void visit(MinorThan minorThan) {
        visitBinaryExpression(minorThan, " < ");

    }

    public void visit(MinorThanEquals minorThanEquals) {
        visitBinaryExpression(minorThanEquals, " <= ");

    }

    public void visit(Multiplication multiplication) {
        visitBinaryExpression(multiplication, " * ");

    }

    public void visit(NotEqualsTo notEqualsTo) {
        visitBinaryExpression(notEqualsTo, " <> ");

    }

    public void visit(NullValue nullValue) {
        buffer.append("NULL");

    }

    public void visit(OrExpression orExpression) {
        visitBinaryExpression(orExpression, " OR ");

    }

    public void visit(Parenthesis parenthesis) {
    	if (parenthesis.isNot())
            buffer.append(" NOT ");
    		
        buffer.append("(");
        parenthesis.getExpression().accept(this);
        buffer.append(")");

    }

    public void visit(StringValue stringValue) {
        buffer.append("'" + stringValue.getValue() + "'");

    }

    public void visit(Subtraction subtraction) {
        visitBinaryExpression(subtraction, "-");

    }

    private void visitBinaryExpression(BinaryExpression binaryExpression, String operator) {
        if (binaryExpression.isNot())
            buffer.append(" NOT ");
        binaryExpression.getLeftExpression().accept(this);
        buffer.append(operator);
        binaryExpression.getRightExpression().accept(this);

    }

    public void visit(SubSelect subSelect) {
        buffer.append("(");
        subSelect.getSelectBody().accept(selectVisitor);
        buffer.append(")");
    }

    public void visit(Column tableColumn) {
        String tableName = tableColumn.getTable().getWholeTableName();
        if (tableName != null) {
            buffer.append(tableName + ".");
        }

        buffer.append(tableColumn.getColumnName());
    }

    public void visit(Function function) {
        if (function.isEscaped()) {
            buffer.append("{fn ");
        }

        buffer.append(function.getName());
        if (function.isAllColumns()) {
            buffer.append("(*)");
        } else if (function.getParameters() == null) {
            buffer.append("()");
        } else {
        	boolean oldUseBracketsInExprList = useBracketsInExprList;
            if (function.isDistinct()) {
            	useBracketsInExprList = false;
        		buffer.append("(DISTINCT ");
            }
            visit(function.getParameters());
            useBracketsInExprList = oldUseBracketsInExprList;
            if (function.isDistinct()) {
        		buffer.append(")");
            }
        }

        if (function.isEscaped()) {
            buffer.append("}");
        }

    }

    public void visit(ExpressionList expressionList) {
    	if (useBracketsInExprList)
    		buffer.append("(");
        for (Iterator iter = expressionList.getExpressions().iterator(); iter.hasNext();) {
            Expression expression = (Expression) iter.next();
            expression.accept(this);
            if (iter.hasNext())
                buffer.append(", ");
        }
    	if (useBracketsInExprList)
    		buffer.append(")");
    }


    public SelectVisitor getSelectVisitor() {
        return selectVisitor;
    }

    public void setSelectVisitor(SelectVisitor visitor) {
        selectVisitor = visitor;
    }

    public void visit(DateValue dateValue) {
        buffer.append("{d '" + dateValue.getValue().toString() + "'}");
    }
    public void visit(TimestampValue timestampValue) {
        buffer.append("{ts '" + timestampValue.getValue().toString() + "'}");
    }
    public void visit(TimeValue timeValue) {
        buffer.append("{t '" + timeValue.getValue().toString() + "'}");
    }

	public void visit(CaseExpression caseExpression) {
		buffer.append("CASE ");
		Expression switchExp = caseExpression.getSwitchExpression();
		if( switchExp != null ) {
			switchExp.accept(this);
		}
		
		List clauses = caseExpression.getWhenClauses();
		for (Iterator iter = clauses.iterator(); iter.hasNext();) {
			Expression exp = (Expression) iter.next();
			exp.accept(this);
		}
		
		Expression elseExp = caseExpression.getElseExpression();
		if( elseExp != null ) {
			elseExp.accept(this);
		}
		
		buffer.append(" END");
	}

	public void visit(WhenClause whenClause) {
		buffer.append(" WHEN ");
		whenClause.getWhenExpression().accept(this);
		buffer.append(" THEN ");
		whenClause.getThenExpression().accept(this);
	}

	public void visit(AllComparisonExpression allComparisonExpression) {
		buffer.append(" ALL ");
		allComparisonExpression.GetSubSelect().accept((ExpressionVisitor)this);
	}

	public void visit(AnyComparisonExpression anyComparisonExpression) {
		buffer.append(" ANY ");
		anyComparisonExpression.GetSubSelect().accept((ExpressionVisitor)this);
	}

	public void visit(Concat concat) {
        visitBinaryExpression(concat, " || ");
	}

	public void visit(Matches matches) {
        visitBinaryExpression(matches, " @@ ");
	}

	public void visit(BitwiseAnd bitwiseAnd) {
        visitBinaryExpression(bitwiseAnd, " & ");
	}

	public void visit(BitwiseOr bitwiseOr) {
        visitBinaryExpression(bitwiseOr, " | ");
	}

	public void visit(BitwiseXor bitwiseXor) {
        visitBinaryExpression(bitwiseXor, " ^ ");
	}

}