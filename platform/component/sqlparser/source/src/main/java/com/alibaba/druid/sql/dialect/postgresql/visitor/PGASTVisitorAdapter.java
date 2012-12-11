/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.sql.dialect.postgresql.visitor;

import com.alibaba.druid.sql.dialect.postgresql.ast.PGAggregateExpr;
import com.alibaba.druid.sql.dialect.postgresql.ast.PGWithClause;
import com.alibaba.druid.sql.dialect.postgresql.ast.PGWithQuery;
import com.alibaba.druid.sql.dialect.postgresql.ast.expr.PGAnalytic;
import com.alibaba.druid.sql.dialect.postgresql.ast.expr.PGParameter;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGDeleteStatement;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGFunctionTableSource;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGInsertStatement;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.FetchClause;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.ForClause;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.WindowClause;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectStatement;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGTruncateStatement;
import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGUpdateStatement;
import com.alibaba.druid.sql.visitor.SQLASTVisitorAdapter;

public class PGASTVisitorAdapter extends SQLASTVisitorAdapter implements PGASTVisitor {


    public void endVisit(WindowClause x) {

    }


    public boolean visit(WindowClause x) {

        return true;
    }


    public void endVisit(FetchClause x) {

    }


    public boolean visit(FetchClause x) {

        return true;
    }


    public void endVisit(ForClause x) {

    }


    public boolean visit(ForClause x) {

        return true;
    }


    public void endVisit(PGWithQuery x) {

    }


    public boolean visit(PGWithQuery x) {

        return true;
    }


    public void endVisit(PGWithClause x) {

    }


    public boolean visit(PGWithClause x) {

        return true;
    }


    public void endVisit(PGTruncateStatement x) {

    }


    public boolean visit(PGTruncateStatement x) {

        return true;
    }


    public void endVisit(PGDeleteStatement x) {

    }


    public boolean visit(PGDeleteStatement x) {

        return true;
    }


    public void endVisit(PGInsertStatement x) {

    }


    public boolean visit(PGInsertStatement x) {
        return true;
    }


    public void endVisit(PGSelectStatement x) {

    }


    public boolean visit(PGSelectStatement x) {
        return true;
    }


    public void endVisit(PGUpdateStatement x) {

    }


    public boolean visit(PGUpdateStatement x) {
        return true;
    }


    public void endVisit(PGSelectQueryBlock x) {

    }


    public boolean visit(PGSelectQueryBlock x) {
        return true;
    }


    public void endVisit(PGAggregateExpr x) {
    }


    public boolean visit(PGAggregateExpr x) {
        return true;
    }


    public void endVisit(PGAnalytic x) {
    }


    public boolean visit(PGAnalytic x) {

        return true;
    }


    public void endVisit(PGParameter x) {

    }


    public boolean visit(PGParameter x) {
        return true;
    }


    public void endVisit(PGFunctionTableSource x) {

    }


    public boolean visit(PGFunctionTableSource x) {
        return true;
    }

}
