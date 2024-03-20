package com.bcproductdata.infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String lowercaseName(){
    return this.name().toLowerCase(); // .name() return the exact name of the enum.
  }
  
}

