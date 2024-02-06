package com.demo.springboot.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springboot.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.demo.springboot.bootcampsbfakedatabase.database.CatDatabases;
import com.demo.springboot.bootcampsbfakedatabase.model.Cat;
import com.demo.springboot.bootcampsbfakedatabase.service.CatDatabaseService;
import com.demo.springboot.bootcampsbfakedatabase.service.impl.CatDatabaseServiceImpl;

// @Controller
// @ResponseBody //JSON -->
@RestController // @Controller + ResponseBody
@RequestMapping(value = "/api/v1")
// ComponentScan will scan this controller class
// Create an object of this class and put it into spring context
public class DatabaseController implements DatabaseOperation {

  // Dependency injection , inversion of control (IOC) no new object myself, there api new the object and put in other , need to be successful or end !!?
  @Autowired // dependency injection , where to get the object? 自動裝配 from the spring context box which stored the object created for Service, controller,...
  // default to be true -> can set false @Autowired (required = false) --> no need to pick object.
  private CatDatabaseService catDatabaseService; // empty pointer?? , an interface here
  // empty pointer -> nullpointerException.
  // should only be one object can put it here or explode...
  // CatDatabaseServiceImpl object here
  // get the object created at @Service start and put it here interface

  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseServiceImpl().getFromStaticMemory(index);
    return catDatabaseService.getCat(index);
    // use the cataDatabaseService pointer to pick up the object in the context (the address of the object)
  } // if call getCat method -> new many object, the new CatDatabaseServiceImpl() object maybe holded by the method .getFromStaticMemory(index)

  @Override
  public void setCat(int index, String name, int age) {
    // no need new many object at the same time
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

