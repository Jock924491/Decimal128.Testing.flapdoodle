package com.test.de.flapdoodle.embed.repository;

import com.test.de.flapdoodle.embed.model.Field;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends MongoRepository<Field, String>, QueryDslPredicateExecutor<Field>
{
}
