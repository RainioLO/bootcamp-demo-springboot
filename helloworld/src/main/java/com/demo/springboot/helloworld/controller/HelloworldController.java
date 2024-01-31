package com.demo.springboot.helloworld.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.springboot.helloworld.controller.model.Cat;


@Controller // Web Layer, provide the capability of API (application programming interface)
// springframework notation
@ResponseBody // return a JSON (format of data transmission - System A call System B API)
@RequestMapping(value = "/api/v1")

public class HelloworldController {

  // Attributes, constructor, instance method.

  // @GetMapping ()
  @GetMapping(value = "/hello") // at certain port --> the entry
  public String helloworld() {
    return "Welcome to Spring Boot.";
  }

  @GetMapping(value = "/wrapperclass")
  public Character mys() {
    return '!';
  }

  @GetMapping(value = "/catClass")
  public Cat cat() {
    return Cat.builder().name("Jason").age(3).build();
  }

  @GetMapping(value = "/catList")
  public List<Cat> catList() {
    Cat cat1 = new Cat("Yellow", 7);
    Cat cat2 = new Cat("Blye", 7);
    Cat cat3 = new Cat("Ity", 7);
    Cat cat4 = new Cat("Blue", 7);
    return Stream.of(cat1, cat2, cat3, cat4).collect(Collectors.toList());
  }

  @GetMapping(value = "/catArray")
  public Cat[] catArray() {
    Cat cat1 = new Cat("Yellow", 7);
    Cat cat2 = new Cat("Blye", 17);
    Cat cat3 = new Cat("Ity", 7);
    Cat cat4 = new Cat("Hello", 9);
    return new Cat[] {cat1, cat2, cat3, cat4};
  }

}


