package com.mvedr.questionservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvedr.questionservice.enitity.Question;
import com.mvedr.questionservice.repository.QuestionRepository;
import com.mvedr.questionservice.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
       return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
       return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question not found !!!"));
    }

    @Override
    public List<Question> getQuestionsByQuiz(Long quizId) {
       return questionRepository.findByQuizId(quizId);
    }
    
}
