package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface SpringContextOperation {

  @GetMapping(value = "/beans") // noun
  String[] getBeans();

  @GetMapping(value = "/tutorname") // noun
  CharSequence getTutorName();

}
