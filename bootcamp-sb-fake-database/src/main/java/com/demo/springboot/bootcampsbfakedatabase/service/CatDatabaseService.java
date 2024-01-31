package com.demo.springboot.bootcampsbfakedatabase.service;

import com.demo.springboot.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {

  Cat getFromStaticMemory(int index);

  Cat setCatToStaticMemory(int index, Cat cat);

  Cat updateCat



}
