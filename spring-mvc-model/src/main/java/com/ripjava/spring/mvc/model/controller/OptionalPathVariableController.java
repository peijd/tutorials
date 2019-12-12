package com.ripjava.spring.mvc.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Optional;

@Controller
public class OptionalPathVariableController {
    private static final Logger logger
            = LoggerFactory.getLogger(OptionalPathVariableController.class);

    @RequestMapping(value = { "/opv","/opv/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public String optionalPath(@PathVariable(name = "id",required = false) Integer id){
        logger.info("optional Path Variable");
        if(id == null){
            return  "OptionalPathVariable id  not set";
        }
        return  "OptionalPathVariable id =" + id;
    }

    @RequestMapping(value = { "/opv2","/opv2/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public String optionalPath2(@PathVariable Optional<Integer> id){
        logger.info("optional Path Variable");
        if(!id.isPresent()){
            return  "OptionalPathVariable id  not set";
        } else {
            return  "OptionalPathVariable id =" + id.get();
        }
    }

    @RequestMapping(value = { "/opv3","/opv3/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public String optionalPath3(@PathVariable Map<String, String> pvMap){
        logger.info("optional Path Variable");
        String id = pvMap.get("id");
        if(id == null){
            return  "OptionalPathVariable id  not set";
        }
        return  "OptionalPathVariable id =" + id;
    }

    @RequestMapping(value = { "/opv4" }, method = RequestMethod.GET)
    @ResponseBody
    public String optionalPath4(){
            return  "OptionalPathVariable id  not set";
    }

    @RequestMapping(value = {"/opv4/{id}" }, method = RequestMethod.GET)
    @ResponseBody
    public String optionalPath4(@PathVariable Integer id){
        return  "OptionalPathVariable id =" + id;
    }

}
