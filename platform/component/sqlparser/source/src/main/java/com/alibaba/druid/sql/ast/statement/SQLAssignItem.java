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
package com.alibaba.druid.sql.ast.statement;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLObjectImpl;
import com.alibaba.druid.sql.visitor.SQLASTVisitor;

public class SQLAssignItem extends SQLObjectImpl {

    private static final long serialVersionUID = 1L;

    private SQLExpr           target;
    private SQLExpr           value;

    public SQLAssignItem(){
    }

    public SQLAssignItem(SQLExpr target, SQLExpr value){
        this.target = target;
        this.value = value;
    }

    public SQLExpr getTarget() {
        return target;
    }

    public void setTarget(SQLExpr target) {
        this.target = target;
    }

    public SQLExpr getValue() {
        return value;
    }

    public void setValue(SQLExpr value) {
        this.value = value;
    }

    public void output(StringBuffer buf) {
        target.output(buf);
        buf.append(" = ");
        value.output(buf);
    }


    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            acceptChild(visitor, this.target);
            acceptChild(visitor, this.value);
        }
        visitor.endVisit(this);
    }

}