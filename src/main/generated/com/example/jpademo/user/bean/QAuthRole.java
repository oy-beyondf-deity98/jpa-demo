package com.example.jpademo.user.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAuthRole is a Querydsl query type for AuthRole
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthRole extends EntityPathBase<AuthRole> {

    private static final long serialVersionUID = 230502458L;

    public static final QAuthRole authRole = new QAuthRole("authRole");

    public final StringPath role = createString("role");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QAuthRole(String variable) {
        super(AuthRole.class, forVariable(variable));
    }

    public QAuthRole(Path<? extends AuthRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuthRole(PathMetadata metadata) {
        super(AuthRole.class, metadata);
    }

}

