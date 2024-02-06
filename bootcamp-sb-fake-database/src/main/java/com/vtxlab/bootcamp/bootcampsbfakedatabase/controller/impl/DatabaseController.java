package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

// @Controller
// @ResponseBody // JSON
@RestController
// Create an object of this class, and put it into spring context
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {

  @Autowired // (required = false) // dependency injection 自動裝配
  // Polymorphism
  private CatDatabaseService catDatabaseService;

  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseServiceImpl().getCatFromStaticMemory(index);
    return catDatabaseService.getCat(index);
  }

  @Override
  public List<Cat> getCats() {
    return Arrays.stream(catDatabaseService.getCats()) //
        .collect(Collectors.toList());
  }

  @Override
  public Cat getCat2(int index) {
    return catDatabaseService.getCat(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    // new CatDatabaseServiceImpl().setCatToStaticMemory(index,
    // new Cat(name, age));
    catDatabaseService.setCat(index, new Cat(name, age));
  }

  @Override
  public Cat createCat(int idx, Cat cat) {
    return catDatabaseService.setCat(idx, cat);
  }

  @Override
  public Boolean deleteCat(int idx) {
    return catDatabaseService.deleteCat(idx) != null;
  }

  @Override
  public Cat updateCat(int idx, Cat cat) {
    return catDatabaseService.updateCat(idx, cat);
  }

  @Override
  public Cat patchCatName(int idx, String name) {
    return catDatabaseService.patchCatName(idx, name);
  }

  @Override
  public Cat patchCatAge(int idx, int age) {
    return catDatabaseService.patchCatAge(idx, age);
  }

}
