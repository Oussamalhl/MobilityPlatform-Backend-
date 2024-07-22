package tn.esprit.stage.services;

import tn.esprit.stage.entities.Quiz;

public interface QuizService {
    Quiz addQuiz(Quiz quiz, Long candId);
    int submitQuizAnswers(Quiz quiz, Long candId);
    Quiz getQuiz(Long candId);

}
