package com.project.pygrader.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "faculty")
@Data
@NoArgsConstructor
public class Faculty {
    @Id
    private String id;
    private String facultyName;
}
