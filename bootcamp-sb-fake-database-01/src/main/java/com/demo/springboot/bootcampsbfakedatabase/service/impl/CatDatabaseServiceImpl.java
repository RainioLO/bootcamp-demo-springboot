package com.demo.springboot.bootcampsbfakedatabase.service.impl;

import org.springframework.stereotype.Service;
import com.demo.springboot.bootcampsbfakedatabase.database.CatDatabases;
import com.demo.springboot.bootcampsbfakedatabase.model.Cat;
import com.demo.springboot.bootcampsbfakedatabase.service.CatDatabaseService;

@Service // similar to Controller
// ComponentScan will scan it and create an object of the class, put it into spring context (like the box)
public class CatDatabaseServiceImpl implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  // Controller call service layer, service call database or api

  @Override
  public Cat getCat(int index) {
    return CatDatabases.getCat(index);
  }

  @Override
  public Cat setCat(int index, Cat cat) {
    return CatDatabases.setCat(index, cat);
  }

  @Override
  public Cat deleteCat(int index) {
    Cat deleted = getCat(index);
    if (deleted == null)
      return null;
    setCat(index, null);
    return deleted;
  }

  @Override
  public Cat updateCat(int index, Cat cat) {
    if (getCat(index) == null)
      return null;
    return setCat(index, cat);
  }

  @Override
  public Cat patchCatName(int index, String name) {
    Cat cat = getCat(index);
    if (cat == null)
      return null;
    cat.setName(name);
    return cat;
  }

  @Override
  public Cat patchCatAge(int index, int age) {
    Cat cat = getCat(index);
    if (cat == null)
      return null;
    cat.setAge(age);
    return cat;
  }


}
