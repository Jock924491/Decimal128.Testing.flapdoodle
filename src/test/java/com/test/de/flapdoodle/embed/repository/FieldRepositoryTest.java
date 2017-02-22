package com.test.de.flapdoodle.embed.repository;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.test.de.flapdoodle.embed.model.Field;
import org.bson.types.Decimal128;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
public class FieldRepositoryTest
{
  private static final Expression path = new PathBuilder<>(Field.class, "field").get("simplifiedProperties.Field1");
  @Autowired
  private FieldRepository fieldRepository;

  @After
  public void tearDown() throws Exception
  {
    fieldRepository.deleteAll();
  }

  /**
   * Works correctly
   */
  @Test
  public void testPredicateEq()
  {
    List<Field> fields = fieldRepository.save(Arrays.<Field>asList(
        new Field(ImmutableMap.<String, Serializable>builder().put("Field1", "timmah").build()),
        new Field(ImmutableMap.<String, Serializable>builder().put("Field1", "not timmah").build())
    ));
    Predicate search = Expressions.predicate(Ops.EQ, path, Expressions.constant("timmah"));
    List<Field> outputFields = Lists.newArrayList(fieldRepository.findAll(search));

    assertEquals(1, outputFields.size());
    assertThat(outputFields, hasItems(fields.get(1)));
  }

  /**
   * Fails on connection to DB
   */
  @Test
  public void testPredicateGOE()
  {
    List<Field> fields = fieldRepository.save(Arrays.<Field>asList(
        new Field(ImmutableMap.<String, Serializable>builder().put("Field1", Decimal128.parse("5000")).build()),
        new Field(ImmutableMap.<String, Serializable>builder().put("Field1", Decimal128.parse("4999")).build())
    ));
    Predicate search = Expressions.predicate(Ops.GOE, path, Expressions.constant(Decimal128.parse("5000")));
    List<Field> outputFields = Lists.newArrayList(fieldRepository.findAll(search));

    assertEquals(1, outputFields.size());
    assertThat(outputFields, hasItems(fields.get(1)));
  }
}