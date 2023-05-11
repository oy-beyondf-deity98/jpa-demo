package com.example.jpademo.api.lecture.mapping.repository.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMappingStudent is a Querydsl query type for MappingStudent
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMappingStudent extends EntityPathBase<MappingStudent> {

    private static final long serialVersionUID = 287851097L;

    public static final QMappingStudent mappingStudent = new QMappingStudent("mappingStudent");

    public final StringPath name = createString("name");

    public final NumberPath<Long> seq = createNumber("seq", Long.class);

    public QMappingStudent(String variable) {
        super(MappingStudent.class, forVariable(variable));
    }

    public QMappingStudent(Path<? extends MappingStudent> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMappingStudent(PathMetadata metadata) {
        super(MappingStudent.class, metadata);
    }

}

