package com.sinosoft.one.demo.model.account;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QGroup is a Querydsl query type for Group
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGroup extends EntityPathBase<Group> {

    private static final long serialVersionUID = 45476918;

    public static final QGroup group = new QGroup("group1");

    public final com.sinosoft.one.demo.model.QIdEntity _super = new com.sinosoft.one.demo.model.QIdEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final ListPath<String, StringPath> permissionList = this.<String, StringPath>createList("permissionList", String.class, StringPath.class);

    public QGroup(String variable) {
        super(Group.class, forVariable(variable));
    }

    public QGroup(Path<? extends Group> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QGroup(PathMetadata<?> metadata) {
        super(Group.class, metadata);
    }

}

