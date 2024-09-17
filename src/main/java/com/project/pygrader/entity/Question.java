package com.project.pygrader.entity;


import com.project.pygrader.model.AddTests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    private String id;
    private int unique;
    private String topic;
    private String title;
    private String question;
    private String description;
    private String initialCode;

//   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "question")
   private List<AddTests> tests;
}
