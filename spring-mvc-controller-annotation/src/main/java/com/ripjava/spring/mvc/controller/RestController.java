package com.ripjava.spring.mvc.controller;

import com.ripjava.spring.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

    @GetMapping(value = "/student/{studentId}")
    public @ResponseBody
    Student getTestData(@PathVariable Integer studentId) {
        Student student = new Student();
        student.setName("jason");
        student.setId(studentId);

        return student;
    }
}
