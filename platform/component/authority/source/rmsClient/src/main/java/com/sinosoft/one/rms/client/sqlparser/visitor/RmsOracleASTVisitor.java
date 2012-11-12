package com.sinosoft.one.rms.client.sqlparser.visitor;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleSelectQueryBlock;
import com.alibaba.druid.sql.dialect.oracle.visitor.OracleASTVisitorAdapter;
import com.sinosoft.one.rms.client.DataRuleFactoryPostProcessor;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-11-8
 * Time: 下午6:10
 * To change this template use File | Settings | File Templates.
 */
public class RmsOracleASTVisitor extends OracleASTVisitorAdapter {
	private DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor;
	
	public RmsOracleASTVisitor(DataRuleFactoryPostProcessor dataRuleFactoryPostProcessor){
		this.dataRuleFactoryPostProcessor=dataRuleFactoryPostProcessor;
	}
    public boolean visit(OracleSelectQueryBlock x) {
        return RmsSQLASTVisitorSupport.visit(x,dataRuleFactoryPostProcessor);
    }
}
