package com.bootcampsbthymeleaf.service;

import java.util.List;

public interface ApiService <T> {

  List<T> fetchData();
  
}
