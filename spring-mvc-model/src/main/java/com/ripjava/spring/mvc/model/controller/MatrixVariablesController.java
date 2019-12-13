package com.ripjava.spring.mvc.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MatrixVariablesController {

    @RequestMapping(value = "/mv/{author}", method = RequestMethod.GET)
    @ResponseBody
    public String dotPathVariable2(@MatrixVariable(required = true) String author) {
        return String.format("author: %s ", author);
    }

    @RequestMapping(value = "/mv2/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String dotPathVariable2(
            @PathVariable String name,
            @MatrixVariable String author) {
        return String.format("book: %s ;author: %s ", name, author);
    }

    @RequestMapping(value = "/mv3/{book}", method = RequestMethod.GET)
    @ResponseBody
    public String dotPathVariable3(
            @MatrixVariable Map<String, String> matrixVars) {
        //http://localhost:8080/mv3/author=pei;year=2019;name=ripjava;id=01214
        return String.format("author:%s; year:%s; name:%s; id:%s",
                matrixVars.get("author"),
                matrixVars.get("year"),
                matrixVars.get("name"),
                matrixVars.get("id") );
    }

    @RequestMapping(value = "/mv4/store/{store}/book/{book}", method = RequestMethod.GET)
    @ResponseBody
    public String dotPathVariable4(
            @MatrixVariable(value="name", pathVar="store") String storeName ) {
        return String.format("store name: %s", storeName);
    }
}
