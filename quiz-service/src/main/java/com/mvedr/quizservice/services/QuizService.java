package com.mvedr.quizservice.services;

import java.util.List;

import com.mvedr.quizservice.entity.Quiz;

public interface QuizService {
    
    Quiz add(Quiz quiz);
    List<Quiz> get();
    Quiz getById(Long id);
}
