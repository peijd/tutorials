package com.ripjava.spring.mvc.model.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RequestHeaderController {

    @GetMapping("/RequestHeader/AcceptEncoding")
    @ResponseBody
    public String handle(@RequestHeader("Accept-Encoding") String encoding){
        return String.format("RequestHeader:  Accept-Encoding - %s", encoding);
    }

    @GetMapping("/RequestHeader/NumberType")
    @ResponseBody
    public String handleNumber(@RequestHeader("Header-Number") int number){
        return String.format("RequestHeader: Header-Number - %s", number);
    }

    @GetMapping("/RequestHeader/Map")
    @ResponseBody
    public String handleMap(@RequestHeader Map<String, String> headers){
        StringBuilder sb = new StringBuilder();
        headers.forEach((key, value) -> {
            sb.append(String.format("RequestHeader: '%s' = %s", key, value))
                    .append(System.lineSeparator());
        });
        return  sb.toString();
    }

    @GetMapping("/RequestHeader/MultiValueMap")
    @ResponseBody
    public String handleMap(@RequestHeader MultiValueMap<String, String> headers){
        StringBuilder sb = new StringBuilder();
        headers.forEach((key, value) -> {
            sb.append(String.format("RequestHeader: '%s' = %s", key, value.stream().collect(Collectors.joining("|"))))
                    .append(System.lineSeparator());
        });
        return  sb.toString();
    }


    @GetMapping("/RequestHeader/HttpHeaders")
    @ResponseBody
    public String handleMap(@RequestHeader HttpHeaders headers){
        InetSocketAddress host = headers.getHost();
        return "http://" + host.getHostName() + ":" + host.getPort();
    }


    @GetMapping("/RequestHeader/WithName")
    @ResponseBody
    public String handleWithName(@RequestHeader(name = "Accept-Encoding") String encoding){
        return String.format("RequestHeader:  Accept-Encoding - %s", encoding);
    }

    @GetMapping("/RequestHeader/WithValue")
    @ResponseBody
    public String handleWithValue(@RequestHeader(value = "Accept-Encoding") String encoding){
        return String.format("RequestHeader:  Accept-Encoding - %s", encoding);
    }

    @GetMapping("/RequestHeader/NonRequiredHeader")
    public String handleNonRequiredHeader(
            @RequestHeader(value = "optional-header", required = false) String optionalHeader) {
        return String.format("RequestHeader:  optional-header - %s", optionalHeader);
    }

    @GetMapping("/RequestHeader/OptionalRequiredHeader")
    public String handleOptionalRequiredHeader(
            @RequestHeader(value = "optional-header") Optional<String> optionalHeader) {
        return String.format("RequestHeader:  optional-header - %s", optionalHeader);
    }

    @GetMapping("/RequestHeader/DefaultHeader")
    public String handleDefaultHeader(
            @RequestHeader(value = "optional-header", defaultValue ="test") String optionalHeader) {
        return String.format("RequestHeader:  optional-header - %s", optionalHeader);
    }

}
