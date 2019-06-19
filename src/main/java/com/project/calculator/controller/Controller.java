package com.project.calculator.controller;


import com.project.calculator.model.CalculationModel;
import com.project.calculator.service.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@org.springframework.stereotype.Controller

public class Controller {


    CalculationModel calculationModel = new CalculationModel();

    @Autowired
    private Calculation calculation;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model) {
        model.addAttribute("calculationModel", calculationModel);
        return "calculator";

    }

    @RequestMapping(value = "/calculator", params = "sum", method = RequestMethod.POST)
    public String sum(@ModelAttribute("calculationModel") CalculationModel calculationModel, Model model) {
        model.addAttribute("result", calculation.sum(calculationModel));
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "sub", method = RequestMethod.POST)
    public String sub(@Valid @ModelAttribute("calculationModel") CalculationModel calculationModel, Model model, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("result", calculation.sub(calculationModel));
            return "calculator";
        } else
            model.addAttribute("result", calculationModel.getOperation());
        return "calculator";

    }

    @RequestMapping(value = "/calculator", params = "mult", method = RequestMethod.POST)
    public String mult(@ModelAttribute("calculationModel") CalculationModel calculationModel, Model model) {
        model.addAttribute("result", calculation.mult(calculationModel));
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "div", method = RequestMethod.POST)
    public String div(@ModelAttribute("calculationModel") CalculationModel calculationModel, Model model) {
        model.addAttribute("result", calculation.div(calculationModel));
        return "calculator";
    }

}

