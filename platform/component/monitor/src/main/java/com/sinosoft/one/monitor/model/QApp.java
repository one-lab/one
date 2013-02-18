package com.sinosoft.one.monitor.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QApp is a Querydsl query type for App
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QApp extends EntityPathBase<App> {

    private static final long serialVersionUID = -756711092;

    public static final QApp app = new QApp("app");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath status = createString("status");

    public QApp(String variable) {
        super(App.class, forVariable(variable));
    }

    public QApp(Path<? extends App> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QApp(PathMetadata<?> metadata) {
        super(App.class, metadata);
    }

}

