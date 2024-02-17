package com.mvedr.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvedr.questionservice.enitity.Question;
import com.mvedr.questionservice.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getOne(id);
    }

    @GetMapping("/quiz/{qId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long qId){
        return questionService.getQuestionsByQuiz(qId);
    }

}
