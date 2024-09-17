package com.project.pygrader.repository;

import com.project.pygrader.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findStudentByMatric(String matric);
}