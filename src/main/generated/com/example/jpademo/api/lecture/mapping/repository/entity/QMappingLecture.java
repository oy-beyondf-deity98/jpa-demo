package com.example.jpademo.api.lecture.mapping.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMappingLecture is a Querydsl query type for MappingLecture
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMappingLecture extends EntityPathBase<MappingLecture> {

    private static final long serialVersionUID = -2075275876L;

    public static final QMappingLecture mappingLecture = new QMappingLecture("mappingLecture");

    public final StringPath name = createString("name");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QMappingLecture(String variable) {
        super(MappingLecture.class, forVariable(variable));
    }

    public QMappingLecture(Path<? extends MappingLecture> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMappingLecture(PathMetadata metadata) {
        super(MappingLecture.class, metadata);
    }

}

