package com.project.pycoder.repository;

import com.project.pycoder.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByMatric(String matric);
}