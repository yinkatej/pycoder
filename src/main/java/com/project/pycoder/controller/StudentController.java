package com.project.pycoder.controller;


import com.project.pycoder.entity.Student;
import com.project.pycoder.model.AddStudentModel;
import com.project.pycoder.model.DetailsAndQuestion;
import com.project.pycoder.model.LogInModel;
import com.project.pycoder.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@ResponseBody
public class StudentController {

    StudentService studentService;
    DetailsAndQuestion detailsAndQuestion;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("login", new LogInModel());
        return "home";
    }

    @PostMapping("/")
    public String login(@ModelAttribute("login") LogInModel login, Model model){
        try {
            detailsAndQuestion = studentService.findByMatric(login);
//            System.out.println(detailsAndQuestion.getQuestions());
        }catch (Exception e){
            model.addAttribute("error", "Invalid username or password");
            return "home";
        }

        return "redirect:/program";
    }

    @GetMapping("/program")
    public String program(Model model){
        var d = detailsAndQuestion;
        model.addAttribute("name", String.format("%s %s", d.getMatric(), d.getName()));
        model.addAttribute("question", d.getQuestions());
        model.addAttribute("matric", d.getMatric());
        return "program";
    }



    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody AddStudentModel student) {
        return new ResponseEntity<>(studentService.addStudent(student),HttpStatus.valueOf(200));
    }
    //TODO FIND STUDENT BY MATRIC
    //TODO DELETE STUDENT BY MATRIC
    //TODO EDIT STUDENT BY MATRIC
    //TODO GET ALL STUDENTS

}
