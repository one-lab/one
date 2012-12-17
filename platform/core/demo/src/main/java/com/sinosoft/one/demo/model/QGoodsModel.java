package com.sinosoft.one.demo.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QGoodsModel is a Querydsl query type for GoodsModel
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGoodsModel extends EntityPathBase<GoodsModel> {

    private static final long serialVersionUID = -984621125;

    public static final QGoodsModel goodsModel = new QGoodsModel("goodsModel");

    public final NumberPath<Integer> amountNow = createNumber("amountNow", Integer.class);

    public final StringPath goodsName = createString("goodsName");

    public final StringPath id = createString("id");

    public final DateTimePath<java.util.Date> receivingDate = createDateTime("receivingDate", java.util.Date.class);

    public final StringPath receivingPerson = createString("receivingPerson");

    public final StringPath sortId = createString("sortId");

    public final StringPath stockPerson = createString("stockPerson");

    public QGoodsModel(String variable) {
        super(GoodsModel.class, forVariable(variable));
    }

    public QGoodsModel(Path<? extends GoodsModel> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QGoodsModel(PathMetadata<?> metadata) {
        super(GoodsModel.class, metadata);
    }

}

