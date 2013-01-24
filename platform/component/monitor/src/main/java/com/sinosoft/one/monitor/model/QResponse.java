package com.sinosoft.one.monitor.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QResponse is a Querydsl query type for Response
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QResponse extends EntityPathBase<Response> {

    private static final long serialVersionUID = -2103455754;

    public static final QResponse response = new QResponse("response");

    public final StringPath appId = createString("appId");

    public final StringPath averageValue = createString("averageValue");

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath highestValue = createString("highestValue");

    public final StringPath interval = createString("interval");

    public final StringPath isValid = createString("isValid");

    public final StringPath overCount = createString("overCount");

    public final StringPath requestCount = createString("requestCount");

    public final StringPath serialno = createString("serialno");

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final StringPath status = createString("status");

    public final StringPath threshold = createString("threshold");

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public QResponse(String variable) {
        super(Response.class, forVariable(variable));
    }

    public QResponse(Path<? extends Response> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QResponse(PathMetadata<?> metadata) {
        super(Response.class, metadata);
    }

}

