package com.project.pygrader.controller;

import com.project.pygrader.entity.Student;
import com.project.pygrader.model.AddStudentModel;
import com.project.pygrader.model.DetailsAndQuestion;
import com.project.pygrader.model.Grade;
import com.project.pygrader.model.LogInModel;
import com.project.pygrader.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@Controller

// @ResponseBody
public class StudentController {

    StudentService studentService;
    DetailsAndQuestion detailsAndQuestion;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("login", new LogInModel());
        return "home";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("login") LogInModel login, Model model) {
        try {
            detailsAndQuestion = studentService.findByMatric(login);
        } catch (Exception e) {
            model.addAttribute("error", "Invalid username or password");
            return "home";
        }

        return "redirect:/program";
    }

    @GetMapping("/program")
    public String program(Model model) {

        if (detailsAndQuestion == null)
            return "redirect:/";
        try {
            var d = detailsAndQuestion;
            model.addAttribute("name", String.format("%s %s", d.getMatric(), d.getName()));
            model.addAttribute("question", d.getQuestion());
            model.addAttribute("description", d.getDescription());
            model.addAttribute("initialCode", d.getInitialCode());
            model.addAttribute("test", d.getTestCase());
            model.addAttribute("output", d.getOutput());
            model.addAttribute("matric", d.getMatric());

        } catch (Exception e) {
            return "redirect:/";
        }
        detailsAndQuestion = null;
        return "program";
    }

    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody AddStudentModel student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.valueOf(200));
    }

    @PostMapping("/post")
    public String postMethodName(@RequestBody Grade grade) {
        studentService.saveGrade(grade);
        return "redirect:/";
    }
    @GetMapping("/adminstrator")
    public String getMethodName() {
        return "admin";
    }
    

}
