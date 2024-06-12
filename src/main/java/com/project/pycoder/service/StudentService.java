package com.project.pycoder.service;

import com.project.pycoder.config.ErrorResponse;
import com.project.pycoder.entity.Questions;
import com.project.pycoder.entity.Student;
import com.project.pycoder.model.AddStudentModel;
import com.project.pycoder.model.DetailsAndQuestion;
import com.project.pycoder.model.LogInModel;
import com.project.pycoder.repository.QuestionsRepository;
import com.project.pycoder.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service

public class StudentService {

    private final QuestionsRepository questionsRepository;
    private final StudentRepository studentRepository;

    public StudentService(QuestionsRepository questionsRepository, StudentRepository studentRepository) {
        this.questionsRepository = questionsRepository;
        this.studentRepository = studentRepository;
    }


    public Student addStudent(AddStudentModel student) {
        Student entity = new Student(student.matric(), student.surname(), student.firstName(), student.otherName(), student.email());
        return studentRepository.save(entity);
    }

    public DetailsAndQuestion findByMatric(LogInModel model) throws ErrorResponse {
        Student student = studentRepository.findStudentByMatric(model.getUsername());
        Questions questions = questionsRepository.findById(1L).orElseThrow();
        return
                new DetailsAndQuestion(student, questions.getQuestion());
    }
}
