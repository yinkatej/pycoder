package com.project.pygrader.model;

import com.project.pygrader.entity.Question;
import com.project.pygrader.entity.Student;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.util.List;
@Getter
public class DetailsAndQuestion {
    private String matric;
    private String name;
    private String department;
    private String question;
    private String initialCode;
    private String description;
    private String title;
    private String topic;
    List<String> testCase;
    List<String> output;

    public DetailsAndQuestion(Student student, Question questions) {
        matric = student.getMatric();
        question = questions.getQuestion();
        initialCode = questions.getInitialCode();
        description = questions.getDescription();
        name = StringUtils.capitalize(String.format("%s %s %s", student.getSurname(), student.getFirstName(),
                student.getOtherName().charAt(0)));
        department = "";
        topic = questions.getTopic();
        title = questions.getTitle();
        setTestCase(questions);
    }

    public void setTestCase(Question question){
        testCase = question.getTests().stream().map(AddTests::getInput).toList();
        output = question.getTests().stream().map(AddTests::getOutput).toList();
    }


    
}
