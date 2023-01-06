package com.example.hazlecastEmployee.utils;

import com.example.hazlecastEmployee.entity.HazlecastEmployee;

import java.util.Objects;

public class TestUtils {
  public static final Object failureResponse = null;

//  public static successResponse
  public static HazlecastEmployee getObject() {
    return HazlecastEmployee.builder().age(23).id(44).name("vairam").build();
  }
}
