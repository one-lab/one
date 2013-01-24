package com.sinosoft.one.monitor.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUrl is a Querydsl query type for Url
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUrl extends EntityPathBase<Url> {

    private static final long serialVersionUID = -756691814;

    public static final QUrl url1 = new QUrl("url1");

    public final StringPath appid = createString("appid");

    public final StringPath grade = createString("grade");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath status = createString("status");

    public final NumberPath<java.math.BigDecimal> threshold = createNumber("threshold", java.math.BigDecimal.class);

    public final StringPath url = createString("url");

    public QUrl(String variable) {
        super(Url.class, forVariable(variable));
    }

    public QUrl(Path<? extends Url> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUrl(PathMetadata<?> metadata) {
        super(Url.class, metadata);
    }

}

