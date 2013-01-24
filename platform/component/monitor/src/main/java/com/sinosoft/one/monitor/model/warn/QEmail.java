package com.sinosoft.one.monitor.model.warn;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QEmail is a Querydsl query type for Email
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEmail extends EntityPathBase<Email> {

    private static final long serialVersionUID = -1346292729;

    public static final QEmail email = new QEmail("email");

    public final StringPath address = createString("address");

    public final StringPath appId = createString("appId");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath descript = createString("descript");

    public final StringPath id = createString("id");

    public final StringPath owner = createString("owner");

    public final StringPath remark = createString("remark");

    public final StringPath statu = createString("statu");

    public QEmail(String variable) {
        super(Email.class, forVariable(variable));
    }

    public QEmail(Path<? extends Email> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QEmail(PathMetadata<?> metadata) {
        super(Email.class, metadata);
    }

}

