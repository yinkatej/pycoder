package com.project.pycoder.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String matric;
    private String surname;
    private String firstName;
    private String otherName;
    private String email;



    public Student(String matric, String surname, String firstName, String otherName, String email) {
        this.matric = matric;
        this.surname = surname;
        this.firstName = firstName;
        this.otherName = otherName;
        this.email = email;

    }
    public Student(String matric, String surname, String firstName, String otherName) {
        this(firstName, otherName, surname, matric, "");
    }


}
