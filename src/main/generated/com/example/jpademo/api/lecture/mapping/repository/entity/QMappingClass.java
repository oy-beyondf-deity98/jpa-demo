package com.example.jpademo.api.lecture.mapping.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMappingClass is a Querydsl query type for MappingClass
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMappingClass extends EntityPathBase<MappingClass> {

    private static final long serialVersionUID = 937220374L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMappingClass mappingClass = new QMappingClass("mappingClass");

    public final NumberPath<Integer> classTime = createNumber("classTime", Integer.class);

    public final StringPath endTime = createString("endTime");

    public final QMappingLecture lecture;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final StringPath startTime = createString("startTime");

    public QMappingClass(String variable) {
        this(MappingClass.class, forVariable(variable), INITS);
    }

    public QMappingClass(Path<? extends MappingClass> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMappingClass(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMappingClass(PathMetadata metadata, PathInits inits) {
        this(MappingClass.class, metadata, inits);
    }

    public QMappingClass(Class<? extends MappingClass> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lecture = inits.isInitialized("lecture") ? new QMappingLecture(forProperty("lecture")) : null;
    }

}

