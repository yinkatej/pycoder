package com.project.pygrader.controller;

import com.project.pygrader.entity.Question;
import com.project.pygrader.entity.Student;
import com.project.pygrader.repository.QuestionsRepository;
import com.project.pygrader.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/admin")

public class ApiController {

    @Autowired
    private StudentRepository studentRepository;
    // private AdminRepository adminRepository;
    @Autowired
    QuestionsRepository questionsRepository;



//    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/student")
    public ResponseEntity<Student> getStudent(@RequestBody Map<String, String> param) {
        return new ResponseEntity<Student>(studentRepository.findStudentByMatric(param.get("matric")), HttpStatus.OK);

    }
    
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/question")
    public Question postMethodName(@RequestBody Map<String, String> entity) {

        return questionsRepository.findByTitle(entity.get("title")).orElse(null);
    }

}
