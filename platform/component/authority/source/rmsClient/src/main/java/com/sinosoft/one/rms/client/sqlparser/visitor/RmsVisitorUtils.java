package com.sinosoft.one.rms.client.sqlparser.visitor;

import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLJoinTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-8
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public final class RmsVisitorUtils {
    private RmsVisitorUtils() {}
    public static boolean visit(SQLSelectQueryBlock x) {
        Map<String, String> tableAlias = new HashMap<String, String>();

        if (x.getFrom() instanceof SQLExprTableSource) {
            recordTableSource((SQLExprTableSource)x.getFrom(), tableAlias);
        } else if(x.getFrom() instanceof SQLJoinTableSource) {
            SQLJoinTableSource tableSource = (SQLJoinTableSource)x.getFrom();
            doSQLJoinTableSource(tableSource, tableAlias);
        }

        List<SQLSelectItem> sqlSelectItems = x.getSelectList();
        if(sqlSelectItems.size() > 1 || !sqlSelectItems.get(0).equals("*")) {
            Set<String> tableAliasSet = new HashSet<String>();
            for(SQLSelectItem item : sqlSelectItems) {
                String itemExpr = item.getExpr().toString();
                String[] itemExprParts = itemExpr.split("\\.");
                if(itemExpr.length() == 2) {
                    tableAliasSet.add(itemExprParts[0]);
                }
            }

            if(!tableAliasSet.isEmpty()) {
                Set<String> tableAliasKeys = tableAlias.keySet();
                Iterator<String> tableAliasKeysIt = tableAliasKeys.iterator();
                while(tableAliasKeysIt.hasNext()) {
                    String aTableAlias = tableAliasKeysIt.next();
                    if(!tableAliasSet.contains(aTableAlias)) {
                        tableAliasKeysIt.remove();
                    }
                }
            }
        }

        displayTableAlias(tableAlias);

//        SQLExpr whereExpr = x.getWhere();
//        SQLBinaryOpExpr sqlBinaryOpExpr = (SQLBinaryOpExpr)whereExpr;
//        SQLBinaryOpExpr mySqlBinaryOpExpr = new SQLBinaryOpExpr();
//        mySqlBinaryOpExpr.setLeft(sqlBinaryOpExpr);
//        SQLExprParser exprParser = new SQLExprParser("AGE=(select age from ddd where id=1)");
//        mySqlBinaryOpExpr.setRight(exprParser.expr());
//        mySqlBinaryOpExpr.setOperator(SQLBinaryOperator.BooleanAnd);
//        x.setWhere(mySqlBinaryOpExpr);
        return true;
    }

    private static void displayTableAlias(Map<String, String> tableAlias) {
        for(String key : tableAlias.keySet()) {
            System.out.println(key + ":" + tableAlias.get(key));
        }
    }
    private static void doSQLJoinTableSource(SQLJoinTableSource tableSource, Map<String, String> tableAlias) {
        if (tableSource.getLeft() instanceof SQLExprTableSource) {
            recordTableSource((SQLExprTableSource)tableSource.getLeft(), tableAlias);
        }
        if (tableSource.getRight() instanceof SQLExprTableSource) {
            recordTableSource((SQLExprTableSource)tableSource.getRight(), tableAlias);
        }
        if (tableSource.getRight() instanceof SQLJoinTableSource) {
            doSQLJoinTableSource((SQLJoinTableSource)tableSource.getRight(), tableAlias);
        }
    }

    private static void recordTableSource(SQLExprTableSource x, Map<String, String> tableAlias) {
        if (x.getExpr() instanceof SQLIdentifierExpr) {
            String tableName = ((SQLIdentifierExpr) x.getExpr()).getName();
            String alias = x.getAlias();
            if (alias != null) {
                tableAlias.put(alias, tableName);
            }
        }
    }
}
