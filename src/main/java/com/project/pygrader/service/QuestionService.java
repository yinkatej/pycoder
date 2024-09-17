package com.project.pygrader.service;

import com.project.pygrader.entity.Question;
import com.project.pygrader.repository.QuestionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.random.RandomGenerator;


@Service
@AllArgsConstructor
public class QuestionService {

    private QuestionsRepository questionRepository;



    public String saveQuestions(Question question) {
        Question newQuestion = new Question();
        newQuestion.setQuestion(question.getQuestion());
        newQuestion.setInitialCode(question.getInitialCode());
        newQuestion.setDescription(question.getDescription());
        newQuestion.setTitle(question.getTitle());
        newQuestion.setTests(question.getTests());
        questionRepository.save(newQuestion);
        return "Questions saved successfully";
    }

    public Question getQuestions(String title) {
         int rand = RandomGenerator.getDefault().nextInt(1, 4);
        return questionRepository.findByUnique(rand).orElse(null);
    }


}
