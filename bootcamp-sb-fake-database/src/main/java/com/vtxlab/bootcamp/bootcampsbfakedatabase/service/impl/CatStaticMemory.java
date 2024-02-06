package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Service
// Create an object of this class, put it into spring context
public class CatStaticMemory implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  @Override
  public Cat getCat(int index) {
    return CatDatabase.getCat(index);
  }

  @Override
  public Cat[] getCats() {
    return CatDatabase.getCats();
  }

  @Override
  public Cat setCat(int index, Cat cat) {
    return CatDatabase.setCat(index, cat);
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
