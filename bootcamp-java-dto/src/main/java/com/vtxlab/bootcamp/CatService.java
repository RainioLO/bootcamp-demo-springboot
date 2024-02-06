package com.vtxlab.bootcamp;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.bootcamp.model.Cat;

public class CatService {

  public Cat getCat() {
    // call api, read database
    return new Cat("John", 1);
  }

  public List<Cat> getCatList() {
    Cat cat1 = new Cat("Amy", 21);
    Cat cat2 = new Cat("Jeff", 12);
    Cat cat3 = new Cat("Tom", 23);
    Cat cat4 = new Cat("John", 2);
    Cat cat5 = new Cat("Ben", 1);
    Cat cat6 = new Cat("Benny", 9);
    Cat cat7 = new Cat("Anson", 6);
    Cat cat8 = new Cat("Alison", 4);
    Cat cat9 = new Cat("Auliod", 5);
    Cat cat10 = new Cat("Cathy", 21);

    List<Cat> cats = new ArrayList<>(
        List.of(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
    return cats;

  }

}
