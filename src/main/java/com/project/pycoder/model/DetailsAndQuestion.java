package com.project.pycoder.model;

import com.project.pycoder.entity.Questions;
import com.project.pycoder.entity.Student;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;
@Getter
public class DetailsAndQuestion {
    private String matric;
    private String name;
    private String department;
    private String questions;

    public DetailsAndQuestion(Student student, String questions){
        matric = student.getMatric();
        name = StringUtils.capitalize(String.format("%s %s %s", student.getSurname(),student.getFirstName(), student.getOtherName()));
        department = "";
        this.questions = questions;

    }
}
