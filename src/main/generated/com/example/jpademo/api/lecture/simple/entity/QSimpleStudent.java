package com.example.jpademo.api.lecture.simple.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSimpleStudent is a Querydsl query type for SimpleStudent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSimpleStudent extends EntityPathBase<SimpleStudent> {

    private static final long serialVersionUID = -400966123L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSimpleStudent simpleStudent = new QSimpleStudent("simpleStudent");

    public final QSimpleLecture lecture;

    public final StringPath name = createString("name");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QSimpleStudent(String variable) {
        this(SimpleStudent.class, forVariable(variable), INITS);
    }

    public QSimpleStudent(Path<? extends SimpleStudent> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSimpleStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSimpleStudent(PathMetadata metadata, PathInits inits) {
        this(SimpleStudent.class, metadata, inits);
    }

    public QSimpleStudent(Class<? extends SimpleStudent> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new QSimpleLecture(forProperty("lecture")) : null;
    }

}

