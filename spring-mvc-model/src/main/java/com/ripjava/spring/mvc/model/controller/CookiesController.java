package com.ripjava.spring.mvc.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cookies/")
public class CookiesController {


    @GetMapping("/")
    @ResponseBody
    public String readCookie(@CookieValue(value = "username") String username) {
        return "readCookie: username: " + username;
    }

    @GetMapping("/op1")
    @ResponseBody
    public String readCookie1(@CookieValue(value = "username", required = false) String username) {
        return "readCookie: username: " + username;
    }

    @GetMapping("/op2")
    @ResponseBody
    public String readCookie2(@CookieValue(value = "username") Optional<String> username) {
        return "readCookie: username: " + username.orElse("not set");
    }

    @GetMapping("/df")
    @ResponseBody
    public String readCookie3(@CookieValue(value = "username", defaultValue = "test") String username) {
        return "readCookie: username: " + username;
    }


    @GetMapping("/all")
    @ResponseBody
    public String readAllCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }
        return "No cookies";
    }

}
