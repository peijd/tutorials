package com.ripjava.spring.mvc.model.controller;

import com.ripjava.spring.mvc.model.domain.LoginForm;
import com.ripjava.spring.mvc.model.domain.ResponseText;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {

    @PostMapping("/response")
    @ResponseBody
    public ResponseText postResponseController(
            @RequestBody LoginForm loginForm) {
        return new ResponseText("test ResponseBody");
    }
}
