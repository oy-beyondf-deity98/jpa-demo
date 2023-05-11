package com.example.jpademo.api.lecture.simple.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSimpleLecture is a Querydsl query type for SimpleLecture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSimpleLecture extends EntityPathBase<SimpleLecture> {

    private static final long serialVersionUID = 1530874200L;

    public static final QSimpleLecture simpleLecture = new QSimpleLecture("simpleLecture");

    public final StringPath name = createString("name");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final ListPath<SimpleStudent, QSimpleStudent> studentList = this.<SimpleStudent, QSimpleStudent>createList("studentList", SimpleStudent.class, QSimpleStudent.class, PathInits.DIRECT2);

    public QSimpleLecture(String variable) {
        super(SimpleLecture.class, forVariable(variable));
    }

    public QSimpleLecture(Path<? extends SimpleLecture> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimpleLecture(PathMetadata metadata) {
        super(SimpleLecture.class, metadata);
    }

}

