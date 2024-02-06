package com.vtxlab.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

public class Cat {

  private String name;
  private int age;

  public Cat(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

}
