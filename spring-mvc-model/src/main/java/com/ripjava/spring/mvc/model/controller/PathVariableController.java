package com.ripjava.spring.mvc.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVariableController {

    @RequestMapping(value = "/pv/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String onePv(
            @PathVariable("id") long id) {
        return "Single PathVariable id = " + id;
    }

    @RequestMapping(value = "/pv/{from}/to/{to}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplePv(
            @PathVariable("from") String from,  @PathVariable("to") String to  ) {
        return String.format("PathVariable From: %s To: %s", from, to);
    }

    @RequestMapping(value = "/pv/reg/{strId:[a-z]+}", method = RequestMethod.GET)
    @ResponseBody
    public String regExPv(
            @PathVariable String strId) {
        return "Get a specific Bar with id=" + strId;
    }
}
