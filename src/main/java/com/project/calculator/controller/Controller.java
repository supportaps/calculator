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

public class Controller implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/calculator").setViewName("calculator");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }

    @Override
            public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer){}

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }


    CalculationModel calculationModel = new CalculationModel();

    @Autowired
    private Calculation calculation;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model) {
        model.addAttribute("calculationModel", calculationModel);
        return "calculator";

    }

    @RequestMapping(value = "/calculator", params = "sum", method = RequestMethod.POST)
    public String sum(@Valid @ModelAttribute("calculationModel") CalculationModel calculationModel, Model model) {
        model.addAttribute("result", calculation.sum(calculationModel));
        return "calculator";
    }

    @RequestMapping(value = "/calculator", params = "sub", method = RequestMethod.POST)
    public String sub(@Valid @ModelAttribute("calculationModel") CalculationModel calculationModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
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

