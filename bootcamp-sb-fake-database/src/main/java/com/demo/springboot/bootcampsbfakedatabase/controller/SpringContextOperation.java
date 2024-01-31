package com.demo.springboot.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface SpringContextOperation { 

  @GetMapping(value = "/beans") // noun
  String[] getBeans();

  @GetMapping(value = "/tutorname")
  CharSequence getTutorName();
}
