package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@WebMvcTest(DatabaseController.class) // Inject the web layer related bean to context only.
// In this test env, component scan will ignore @Service, @Configuration, etc.
// but includes controller beans, mockmvc beans, etc.
class DatabaseControllerTests {

  @Autowired
  private MockMvc mockMvc; // similar to postman

  // @Autowired // You cannot autowired service bean in WebMvcTest env.
  @MockBean // similar to @Mock
  // Because Controller Bean need to autowired catDatabaseService
  private CatDatabaseService catDatabaseService;

  @Test
  void testGetCat() throws Exception {
    // assumption
    Cat mockedReturnCat = new Cat("ABCD", 3);
    // when
    Mockito.when(catDatabaseService.getCat(1)).thenReturn(mockedReturnCat);
    // assert
    mockMvc.perform(get("/api/v1/cat/{idx}", "1")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("ABCD")) //
        .andExpect(jsonPath("$.age").value(3)) //
        .andDo(print()); // similar to sysout, toString()

    // wrong path
    mockMvc.perform(get("/api/v1/cat2/{idx}", "1")) //
        .andExpect(status().isNotFound()) // http code 200 - OK
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPostCat() throws Exception {
    Cat catToPost = new Cat("John", 2);
    String contentString = new ObjectMapper().writeValueAsString(catToPost);
    // when
    Mockito.when(catDatabaseService.setCat(1, catToPost)).thenReturn(catToPost);
    // assert
    mockMvc
        .perform(post("/api/v1/cat/{idx}", "1")
            .contentType(MediaType.APPLICATION_JSON) //
            .content(contentString)) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("John")) //
        .andExpect(jsonPath("$.age").value(2)) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testDeleteCat() throws Exception {
    Cat catToDelete = new Cat("John", 2);
    // when
    Mockito.when(catDatabaseService.deleteCat(0)).thenReturn(catToDelete);
    // assert
    mockMvc.perform(delete("/api/v1/cat/{idx}", "0")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(content().string("true")) //
        .andDo(print()); // similar to sysout, toString()

    // when
    Mockito.when(catDatabaseService.deleteCat(1)).thenReturn(null);
    // assert
    mockMvc.perform(delete("/api/v1/cat/{idx}", "1")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(content().string("false")) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPutCat() throws Exception {
    Cat catToPut = new Cat("Peter", 3);
    String contentString = new ObjectMapper().writeValueAsString(catToPut);
    // when
    Mockito.when(catDatabaseService.updateCat(0, catToPut))
        .thenReturn(catToPut);
    // assert
    mockMvc.perform(put("/api/v1/cat/{idx}", "0") //
        .contentType(MediaType.APPLICATION_JSON) //
        .content(contentString)) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(jsonPath("$.name").value("Peter")) //
        .andExpect(jsonPath("$.age").value(3)) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPatchCatName() throws Exception {
    Cat patchedCat = new Cat("Allen", 5);
    // when
    Mockito.when(catDatabaseService.patchCatName(0, "Allen"))
        .thenReturn(patchedCat);
    // assert
    mockMvc.perform(patch("/api/v1/cat/{idx}/name/{name}", "0", "Allen")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(jsonPath("$.name").value("Allen")) //
        .andExpect(jsonPath("$.age").value(5)) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPatchCatAge() throws Exception {
    Cat patchedCat = new Cat("Allen", 7);
    // when
    Mockito.when(catDatabaseService.patchCatName(2, "Allen"))
        .thenReturn(patchedCat);
    // assert
    mockMvc.perform(patch("/api/v1/cat/{idx}/name/{name}", "2", "Allen")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(jsonPath("$.name").value("Allen")) //
        .andExpect(jsonPath("$.age").value(7)) //
        .andDo(print()); // similar to sysout, toString()
  }



}
