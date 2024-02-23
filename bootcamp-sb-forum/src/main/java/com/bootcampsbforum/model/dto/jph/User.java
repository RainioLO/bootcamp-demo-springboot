package com.bootcampsbforum.model.dto.jph;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// data transfer object from api, it may change from time to time

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class User { // from JSON to object deserializtion
  // this class can be shared to the world

  private int id;
  private String name; // String to varchar in SQL
  private String username;
  private String email;
  private String phone;
  private String website;
  private Address address;
  private Company company;

  @Getter
  @Setter
  public static class Location {

    @JsonProperty(value = "lat")
    private String latitude;

    @JsonProperty(value = "lng") // this is from outside --> we can use our own name ...
    private String longitude;

    // Constructors, getters, setters, and other methods
  }

  @Getter
  @Setter
  public static class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Location geo;

    // Constructors, getters, setters, and other methods
  }

  @Getter
  @Setter
  public static class Company {

    private String name;
    private String catchPhrase;

    @JsonProperty(value = "bs") // to allign others 
    private String busService;

    // Constructors, getters, setters, and other methods
  }


}
