package tn.esprit.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stage.entities.Answer;
import tn.esprit.stage.entities.Question;
import tn.esprit.stage.repositories.AnswerRepository;
import tn.esprit.stage.repositories.QuestionRepository;

@Service
public class AnswerServiceImpl implements AnswerService{
    @Autowired
    QuestionRepository qr;
    @Autowired
    AnswerRepository ar;

    @Override
    public Answer addAnswer(Answer answer, Long idQuestion) {
        Question question = qr.findById(idQuestion).orElse(null);
        answer.setQuestion(question);
        return ar.save(answer);
    }

    @Override
    public void deleteAnswer(Answer answer) {
        ar.delete(answer);
    }

    @Override
    public Answer updateAnswer(Answer answer) {
        return ar.save(answer);
    }
}
