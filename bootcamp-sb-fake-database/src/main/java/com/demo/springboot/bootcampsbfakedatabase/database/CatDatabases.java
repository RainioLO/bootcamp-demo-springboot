package com.demo.springboot.bootcampsbfakedatabase.database;

import com.demo.springboot.bootcampsbfakedatabase.model.Cat;

public class CatDatabases {

  private static Cat[] cats;

  private static final int dbLength = 10;

  static { // static block
    cats = new Cat[10];
    cats[0] = new Cat("John", 2);
    cats[1] = new Cat("Mary", 1);
  }

  public static Cat getCat(int index) { // enclasulaion, through this public method to touch the private attributes.
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException(); // throw exception
    return cats[index];
  }

  public static Cat setCat(int index, Cat cat) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException(); // throw exception
    cats[index] = cat;
    return cat;
  }


}
