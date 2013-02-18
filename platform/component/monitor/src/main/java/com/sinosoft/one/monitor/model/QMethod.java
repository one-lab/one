package com.sinosoft.one.monitor.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QMethod is a Querydsl query type for Method
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMethod extends EntityPathBase<Method> {

    private static final long serialVersionUID = 1436808662;

    public static final QMethod method = new QMethod("method");

    public final StringPath appId = createString("appId");

    public final StringPath className = createString("className");

    public final StringPath environment = createString("environment");

    public final StringPath id = createString("id");

    public final StringPath interval = createString("interval");

    public final StringPath methodName = createString("methodName");

    public final StringPath status = createString("status");

    public final NumberPath<java.math.BigDecimal> threshold = createNumber("threshold", java.math.BigDecimal.class);

    public QMethod(String variable) {
        super(Method.class, forVariable(variable));
    }

    public QMethod(Path<? extends Method> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QMethod(PathMetadata<?> metadata) {
        super(Method.class, metadata);
    }

}

