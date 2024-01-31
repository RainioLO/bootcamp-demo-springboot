package com.demo.springboot.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.demo.springboot.bootcampsbfakedatabase.model.Cat;

public interface DatabaseOperation {

  // 2 ways to define variable from URI

  // 1. PathVariable
  @GetMapping(value = "/cat/{idx}")
  Cat getCat(@PathVariable(name = "idx") int index);

  // Just practicing, Normally use PostMapping
  @GetMapping(value = "/cat/index/{index}/name/{name}/age/{age}")
  void setCat(@PathVariable int index, @PathVariable String name,
      @PathVariable int age);


  @PostMapping(value = "/cat/{idx}")
  Cat createCat(@PathVariable int idx, @RequestBody Cat cat);

  @DeleteMapping(value = "/cat/{idx}")
  Cat deleteCat(@PathVariable int idx);

  @PutMapping(value = "/cat/{idx}")
  Cat updateCat(@PathVariable int idx, @RequestBody Cat cat);


}
