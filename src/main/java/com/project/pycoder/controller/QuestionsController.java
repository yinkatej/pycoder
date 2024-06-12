package com.project.pycoder.controller;

import com.project.pycoder.entity.Questions;
import com.project.pycoder.repository.QuestionsRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
@ResponseBody
public class QuestionsController {

    private final QuestionsRepository questionsRepository;

    public QuestionsController(QuestionsRepository repository){
        questionsRepository = repository;
    }
    @PostMapping
    public String uploadQuestions(@RequestBody String questions){
        questionsRepository.save(new Questions(questions));
        return "Question saved";
    }
}
