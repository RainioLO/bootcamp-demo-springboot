package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {

  Cat getCat(int index);

  Cat[] getCats();

  Cat setCat(int index, Cat cat);

  Cat deleteCat(int index);

  Cat updateCat(int index, Cat cat);

  Cat patchCatName(int index, String name);

  Cat patchCatAge(int index, int age);

}
