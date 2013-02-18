package com.sinosoft.one.monitor.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QMailinfo is a Querydsl query type for Mailinfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMailinfo extends EntityPathBase<Mailinfo> {

    private static final long serialVersionUID = -1772784998;

    public static final QMailinfo mailinfo = new QMailinfo("mailinfo");

    public final StringPath content = createString("content");

    public final StringPath filepath = createString("filepath");

    public final StringPath id = createString("id");

    public final StringPath sendto = createString("sendto");

    public final StringPath subject = createString("subject");

    public QMailinfo(String variable) {
        super(Mailinfo.class, forVariable(variable));
    }

    public QMailinfo(Path<? extends Mailinfo> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QMailinfo(PathMetadata<?> metadata) {
        super(Mailinfo.class, metadata);
    }

}

