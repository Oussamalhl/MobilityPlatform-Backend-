package tn.esprit.stage.services;

import tn.esprit.stage.entities.Answer;

public interface AnswerService {
    Answer addAnswer(Answer answer, Long idQuestion);
    void deleteAnswer(Answer answer);
    Answer updateAnswer(Answer answer);

}
