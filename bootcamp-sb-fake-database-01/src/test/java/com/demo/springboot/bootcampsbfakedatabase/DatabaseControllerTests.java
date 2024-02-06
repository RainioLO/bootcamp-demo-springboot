package com.demo.springboot.bootcampsbfakedatabase;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.demo.springboot.bootcampsbfakedatabase.model.Cat;
import com.demo.springboot.bootcampsbfakedatabase.service.CatDatabaseService;

@WebMvcTest // Inject the web layer related bean to context only
// so, in this test env, component scan will ignore @Service, @Configuration
// but includes controller bean, mockmvc beans, etc.
class DatabaseControllerTests { // mimic postman

  @Autowired
  private MockMvc mockMvc;

  // @Autowired // You cannot autowired service bean in WebMvcTest
  @MockBean // similar to @Mock
  // Because Controller Bean need to autowired catDatabaseService
  private CatDatabaseService catDatabaseService;

  @Test
  void testGetCat() throws Exception {

    // assumption
    Cat mockedReturnedCat = new Cat("ABCD", 3);
    // when
    Mockito.when(catDatabaseService.getCat(1)).thenReturn(mockedReturnedCat);
    // asseret
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat/{idx}", "1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ABCD"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(3))
        .andDo(MockMvcResultHandlers.print()); // similar to sysout, toString()

    // wrong path
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cat2/{idx}", "1"))
        .andExpect(status().isNotFound()).andDo(print());


  }


}
