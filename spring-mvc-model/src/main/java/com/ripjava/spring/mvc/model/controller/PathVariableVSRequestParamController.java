package com.ripjava.spring.mvc.model.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PathVariableVSRequestParamController {

    private static final Logger logger
            = LoggerFactory.getLogger(PathVariableVSRequestParamController.class);

    @RequestMapping(value = "/vs/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public String getPathVariable(@PathVariable String id) {
        logger.info("PathVariable ID: {}", id);
        return "PathVariable ID: " + id;
    }

    @RequestMapping(value = "/vs" , method = RequestMethod.GET)
    @ResponseBody
    public String getRequestParam(@RequestParam String id) {
        logger.info("RequestParam ID: {}", id);
        return "RequestParam ID: " + id;
    }


}
