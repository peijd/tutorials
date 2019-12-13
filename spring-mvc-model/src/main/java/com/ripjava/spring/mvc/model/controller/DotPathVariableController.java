package com.ripjava.spring.mvc.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DotPathVariableController {

    @RequestMapping(value = "/dpv/{firstValue}/{secondValue}", method = RequestMethod.GET)
    @ResponseBody
    public String dotPathVariable(@PathVariable("firstValue") String firstValue,
                        @PathVariable("secondValue") String secondValue) {
        return String.format("firstValue: %s , secondValue: %s", firstValue, secondValue);
    }

    @RequestMapping(value = "/dpv2/{firstValue}/{secondValue:.+}", method = RequestMethod.GET)
    @ResponseBody
    public String dotPathVariable2(@PathVariable("firstValue") String firstValue,
                                   @PathVariable("secondValue") String secondValue) {
        return String.format("firstValue: %s , secondValue: %s", firstValue, secondValue);
    }

    @RequestMapping(value = "/dpv3/{firstValue}/{secondValue}/", method = RequestMethod.GET)
    @ResponseBody
    public String dotPathVariable3(@PathVariable("firstValue") String firstValue,
                                   @PathVariable("secondValue") String secondValue) {
        return String.format("firstValue: %s , secondValue: %s", firstValue, secondValue);
    }
}
