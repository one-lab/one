package com.sinosoft.one.monitor.application.model;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.DateTimePath;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QUrl is a Querydsl query type for Url
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUrl extends EntityPathBase<Url> {

    private static final long serialVersionUID = 907827696;

    public static final QUrl url1 = new QUrl("url1");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath creatorId = createString("creatorId");

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final StringPath modifierId = createString("modifierId");

    public final DateTimePath<java.util.Date> modifyTime = createDateTime("modifyTime", java.util.Date.class);

    public final StringPath status = createString("status");

    public final NumberPath<Integer> threshold = createNumber("threshold", Integer.class);

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

