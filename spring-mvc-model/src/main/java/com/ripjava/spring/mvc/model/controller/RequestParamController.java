package com.ripjava.spring.mvc.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RequestParamController {

    @RequestMapping("/api/book")
    @ResponseBody
    public String getBook(@RequestParam String id) {
        return "ID: " + id;
    }

    @RequestMapping("/api/book2")
    @ResponseBody
    public String getBooks2(@RequestParam(value = "id") String bookId, @RequestParam String name) {
        return String.format("id: %s; name: %s", bookId, name);
    }

    @RequestMapping("/api/book3")
    @ResponseBody
    public String getBooks3(@RequestParam(value = "id",required = false) String bookId, @RequestParam(required = false) String name) {
        return String.format("id: %s; name: %s", bookId, name);
    }

    @RequestMapping("/api/book4")
    @ResponseBody
    public String getBooks4(@RequestParam(value = "id") Optional<String> bookId, @RequestParam Optional<String> name) {
        return String.format("id: %s; name: %s", bookId.orElse("null"), name.orElse("null"));
    }

    @RequestMapping("/api/book5")
    @ResponseBody
    public String getBooks5(@RequestParam(value = "id", defaultValue = "default") String bookId, @RequestParam(defaultValue = "default") String name) {
        return String.format("id: %s; name: %s", bookId, name);
    }

    @RequestMapping("/api/book6")
    @ResponseBody
    public String getBooks6(@RequestParam Map<String,String> allParams) {
        return  allParams.entrySet().stream()
                .map(entry -> String.format("name: %s, value:%s ", entry.getKey(),  entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @RequestMapping("/api/book7")
    @ResponseBody
    public String getBooks7(@RequestParam List<String> ids) {
        return  String.join(",", ids);
    }
}
