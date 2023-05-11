package com.example.jpademo.api.lecture.mapping.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMappingApplyingClass is a Querydsl query type for MappingApplyingClass
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMappingApplyingClass extends EntityPathBase<MappingApplyingClass> {

    private static final long serialVersionUID = 746825154L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMappingApplyingClass mappingApplyingClass = new QMappingApplyingClass("mappingApplyingClass");

    public final QMappingClass mappingClass;

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public final QMappingStudent student;

    public QMappingApplyingClass(String variable) {
        this(MappingApplyingClass.class, forVariable(variable), INITS);
    }

    public QMappingApplyingClass(Path<? extends MappingApplyingClass> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMappingApplyingClass(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMappingApplyingClass(PathMetadata metadata, PathInits inits) {
        this(MappingApplyingClass.class, metadata, inits);
    }

    public QMappingApplyingClass(Class<? extends MappingApplyingClass> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mappingClass = inits.isInitialized("mappingClass") ? new QMappingClass(forProperty("mappingClass"), inits.get("mappingClass")) : null;
        this.student = inits.isInitialized("student") ? new QMappingStudent(forProperty("student")) : null;
    }

}

