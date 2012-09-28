package com.sinosoft.one.demo.model.account;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserInfo extends EntityPathBase<UserInfo> {

    private static final long serialVersionUID = 1115095554;

    public static final QUserInfo userInfo = new QUserInfo("userInfo");

    public final com.sinosoft.one.demo.model.QIdEntity _super = new com.sinosoft.one.demo.model.QIdEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath idcode = createString("idcode");

    public final StringPath phone = createString("phone");

    public final StringPath strGender = createString("strGender");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUserInfo(String variable) {
        super(UserInfo.class, forVariable(variable));
    }

    public QUserInfo(Path<? extends UserInfo> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUserInfo(PathMetadata<?> metadata) {
        super(UserInfo.class, metadata);
    }

}

