package com.ripjava.servlet.mvc.service;

import com.ripjava.servlet.mvc.model.Student;

import java.util.Optional;

public class StudentService {

    public Optional<Student> getStudent(int id) {
        switch (id) {
            case 1:
                return Optional.of(new Student(1, "Li", "A"));
            case 2:
                return Optional.of(new Student(2, "Sun", "B"));
            case 3:
                return Optional.of(new Student(3, "Song", "C"));
            default:
                return Optional.empty();
        }
    }
}