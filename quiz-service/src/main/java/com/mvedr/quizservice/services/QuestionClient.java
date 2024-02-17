package com.mvedr.quizservice.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mvedr.quizservice.entity.Question;

@FeignClient(name="QUESTION-SERVICE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);

}

