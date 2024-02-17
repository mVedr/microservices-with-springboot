package com.mvedr.quizservice.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quiz;

    //Will not be saved in the database
    transient private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> list) {
        this.questions = list;
    }

    public Quiz(Long id, String quiz, List<Question> questions) {
        this.id = id;
        this.quiz = quiz;
        this.questions = questions;
    }

    public Quiz() {
    }
}
