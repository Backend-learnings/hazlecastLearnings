package com.example.hazlecastEmployee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.lang.annotation.Documented;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class HazlecastEmployee implements Serializable {
  private static final long serialVersionUID = -7029649029299284733L;

  @Id
  private int id;
  private String name;
  private int age;
}
