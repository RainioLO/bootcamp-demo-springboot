package com.demo.springboot.bootcampsbcalculator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import com.demo.springboot.bootcampsbcalculator.controller.Impl.CalculatorController;
import com.demo.springboot.bootcampsbcalculator.model.Result;
import com.demo.springboot.bootcampsbcalculator.model.dto.CalculatorDTO;
import com.demo.springboot.bootcampsbcalculator.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @MockBean // similar to @Mock
        // Because Controller Bean need to autowired catDatabaseService
        private CalculatorService CalculatorService;

        @Test
        void addCalculate() throws Exception {

                Result addCalculationToPost =
                                new Result("999", "1", "add", "1000");
                CalculatorDTO request = new CalculatorDTO("999", "1", "add");
                String addContentString =
                                new ObjectMapper().writeValueAsString(request);
                // when
                Mockito.when(CalculatorService.add(999, 1))
                                .thenReturn(addCalculationToPost);
                // assert
                mockMvc.perform(post("/api/v1/", request) // url + the @RequestBody
                                .contentType(MediaType.APPLICATION_JSON) //
                                .content(addContentString)) //
                                .andExpect(status().isOk()) // http code 200 - OK
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.data.x").value("999")) //
                                .andExpect(jsonPath("$.data.y").value("1"))
                                .andExpect(jsonPath("$.data.operation")
                                                .value("add"))
                                .andExpect(jsonPath("$.data.result")
                                                .value("1000"))
                                .andDo(print()); // similar to sysout, toString()
        }

        @Test
        void divCalculate() throws Exception {
                Result divCalculationToPost =
                                new Result("1000", "4", "div", "250.00000"); // expected result
                String divContentString = // result to string
                                new ObjectMapper().writeValueAsString(
                                                divCalculationToPost);
                // when
                Mockito.when(CalculatorService.divide(1000, 4)) // mock the result using service
                                .thenReturn(divCalculationToPost); // to retrun the Result
                // assert
                mockMvc.perform(post("/api/v1/", new CalculatorDTO("1000", "4",
                                "div")).contentType(MediaType.APPLICATION_JSON) //
                                                .content(divContentString)) //
                                .andExpect(status().isOk()) // http code 200 - OK
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.data.x").value("1000")) //
                                .andExpect(jsonPath("$.data.y").value("4"))
                                .andExpect(jsonPath("$.data.operation")
                                                .value("div"))
                                .andExpect(jsonPath("$.data.result")
                                                .value("250.00000"))
                                .andDo(print()); // similar to sysout, toString()
        }

        // @Test
        // void divCalculate2() throws Exception {

        //         Mockito.when(CalculatorService.divide(1000, 0))
        //                         .thenThrow(new ArithmeticException("Division by zero")); // mock the result using service
        //         // to retrun the Result
        //         // assert
        //         CalculatorDTO request = new CalculatorDTO("1000", "0", "div");
        //         String requestContentString =
        //                         new ObjectMapper().writeValueAsString(request);
        //         mockMvc.perform(post("/api/v1/", request)
        //                         .contentType(MediaType.APPLICATION_JSON) //
        //                         .content(requestContentString)
        //                         .andExpect(status().isBadRequest())
        //                         .andDo(print()));
        // }

        @Test
        void subCalculate() throws Exception {
                Result subCalculationToPost =
                                new Result("1000", "4", "sub", "996");
                String subContentString = new ObjectMapper()
                                .writeValueAsString(subCalculationToPost);
                // when
                Mockito.when(CalculatorService.substract(1000, 4))
                                .thenReturn(subCalculationToPost);
                // assert
                mockMvc.perform(post("/api/v1/", new CalculatorDTO("1000", "4",
                                "sub")).contentType(MediaType.APPLICATION_JSON) //
                                                .content(subContentString)) //
                                .andExpect(status().isOk()) // http code 200 - OK
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.data.x").value("1000")) //
                                .andExpect(jsonPath("$.data.y").value("4"))
                                .andExpect(jsonPath("$.data.operation")
                                                .value("sub"))
                                .andExpect(jsonPath("$.data.result")
                                                .value("996"))
                                .andDo(print()); // similar to sysout, toString()
        }

        @Test
        void mulCalculate() throws Exception {
                Result mulCalculationToPost =
                                new Result("1000", "4", "mul", "4000");
                String mulContentString = new ObjectMapper()
                                .writeValueAsString(mulCalculationToPost);
                // when
                Mockito.when(CalculatorService.multiply(1000, 4))
                                .thenReturn(mulCalculationToPost);
                // assert
                mockMvc.perform(post("/api/v1/", new CalculatorDTO("1000", "4",
                                "mul")).contentType(MediaType.APPLICATION_JSON) //
                                                .content(mulContentString)) //
                                .andExpect(status().isOk()) // http code 200 - OK
                                .andExpect(content().contentType(
                                                MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.data.x").value("1000")) //
                                .andExpect(jsonPath("$.data.y").value("4"))
                                .andExpect(jsonPath("$.data.operation")
                                                .value("mul"))
                                .andExpect(jsonPath("$.data.result")
                                                .value("4000"))
                                .andDo(print()); // similar to sysout, toString()
        }

}


