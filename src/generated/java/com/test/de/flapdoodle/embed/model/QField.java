package com.test.de.flapdoodle.embed.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QField is a Querydsl query type for Field
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QField extends EntityPathBase<Field> {

    private static final long serialVersionUID = 1565279838L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QField field = new QField("field");

    public final org.bson.types.QObjectId id;

    public final MapPath<String, java.io.Serializable, SimplePath<java.io.Serializable>> simplifiedProperties = this.<String, java.io.Serializable, SimplePath<java.io.Serializable>>createMap("simplifiedProperties", String.class, java.io.Serializable.class, SimplePath.class);

    public QField(String variable) {
        this(Field.class, forVariable(variable), INITS);
    }

    public QField(Path<? extends Field> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QField(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QField(PathMetadata metadata, PathInits inits) {
        this(Field.class, metadata, inits);
    }

    public QField(Class<? extends Field> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

