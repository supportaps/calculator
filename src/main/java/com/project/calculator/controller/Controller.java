package com.project.calculator.controller;


import com.project.calculator.model.CalculationModel;
import com.project.calculator.service.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.validation.Valid;
import java.util.List;

@org.springframework.stereotype.Controller

public class Controller{




    CalculationModel calculationModel = new CalculationModel();

    @Autowired
    private Calculation calculation;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model) {
        model.addAttribute("calculationModel", calculationModel);
        return "calculator";

    }

    @RequestMapping(value = "/calculator", params = "sum", method = RequestMethod.POST)
    public String sum(@Valid @ModelAttribute("calculationModel") CalculationModel calculationModel, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("result", calculation.sum(calculationModel));
            return "calculator";
        } else
            return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "sub", method = RequestMethod.POST)
    public String sub(@Valid @ModelAttribute("calculationModel") CalculationModel calculationModel, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("result", calculation.sub(calculationModel));
            return "calculator";
        } else
            return "calculator";

    }

    @RequestMapping(value = "/calculator", params = "mult", method = RequestMethod.POST)
    public String mult(@Valid @ModelAttribute("calculationModel") CalculationModel calculationModel, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("result", calculation.mult(calculationModel));
            return "calculator";
        } else
            return "calculator";

    }

    @RequestMapping(value = "/calculator", params = "div", method = RequestMethod.POST)
    public String div(@Valid @ModelAttribute("calculationModel") CalculationModel calculationModel, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("result", calculation.div(calculationModel));
            return "calculator";
        } else
            return "calculator";

    }

}

