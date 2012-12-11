package com.sinosoft.one.demo.model;


import static com.mysema.query.types.PathMetadataFactory.*;
import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QIdEntity is a Querydsl query type for IdEntity
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QIdEntity extends EntityPathBase<IdEntity> {

    private static final long serialVersionUID = -1504602842;

    public static final QIdEntity idEntity = new QIdEntity("idEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QIdEntity(String variable) {
        super(IdEntity.class, forVariable(variable));
    }

    public QIdEntity(Path<? extends IdEntity> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QIdEntity(PathMetadata<?> metadata) {
        super(IdEntity.class, metadata);
    }

}

