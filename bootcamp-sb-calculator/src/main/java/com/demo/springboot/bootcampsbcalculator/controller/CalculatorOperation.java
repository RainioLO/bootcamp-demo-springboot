package com.demo.springboot.bootcampsbcalculator.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface CalculatorOperation {

  //
  @PostMapping(value = "/x/{x}/y/{y}/operation/{operation}") // this is the entry

  double calculate(@PathVariable int x, @PathVariable int y,
      @PathVariable String operation); // it get the String from the outside request,



}
