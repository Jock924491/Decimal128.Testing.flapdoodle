package com.test.de.flapdoodle.embed.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Document
public class Field
{
  @Id
  private ObjectId id;
  private Map<String, Serializable> simplifiedProperties;

  public Field()
  {
  }

  public Field(Map<String, Serializable> simplifiedProperties)
  {
    this.simplifiedProperties = simplifiedProperties;
  }

  public Field(ObjectId id, Map<String, Serializable> simplifiedProperties)
  {
    this.id = id;
    this.simplifiedProperties = simplifiedProperties;
  }

  public ObjectId getId()
  {
    return id;
  }

  public void setId(ObjectId id)
  {
    this.id = id;
  }

  public Map<String, Serializable> getSimplifiedProperties()
  {
    return simplifiedProperties;
  }

  public void setSimplifiedProperties(Map<String, Serializable> simplifiedProperties)
  {
    this.simplifiedProperties = simplifiedProperties;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Field field = (Field) o;

    return Objects.equals(field.getId(), ((Field) o).getId())
        && Objects.equals(field.getSimplifiedProperties(), ((Field) o).getSimplifiedProperties());

  }

  @Override
  public int hashCode()
  {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (simplifiedProperties != null ? simplifiedProperties.hashCode() : 0);
    return result;
  }
}