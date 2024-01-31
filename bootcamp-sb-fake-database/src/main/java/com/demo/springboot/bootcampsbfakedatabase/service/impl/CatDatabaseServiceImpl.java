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
  public Cat getFromStaticMemory(int index) {
    return CatDatabases.getCat(index);
  }

  @Override
  public Cat setCatToStaticMemory(int index, Cat cat) {
    CatDatabases.setCat(index, cat);
    return cat;
  }

}
