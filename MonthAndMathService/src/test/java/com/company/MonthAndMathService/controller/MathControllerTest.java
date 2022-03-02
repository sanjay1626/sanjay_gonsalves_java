package com.company.MonthAndMathService.controller;

import com.company.controller.MathController;
import com.company.model.Math;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup(){

    }
    @Test
    public void shouldAdd() throws Exception {
        Math inputMath = new Math();
        inputMath.setOperand1(2);
        inputMath.setOperand2(2);
        inputMath.setOperator("Add");
        inputMath.setAnswer(4);
        String inputJson = mapper.writeValueAsString(inputMath);

        Math outputMath = new Math();
        outputMath.setOperand1(2);
        outputMath.setOperand2(2);
        outputMath.setOperator("Add");
        outputMath.setAnswer(4);

        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/math/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }
    @Test
    public void shouldSubtract() throws Exception{
        Math inputMath = new Math();
        inputMath.setOperand1(10);
        inputMath.setOperand2(5);
        inputMath.setOperator("Subtract");
        inputMath.setAnswer(5);
        String inputJson = mapper.writeValueAsString(inputMath);

        Math outputMath = new Math();
        outputMath.setOperand1(10);
        outputMath.setOperand2(5);
        outputMath.setOperator("Subtract");
        outputMath.setAnswer(5);
        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/math/sub")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public  void shouldMultiply() throws Exception{
        Math inputMath = new Math();
        inputMath.setOperand1(10);
        inputMath.setOperand2(5);
        inputMath.setOperator("Multiplication");
        inputMath.setAnswer(50);
        String inputJson = mapper.writeValueAsString(inputMath);

        Math outputMath = new Math();
        outputMath.setOperand1(10);
        outputMath.setOperand2(5);
        outputMath.setOperator("Multiplication");
        outputMath.setAnswer(50);
        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/math/mul")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
    @Test
    public void shouldDivide() throws  Exception{
        Math inputMath = new Math();
        inputMath.setOperand1(8);
        inputMath.setOperand2(4);
        inputMath.setOperator("Division");
        inputMath.setAnswer(2);
        String inputJson = mapper.writeValueAsString(inputMath);

        Math outputMath = new Math();
        outputMath.setOperand1(8);
        outputMath.setOperand2(4);
        outputMath.setOperator("Division");
        outputMath.setAnswer(2);
        String outputJson = mapper.writeValueAsString(outputMath);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/math/div")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
    @Test
    public void shouldReturn422StatusNullInput() throws Exception {
        Math inputMath = new Math();
        inputMath.setOperand1(8);
        inputMath.setOperator("Add");
        String inputJson = mapper.writeValueAsString(inputMath);


        mockMvc.perform(
                        MockMvcRequestBuilders.post("/math/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());


    }
    @Test
    public void shouldReturn422StatusIfInputtedString() throws  Exception{
        Map<String, String> inputMath = new HashMap<>();
        inputMath.put("operand1", "10");
        inputMath.put("operand2","asdasdasd");
        inputMath.put("operator","Add");
        String inputJson = mapper.writeValueAsString(inputMath);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/math/add")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }
}
