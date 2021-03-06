package com.project.calculator.model;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class CalculationModel {

    private String operation;
    @Digits(integer=1, fraction=1)
    @Max(5)
    private int a;
    @Digits(integer=1, fraction=1)
    @Max(4)
    private int b;

    public CalculationModel() {

    }

    public CalculationModel(String operation) {
        this.operation = operation;
    }


    public CalculationModel(int a, int b) {
        this.a = a;
        this.b = b;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}


