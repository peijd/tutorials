package com.ripjava.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
@Scope("prototype")
public class SchoolNotification {
    @Autowired
    Grader grader;

    private String name;
    private Collection<Integer> marks;

    public SchoolNotification(String name) {
        this.name = name;
        this.marks = new ArrayList<Integer>();
    }

    public String addMark(Integer mark) {
        this.marks.add(mark);
        return this.grader.grade(this.marks);
    }

    public Grader getGrader() {
        return grader;
    }

    public void setGrader(Grader grader) {
        this.grader = grader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Integer> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Integer> marks) {
        this.marks = marks;
    }
}
