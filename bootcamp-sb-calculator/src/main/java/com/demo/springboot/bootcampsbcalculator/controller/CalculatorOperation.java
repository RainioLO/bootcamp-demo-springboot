package com.demo.springboot.bootcampsbcalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.springboot.bootcampsbcalculator.infra.ApiResp;
import com.demo.springboot.bootcampsbcalculator.infra.exception.BusinessException;
import com.demo.springboot.bootcampsbcalculator.infra.exception.ResourceNotFound;
import com.demo.springboot.bootcampsbcalculator.model.Result;
import com.demo.springboot.bootcampsbcalculator.model.dto.CalculatorDTO;

public interface CalculatorOperation {

  // // this is the entry
  // it get the String from the outside request,

  // @GetMapping(value = "/{x}/{y}/{operation}")

  // String getCalculation(@PathVariable String x, @PathVariable String y,
  // @PathVariable String operation);

  @PostMapping(value = "/")
  ApiResp<Result> calculate(@RequestBody CalculatorDTO calculatorDTO)
      throws BusinessException; // the request body is CalculatorDTO --> to Result

  @GetMapping(value = "/{x}/{y}{operation}")
  ApiResp<Result> getCalculate(@PathVariable String x, @PathVariable String y,
      @PathVariable String operation) throws BusinessException;
}
