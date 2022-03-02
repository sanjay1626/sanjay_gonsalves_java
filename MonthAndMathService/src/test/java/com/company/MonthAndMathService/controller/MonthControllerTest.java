package com.company.MonthAndMathService.controller;

import com.company.controller.MonthController;
import com.company.model.Month;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.Serializable;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthController.class)
public class MonthControllerTest implements Serializable {

    //Auto wiring MockMvc Obj
    @Autowired
    private MockMvc mockMvc;

    //Convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup(){
        //Nothing yet to put here will get back to you if needed.
    }

    //Need to Test to validate error responses
    //Need to Test month endpoint,month by number & month random

    //Test to GET /month
    @Test
    public void shouldReturnAllMonth ()throws Exception{
        //perform mockmvc to test endpoint /month
        //pass test returning all data.

        mockMvc.perform(get("/month"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }
    @Test
    public void shouldReturnByMonth() throws Exception{
        Month outputMonth = new Month();

        outputMonth.setMonth("March");
        outputMonth.setNumber(3);

        String outputJson = mapper.writeValueAsString(outputMonth);
        mockMvc.perform(get("/month/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
    @Test
    public void shouldReturnRandomMonth() throws  Exception{
       // Random randomize = new Random();
       // String outputJson = mapper.writeValueAsString(randomize.nextInt(monthList.size()));
        //String output = String.valueOf(randomize.nextInt(monthList.size()));
        mockMvc.perform(get("/month/random"))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().string(outputJson));
                //.andExpect(content().json(String.valueOf(new JSONParser(outputJson))));
    }
    @Test
    public void shouldReturn422StatusCodeMonthNumberOutOfRange() throws Exception {
        Month inputMonth = new Month();
        inputMonth.setMonth("January");
        inputMonth.setNumber(1);
        String inputJson = mapper.writeValueAsString(inputMonth);

        mockMvc.perform(get("/month/15464")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldReturn422StatusMonthNumberStringInput() throws  Exception{
        Map<String, String> inputMath = new HashMap<>();

        inputMath.put("month","January");

        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/month/dfgdfgd")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

}
