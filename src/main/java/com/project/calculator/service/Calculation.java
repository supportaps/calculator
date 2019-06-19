package com.project.calculator.service;

import com.project.calculator.model.CalculationModel;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class Calculation {

    public int sum(CalculationModel calculationModel) {

        return calculationModel.getA() + calculationModel.getB();

    }

    public int sub(CalculationModel calculationModel) {

        return calculationModel.getA() - calculationModel.getB();

    }

    public int mult(CalculationModel calculationModel) {

        return calculationModel.getA() * calculationModel.getB();

    }

    public int div(CalculationModel calculationModel) {

        return calculationModel.getA() / calculationModel.getB();

    }

}
