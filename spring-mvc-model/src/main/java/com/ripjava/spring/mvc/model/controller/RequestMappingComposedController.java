package com.ripjava.spring.mvc.model.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("composed")
public class RequestMappingComposedController {
    @GetMapping("/get/{id}")
    @ResponseBody
    public  String getById(@PathVariable String id) {
        return "GET Response";
    }

//    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String getById(@PathVariable String id) {
//        return "GET Response : " + id;
//    }

    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "POST Response ";
    }

//    @RequestMapping(value = "/post", method = RequestMethod.POST)
//    @ResponseBody
//    public String post() {
//        return "POST Response ";
//    }

    @PostMapping("/put")
    @ResponseBody
    public String put() {
        return "PUT Response ";
    }

//    @RequestMapping(value = "/put", method = RequestMethod.PUT)
//    @ResponseBody
//    public String put() {
//        return "PUT Response ";
//    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Response ";
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//    @ResponseBody
//    public String delete() {
//        return "DELETE Response ";
//    }

    @PatchMapping("/patch")
    @ResponseBody
    public  String patch() {
        return "PATCH Response";
    }

//    @RequestMapping(value = "/patch", method = RequestMethod.PATCH)
//    @ResponseBody
//    public  String patch() {
//        return "PATCH Response";
//    }


}
