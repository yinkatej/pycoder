package com.project.pygrader.service;

import com.project.pygrader.config.ErrorResponse;
import com.project.pygrader.entity.Question;
import com.project.pygrader.entity.Student;
import com.project.pygrader.model.AddStudentModel;
import com.project.pygrader.model.DetailsAndQuestion;
import com.project.pygrader.model.Grade;
import com.project.pygrader.model.LogInModel;
import com.project.pygrader.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    private final StudentRepository studentRepository;
    private final QuestionService questionService;

    public StudentService( StudentRepository studentRepository,QuestionService questionService) {
        this.studentRepository = studentRepository;
        this.questionService = questionService;

    }


    public Student addStudent(AddStudentModel student) {
        Student entity = new Student(student.matric(), student.surname(), student.firstName(), student.otherName(), student.email());
        return studentRepository.save(entity);
    }

    public DetailsAndQuestion findByMatric(LogInModel model) throws ErrorResponse {
        Student student = studentRepository.findStudentByMatric(model.getUsername());
        if (!model.getPassword().equals(student.getSurname().toUpperCase()))
             throw new ErrorResponse("");
        String title = "factorial";
        Question questions = questionService.getQuestions(title);
        
        return
                new DetailsAndQuestion(student, questions);
    }


    public void saveGrade(Grade grade) {
        Student student = studentRepository.findStudentByMatric(grade.getMatric());
        student.setScore(grade.getScore());
        studentRepository.save(student);
        System.out.println("Score saved successfully");
        }
}
