package com.ripjava.spring.mvc.model.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestMappingController {


    @RequestMapping(value = "/by/path", method = RequestMethod.POST)
    @ResponseBody
    public String postByPath() {
        return "Post By Path";
    }

    @RequestMapping(value = "/by/path",
            method =  RequestMethod.GET)
    @ResponseBody
    public String byPath() {
        return "Get By Path";
    }

    @RequestMapping(value = "/by/path",
            headers = "key=val",
            method =  RequestMethod.GET)
    @ResponseBody
    public String byPathAndHeader() {
        return "Get By Header And Path";
    }
    @RequestMapping(value = "/by/path",
            headers = {"key=val"
            ,  "key2=val2"
            },
            method =  RequestMethod.GET)
    @ResponseBody
    public String byPathAndHeaderM() {
        return "Get By Header 2  And Path";
    }

//    @RequestMapping(value = "/by/path",
//            headers = {"Accept=application/json"},
//            method =  RequestMethod.GET)
//    @ResponseBody
//    public String byPathAndProduces() {
//        return "Get By Produces And Path";
//    }

    @RequestMapping(value = "/by/path",
            produces  = {"application/json"},
            method =  RequestMethod.GET)
    @ResponseBody
    public String byPathAndProducesAttribute() {
        return "Get By Produces Attribute And Path";
    }

    @RequestMapping(
            value = { "/by/multiple1", "/by/multiple2" },
            method =  RequestMethod.GET)
    @ResponseBody
    public String mapToSameMethod() {
        return "Multiple Paths Mapped to the Same Controller Method";
    }


    @RequestMapping(
            value = { "/by/httpmethod" },
            method = {RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String mapToSameMethodByHttpMethod() {
        return "Multiple HTTP Request Methods to the Same Controller Method";
    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    @ResponseBody
    public String mapFallback() {
        return "A Fallback for All GET Requests";
    }

    @RequestMapping(value = "*")
    @ResponseBody
    public String mapAllFallback() {
        return "A Fallback for All Requests";
    }

    @RequestMapping(value = "by/duplicate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String duplicate() {
        return "Duplicate";
    }

    @RequestMapping(value = "by/duplicate", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public String duplicateEx() {
        return "Duplicate";
    }
}
