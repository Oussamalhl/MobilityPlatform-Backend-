package tn.esprit.stage.services;

import tn.esprit.stage.entities.Question;

public interface QuestionService {
    Question addQuestion(Question question, Long quizId);
    void deleteQuestion(Question question);
}
