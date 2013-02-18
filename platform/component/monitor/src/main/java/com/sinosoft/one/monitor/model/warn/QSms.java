package com.sinosoft.one.monitor.model.warn;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QSms is a Querydsl query type for Sms
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSms extends EntityPathBase<Sms> {

    private static final long serialVersionUID = -756693884;

    public static final QSms sms = new QSms("sms");

    public final StringPath appId = createString("appId");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath id = createString("id");

    public final StringPath owner = createString("owner");

    public final StringPath phoneNo = createString("phoneNo");

    public final StringPath remark = createString("remark");

    public final StringPath statu = createString("statu");

    public QSms(String variable) {
        super(Sms.class, forVariable(variable));
    }

    public QSms(Path<? extends Sms> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QSms(PathMetadata<?> metadata) {
        super(Sms.class, metadata);
    }

}

