package com.mvedr.questionservice.services;

import java.util.List;

import com.mvedr.questionservice.enitity.Question;

public interface QuestionService {
    Question create(Question question);
    List<Question> get();
    Question getOne(Long id);
    List<Question> getQuestionsByQuiz(Long quizId);
}
