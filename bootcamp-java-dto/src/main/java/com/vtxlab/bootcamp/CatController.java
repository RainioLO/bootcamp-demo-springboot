package com.vtxlab.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.vtxlab.bootcamp.dto.CatDto;
import com.vtxlab.bootcamp.model.Cat;

public class CatController {

  private CatService catservice = new CatService();


  public CatDto getCat() {
    Cat cat = new CatService().getCat();
    String description =
        "Cat Name:" + cat.getName() + ", Cat Age:" + cat.getAge();
    CatDto catDto = new CatDto(description, "Apple");
    return catDto;
  }

  public Map<String, Integer> getCats() { // String -> name, Integer -> age
    // call getCats();
    Map<String, Integer> catMap = new HashMap<>();
    List<Cat> cats = catservice.getCatList();

    for (int i = 0; i < cats.size(); i++) {
      catMap.put(cats.get(i).getName(), cats.get(i).getAge());
    }
    return catMap;
  }


}
