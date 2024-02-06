package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.BootcampSbFakeDatabaseApplication;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.SpringContextOperation;

@RestController
@RequestMapping(value = "/api/v1")
public class SpringContextController implements SpringContextOperation {

  @Autowired
  @Qualifier(value = "tutor2")
  private CharSequence tutorName;

  @Override
  public String[] getBeans() {
    return BootcampSbFakeDatabaseApplication //
        .getSpringContext() //
        .getBeanDefinitionNames();
  }

  //
  @Override
  public CharSequence getTutorName() {
    return this.tutorName;
  }

}
