package com.project.pygrader.controller;

import com.project.pygrader.entity.Question;
import com.project.pygrader.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/questions")
@ResponseBody
public class QuestionsController {
    @Autowired
    private QuestionService questionService;
    @PostMapping
    public String uploadQuestions(@RequestBody Question questions) {
        return questionService.saveQuestions(questions);

    }

    
}
