package com.alibaba.druid.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLExprImpl;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLAllExpr;
import com.alibaba.druid.sql.ast.expr.SQLBinaryOpExpr;
import com.alibaba.druid.sql.ast.expr.SQLIdentifierExpr;
import com.alibaba.druid.sql.ast.expr.SQLInSubQueryExpr;
import com.alibaba.druid.sql.ast.expr.SQLPropertyExpr;
import com.alibaba.druid.sql.ast.expr.SQLQueryExpr;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleAlterTableItem;
import com.alibaba.druid.sql.dialect.oracle.parser.OracleLexer;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleOutputVisitor;
import com.alibaba.druid.sql.parser.*;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.alibaba.druid.sql.visitor.SQLASTVisitor;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.util.JdbcUtils;

public class ParserTest {

    public static String getSql() {
        String sql = "SELECT SYSDATE FROM DUAL";
        sql = "select  a.count(1), b.count, c.out from prpduser a , bb b, cc c  where a.usercode != (select 1 from ge_rms_userpower b where a.USERCODE = b.usercode and b.comcode = 11 and b.comcode=222) and a.comcode in (select 1 from ge_rms_userpower b where a.USERCODE = b.usercode and b.comcode = 11 ) and a.comcode in (select 1 from ge_rms_userpower b where a.USERCODE = b.usercode and b.comcode = 11 )";
        sql = "select * "+
                "from "+
                "( select "+
                "this_.USERCODE as USERCODE4_0_, "+
                "this_.ARTICLECODE as ARTICLEC2_4_0_,  "+
                "this_.COMCODE as COMCODE4_0_, "+
                "this_.FLAG as FLAG4_0_, "+
                "this_.NEWUSERCODE as NEWUSERC4_4_0_, "+
                "this_.PASSWDEXPIREDATE as PASSWDEX5_4_0_, "+
                "this_.PASSWDSETDATE as PASSWDSE6_4_0_, "+
                "this_.PASSWORD as PASSWORD4_0_, "+
                "this_.USERNAME as USERNAME4_0_, "+
                "this_.VALIDSTATUS as VALIDSTA9_4_0_  "+
                " from "+
                "(select * "+
                "from "+
                "( select "+
                "this_.USERCODE as USERCODE4_0_, "+
                "this_.ARTICLECODE as ARTICLEC2_4_0_,  "+
                "this_.COMCODE as COMCODE4_0_, "+
                "this_.FLAG as FLAG4_0_, "+
                "this_.NEWUSERCODE as NEWUSERC4_4_0_, "+
                "this_.PASSWDEXPIREDATE as PASSWDEX5_4_0_, "+
                "this_.PASSWDSETDATE as PASSWDSE6_4_0_, "+
                "this_.PASSWORD as PASSWORD4_0_, "+
                "this_.USERNAME as USERNAME4_0_, "+
                "this_.VALIDSTATUS as VALIDSTA9_4_0_  "+
                " from "+
                "GE_RMS_EMPLOYE this_ "+
                "where "+
                "this_.VALIDSTATUS=? ) "+
                "where "+
                "rownum <= 10)"+
                "where "+
                "this_.VALIDSTATUS=? ) TEMP "+
                "where "+
                "rownum <= 10";
        return sql;
    }
    public static void abc(){
        String sql = "SELECT SYSDATE FROM DUAL";
        sql="select  a.count(1) from prpduser a, bbb, ccc  where a.usercode != (select 1 from ge_rms_userpower b where a.USERCODE = b.usercode and b.comcode = 11 and b.comcode=222 ) and a.comcode in (select 1 from ge_rms_userpower b where a.USERCODE = b.usercode and b.comcode = 11 ) and a.comcode in (select 1 from ge_rms_userpower b where a.USERCODE = b.usercode and b.comcode = 11 )";
        sql = "select * "+
                "from "+
                "( select "+
                "this_.USERCODE as USERCODE4_0_, "+
                "this_.ARTICLECODE as ARTICLEC2_4_0_,  "+
                "this_.COMCODE as COMCODE4_0_, "+
                "this_.FLAG as FLAG4_0_, "+
                "this_.NEWUSERCODE as NEWUSERC4_4_0_, "+
                "this_.PASSWDEXPIREDATE as PASSWDEX5_4_0_, "+
                "this_.PASSWDSETDATE as PASSWDSE6_4_0_, "+
                "this_.PASSWORD as PASSWORD4_0_, "+
                "this_.USERNAME as USERNAME4_0_, "+
                "this_.VALIDSTATUS as VALIDSTA9_4_0_  "+
                " from "+
                "(select * "+
                "from "+
                "( select "+
                "this_.USERCODE as USERCODE4_0_, "+
                "this_.ARTICLECODE as ARTICLEC2_4_0_,  "+
                "this_.COMCODE as COMCODE4_0_, "+
                "this_.FLAG as FLAG4_0_, "+
                "this_.NEWUSERCODE as NEWUSERC4_4_0_, "+
                "this_.PASSWDEXPIREDATE as PASSWDEX5_4_0_, "+
                "this_.PASSWDSETDATE as PASSWDSE6_4_0_, "+
                "this_.PASSWORD as PASSWORD4_0_, "+
                "this_.USERNAME as USERNAME4_0_, "+
                "this_.VALIDSTATUS as VALIDSTA9_4_0_  "+
                " from "+
                "GE_RMS_EMPLOYE this_ "+
                "where "+
                "this_.VALIDSTATUS=? ) "+
                "where "+
                "rownum <= 10)"+
                "where "+
                "this_.VALIDSTATUS=? ) TEMP "+
                "where "+
                "rownum <= 10";
        // parser得到AST
        SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, JdbcUtils.ORACLE);
        List<SQLStatement> stmtList = parser.parseStatementList(); //

        // 将AST通过visitor输出
//		SQLASTOutputVisitor visitor = SQLUtils.createFormatOutputVisitor(from, stmtList, JdbcUtils.MYSQL);
//		SQLASTOutputVisitor whereVisitor = SQLUtils.createFormatOutputVisitor(where, stmtList, JdbcUtils.MYSQL);
//		SchemaStatVisitor whereVisitor=SQLUtils.createSchemaStatVisitor(stmtList, JdbcUtils.ORACLE);
//		SchemaStatVisitor visitor=SQLUtils.createSchemaStatVisitor(stmtList, JdbcUtils.ORACLE);
        for (SQLStatement stmt : stmtList) {
//		     stmt.accept(visitor);
            if(stmt instanceof SQLSelectStatement){
                SQLSelectStatement sstmt = (SQLSelectStatement)stmt;
                SQLSelect sqlselect = sstmt.getSelect();
                SQLSelectQueryBlock query = (SQLSelectQueryBlock)sqlselect.getQuery();
                List<String> strs1=new ArrayList<String>();
                getFromTableName(query.getFrom(),strs1);
                getWhereTableName(query.getWhere(),strs1);
            }
        }
    }

    static List<String> getFromTableName(SQLTableSource  sqlTableSource ,List<String>tableNames){
        if(sqlTableSource instanceof SQLSubqueryTableSource){
            SQLSubqueryTableSource sqlSubqueryTableSource=(SQLSubqueryTableSource)sqlTableSource;
            SQLSelectQueryBlock query=(SQLSelectQueryBlock) sqlSubqueryTableSource.getSelect().getQuery();
            getFromTableName(query.getFrom(), tableNames);
            getWhereTableName(query.getWhere(), tableNames);
        }
        if(sqlTableSource instanceof SQLExprTableSource){
            SQLExprTableSource sQLExprTableSource=(SQLExprTableSource)sqlTableSource;
            getWhereTableName(sQLExprTableSource.getExpr(), tableNames);
        }
        return tableNames;
    }
    static List<String> getWhereTableName(SQLExpr sqlExpr ,List<String>tableNames){
        if(sqlExpr instanceof SQLBinaryOpExpr){
            SQLBinaryOpExpr Expr=(SQLBinaryOpExpr)sqlExpr;
            getWhereTableName(Expr.left, tableNames);
            getWhereTableName(Expr.right, tableNames);
        }
        if(sqlExpr instanceof SQLInSubQueryExpr){
            SQLInSubQueryExpr Expr=(SQLInSubQueryExpr)sqlExpr;
            SQLSelect sqlsubselect=Expr.subQuery;
            SQLSelectQueryBlock query = (SQLSelectQueryBlock)sqlsubselect.getQuery();
            System.out.println(query.getFrom().toString());
            getFromTableName(query.getFrom(), tableNames);
        }
        if(sqlExpr instanceof SQLQueryExpr){
            SQLQueryExpr sQLQueryExpr=(SQLQueryExpr) sqlExpr;
            SQLSelect sqlsubselect=sQLQueryExpr.getSubQuery();
            SQLSelectQueryBlock query = (SQLSelectQueryBlock)sqlsubselect.getQuery();
            System.out.println(query.getFrom().toString());
            getFromTableName(query.getFrom(), tableNames);
        }
        if(sqlExpr instanceof SQLIdentifierExpr){
            SQLIdentifierExpr Expr=(SQLIdentifierExpr)sqlExpr;
            tableNames.add(Expr.getName());
        }
        return tableNames;
    }

    static List<String> getSubQueryTableName(SQLSubqueryTableSource sqlSubqueryTableSource,List<String>tableNames){
        SQLSelect sqlSelect=sqlSubqueryTableSource.getSelect();
        SQLSelectQueryBlock query = (SQLSelectQueryBlock)sqlSelect.getQuery();
        getFromTableName(query.getFrom(), tableNames);
        getWhereTableName(query.getWhere(),tableNames);
        return tableNames;
    }


    static void getSelectList(String sql) {
        SQLStatementParser parser = SQLParserUtils.createSQLStatementParser(sql, JdbcUtils.ORACLE);
        List<SQLStatement> stmtList = parser.parseStatementList();
        SQLASTVisitor visitor = new MySQLASTVisitor();
        StringBuilder out = new StringBuilder();
        SQLASTVisitor outVisitor = new OracleOutputVisitor(out);
        for(SQLStatement statement : stmtList) {
            statement.accept(visitor);
            statement.accept(outVisitor);
        }
        System.out.println(out);
//        parser.createSQLSelectParser().select().accept(new MySQLASTVisitor());
    }
    public static void main(String[] args) {
//        abc();
        String sql = getSql();
        System.out.println(sql);
        getSelectList(getSql());
    }
}
