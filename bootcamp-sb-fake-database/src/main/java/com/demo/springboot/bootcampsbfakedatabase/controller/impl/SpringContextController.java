package com.demo.springboot.bootcampsbfakedatabase.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springboot.bootcampsbfakedatabase.BootcampSbFakeDatabaseApplication;
import com.demo.springboot.bootcampsbfakedatabase.config.AppConfig;
import com.demo.springboot.bootcampsbfakedatabase.controller.SpringContextOperation;

@RestController
@RequestMapping(value = "/api/v1")
public class SpringContextController implements SpringContextOperation {

  @Override
  public String[] getBeans() {
    return BootcampSbFakeDatabaseApplication.getStringContext()
        .getBeanDefinitionNames();
  }

  @Autowired // auto let the pointer point to the address of the bean which help to create new object
  @Qualifier(value = "tutor2") // if we have two beans, can give value to choose
  private CharSequence tutorName;

  @Override
  public CharSequence getTutorName() {
    return tutorName;
  }


}
