package com.company.model;

import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Objects;


public class Math {


    @NotEmpty(message = "You must supply operand1")
    private int operand1;

    @NotEmpty(message = "You must supply operand2")
    private int operand2;

    @NotEmpty(message = "You must supply operator")
    private String operator;
    public Integer answer;

    public Math() {
    }

    public Math(int operand1, int operand2, String operator, Integer answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
        this.answer = answer;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getAnswer() {
        return answer;
    }

    public Integer setAnswer(Integer answer) {
        this.answer = answer;
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Math math = (Math) o;
        return operand1 == math.operand1 && operand2 == math.operand2 && Objects.equals(operator, math.operator) && Objects.equals(answer, math.answer);
    }

    @Override
    public String toString() {
        return "Math{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operator='" + operator + '\'' +
                ", answer=" + answer +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operator, answer);
    }
}
