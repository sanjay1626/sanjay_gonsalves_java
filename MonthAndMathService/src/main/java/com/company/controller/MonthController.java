package com.company.controller;

import com.company.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

@RestController

public class MonthController {

    private final static Random randomizer = new Random();
    List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1,"January"),
            new Month(2,"February"),
            new Month(3,"March"),
            new Month(4,"April"),
            new Month(5,"May"),
            new Month(6, "June"),
            new Month(7,"July"),
            new Month(8,"August"),
            new Month(9,"September"),
            new Month(10,"October"),
            new Month(11,"November"),
            new Month(12,"December")
    ));
    //GET monthList
    @GetMapping("/month")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Month> getMonthList(){
        return monthList;
    }

    //GET month by number
    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByNumber(@Valid  @PathVariable int monthNumber){
        Month foundMonth = null;
        //Validation scan, IllegalArgumentException used
        for(Month month : monthList){
            if(month.getNumber() == monthNumber){
                foundMonth = month;
                break;
            }
        }
            if(monthNumber > 12){
                throw  new NumberFormatException("Number out of range");
            }
            return foundMonth;
        }

    //Random Month
    @GetMapping("/month/random")
    @ResponseBody
    public Month getRandomMonthByNumber() {
            //Found Random Class to randomize an ArrayList
            int listSize = monthList.size();
            int randomIndex = randomizer.nextInt(listSize);
            Month randomMonth = monthList.get(randomIndex);

            return randomMonth;
    }

}
