package com.demo.springboot.bootcampsbcalculator.model.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo.springboot.bootcampsbcalculator.model.Result;
import com.demo.springboot.bootcampsbcalculator.model.dto.CalculatorDTO;

@Component
public class ResultMapper {

  @Autowired
  private ModelMapper modelMapper;

  public Result map(CalculatorDTO calculatorDTO) { // from CalculatorDTO to Result
    return this.modelMapper.map(calculatorDTO, Result.class);
  }

}
