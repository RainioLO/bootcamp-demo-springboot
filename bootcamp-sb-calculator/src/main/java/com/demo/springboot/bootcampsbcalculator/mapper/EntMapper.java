package com.demo.springboot.bootcampsbcalculator.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntMapper {

  @Autowired
  private ModelMapper modelMapper;
  
}
