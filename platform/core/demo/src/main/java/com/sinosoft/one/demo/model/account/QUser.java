package com.sinosoft.one.demo.model.account;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 278979380;

    public static final QUser user = new QUser("user");

    public final com.sinosoft.one.demo.model.QIdEntity _super = new com.sinosoft.one.demo.model.QIdEntity(this);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath email = createString("email");

    public final ListPath<Group, QGroup> groupList = this.<Group, QGroup>createList("groupList", Group.class, QGroup.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath loginName = createString("loginName");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUser(PathMetadata<?> metadata) {
        super(User.class, metadata);
    }

}

