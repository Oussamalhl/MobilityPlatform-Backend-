package tn.esprit.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stage.entities.Question;
import tn.esprit.stage.entities.Quiz;
import tn.esprit.stage.repositories.QuestionRepository;
import tn.esprit.stage.repositories.QuizRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository qr;
    @Autowired
    QuizRepository qzr;

    @Override
    public Question addQuestion(Question question, Long quizId) {
        Quiz qz = qzr.findById(quizId).orElse(null);
        question.setQuiz(qz);
        return qr.save(question);
    }

    @Override
    public void deleteQuestion(Question question) {
        qr.delete(question);

    }
}