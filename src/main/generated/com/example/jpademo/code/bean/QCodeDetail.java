package com.example.jpademo.code.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCodeDetail is a Querydsl query type for CodeDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeDetail extends EntityPathBase<CodeDetail> {

    private static final long serialVersionUID = 1874521532L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCodeDetail codeDetail = new QCodeDetail("codeDetail");

    public final QCommonCode commonCode;

    public final StringPath descript = createString("descript");

    public final StringPath detailCode = createString("detailCode");

    public final StringPath detailCodeName = createString("detailCodeName");

    public final NumberPath<Integer> orderNum = createNumber("orderNum", Integer.class);

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QCodeDetail(String variable) {
        this(CodeDetail.class, forVariable(variable), INITS);
    }

    public QCodeDetail(Path<? extends CodeDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCodeDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCodeDetail(PathMetadata metadata, PathInits inits) {
        this(CodeDetail.class, metadata, inits);
    }

    public QCodeDetail(Class<? extends CodeDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commonCode = inits.isInitialized("commonCode") ? new QCommonCode(forProperty("commonCode")) : null;
    }

}

