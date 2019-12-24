package com.ripjava.spring.mvc.model.controller;

import com.ripjava.spring.mvc.model.domain.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestBodyController {
    @PostMapping("/request")
    @ResponseBody
    public String postController(
            @RequestBody LoginForm loginForm) {

        return loginForm.toString();
    }
}
