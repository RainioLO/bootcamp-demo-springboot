package com.bootcampsbforum.infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String lowrcaseName(){
    return this.name().toLowerCase();
  }
  
}
