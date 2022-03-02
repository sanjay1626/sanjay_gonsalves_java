package com.company.controller;

import com.company.model.Math;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class MathController  {
    ObjectMapper mapper = new ObjectMapper();
    @PostMapping("/math/add")
    @Transactional
    @ResponseStatus(value = HttpStatus.OK)
    public Math addMath(@RequestBody  Math ob)  {
        //Creating an object of ArrayList
        ob.setOperator("Add");
        ArrayList<Math> Data = new ArrayList<>();
        if (ob.getOperand1() == 0 || (ob.getOperand2() == 0)) {
            throw new IllegalArgumentException("Invalid Input");
        }
            Data.add(new Math(ob.getOperand1(),
                    ob.getOperand2(),
                    ob.getOperator(),
                    ob.setAnswer(ob.getOperand1() + ob.getOperand2())));
        return ob;
    }
    @PostMapping("math/sub")
    @ResponseStatus(value = HttpStatus.OK)
    public Math subMath(@RequestBody Math val){
        val.setOperator("Subtract");
        ArrayList<Math> Data = new ArrayList<>();
        Data.add(new Math(val.getOperand1(),
                    val.getOperand2(),
                    val.getOperator(),
                    val.setAnswer(val.getOperand1() - val.getOperand2())));
        if(val.getOperand1() == 0 || val.getOperand2() == 0){
            throw  new IllegalArgumentException("Invalid input");
        }
        return val;
    }
    @PostMapping("math/mul")
    @ResponseStatus(value = HttpStatus.OK)
    public Math mulMath(@RequestBody Math val) {
        val.setOperator("Multiplication");
        ArrayList<Math> Data = new ArrayList<>();
        Data.add(new Math(val.getOperand1(),
                val.getOperand2(),
                val.getOperator(),
                val.setAnswer(val.getOperand1() * val.getOperand2())));
        if (val.getOperand1() == 0 || val.getOperand2() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return val;
    }
    @PostMapping("math/div")
    @ResponseStatus(value = HttpStatus.OK)
    public Math mulDiv(@RequestBody Math val) {
        val.setOperator("Division");
        ArrayList<Math> Data = new ArrayList<>();
        Data.add(new Math(val.getOperand1(),
                val.getOperand2(),
                val.getOperator(),
                val.setAnswer(val.getOperand1() / val.getOperand2())));
        if (val.getOperand1() == 0 || val.getOperand2() == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return val;
    }
}

