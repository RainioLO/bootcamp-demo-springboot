package com.bcproductdata.service;

public interface RedisService {

  String setValue(String key, String value); 

  String getValue(String key); 
  
}
