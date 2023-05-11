package com.example.jpademo.user.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuthUserRole is a Querydsl query type for AuthUserRole
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuthUserRole extends EntityPathBase<AuthUserRole> {

    private static final long serialVersionUID = -1895878491L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAuthUserRole authUserRole = new QAuthUserRole("authUserRole");

    public final QAuthRole role;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final QAuthUser user;

    public final StringPath userPassword = createString("userPassword");

    public QAuthUserRole(String variable) {
        this(AuthUserRole.class, forVariable(variable), INITS);
    }

    public QAuthUserRole(Path<? extends AuthUserRole> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAuthUserRole(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAuthUserRole(PathMetadata metadata, PathInits inits) {
        this(AuthUserRole.class, metadata, inits);
    }

    public QAuthUserRole(Class<? extends AuthUserRole> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.role = inits.isInitialized("role") ? new QAuthRole(forProperty("role")) : null;
        this.user = inits.isInitialized("user") ? new QAuthUser(forProperty("user")) : null;
    }

}

