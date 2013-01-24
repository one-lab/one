package com.sinosoft.one.monitor.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QWarn is a Querydsl query type for Warn
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QWarn extends EntityPathBase<Warn> {

    private static final long serialVersionUID = -1982566213;

    public static final QWarn warn = new QWarn("warn");

    public final StringPath appId = createString("appId");

    public final StringPath content = createString("content");

    public final StringPath grade = createString("grade");

    public final StringPath id = createString("id");

    public final StringPath module = createString("module");

    public final DateTimePath<java.util.Date> occurdate = createDateTime("occurdate", java.util.Date.class);

    public final StringPath remark = createString("remark");

    public final StringPath sendemail = createString("sendemail");

    public final StringPath sendsms = createString("sendsms");

    public final StringPath title = createString("title");

    public QWarn(String variable) {
        super(Warn.class, forVariable(variable));
    }

    public QWarn(Path<? extends Warn> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QWarn(PathMetadata<?> metadata) {
        super(Warn.class, metadata);
    }

}

