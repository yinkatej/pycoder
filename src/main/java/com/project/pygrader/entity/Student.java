package com.project.pygrader.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "student")
@Setter
@Getter
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    @Indexed(unique = true)
    private String matric;
    private String surname;
    private String firstName;
    private String otherName;
    private String email;
    private List<Integer> scores;


    public Student(String matric, String surname, String firstName, String otherName, String email) {
        this.matric = matric;
        this.surname = surname;
        this.firstName = firstName;
        this.otherName = otherName;
        this.email = email;
        scores = new ArrayList<>();

    }
    public Student(String matric, String surname, String firstName, String otherName) {
        this(firstName, otherName, surname, matric, "");
    }
    public void setScore(Integer score){
        scores.add(score);
    }

}
