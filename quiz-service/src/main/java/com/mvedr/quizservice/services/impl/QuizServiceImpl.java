package com.mvedr.quizservice.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvedr.quizservice.entity.Quiz;
import com.mvedr.quizservice.repository.QuizRepository;
import com.mvedr.quizservice.services.QuestionClient;
import com.mvedr.quizservice.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepository.findAll();

        List<Quiz> newList = quizzes.stream().map(quiz -> {
           quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
           return quiz;
        }).collect(Collectors.toList());
        return newList;
    }

    @Override
    public Quiz getById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionsOfQuiz(id));
        return quiz;
    }

}
