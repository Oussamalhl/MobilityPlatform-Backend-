package tn.esprit.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stage.entities.Answer;
import tn.esprit.stage.entities.Candidature;
import tn.esprit.stage.entities.Question;
import tn.esprit.stage.entities.Quiz;
import tn.esprit.stage.repositories.AnswerRepository;
import tn.esprit.stage.repositories.CandidatureRep;
import tn.esprit.stage.repositories.QuestionRepository;
import tn.esprit.stage.repositories.QuizRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizRepository qr;
    @Autowired
    CandidatureRep cr;
    @Autowired
    QuestionRepository qqr;
    @Autowired
    AnswerRepository ar;


    @Override
    public Quiz addQuiz(Quiz quiz, Long candId) {
        Candidature candidature = cr.findById(candId).get();
        if (candidature != null) {
            if (candidature.getQuiz() != null) {
                Quiz old_quiz = qr.findById(candidature.getQuiz().getQuizId()).get();
                candidature.setQuiz(null);
                cr.save(candidature);
                qr.delete(old_quiz);
            }
            quiz = qr.save(quiz);
            candidature.setQuiz(quiz);
            cr.save(candidature);
            for (Question q : quiz.getQuestions()) {
                q.setQuiz(quiz);
                Question qua = qqr.save(q);
                for (Answer a : q.getAnswers()) {
                    a.setQuestion(qua);
                    ar.save(a);
                }
            }

            return quiz;
        }
        return null;

    }

    @Override
    public int submitQuizAnswers(Quiz quiz, Long candId) {
        Candidature candidature = cr.findById(candId).get();
        Quiz quiz_orig = qr.findById(quiz.getQuizId()).get();
        final int[] correct = {0};
        final int[] wrong = {0};
        double score = 0.0;
        int final_score = 0;
        quiz_orig.getQuestions().forEach(question -> {
            quiz.getQuestions().forEach(q_question -> {
                if (q_question.getIdQuestion() == question.getIdQuestion()) {
                    if (q_question.getAnswers().equals(question.getAnswers())) correct[0] += 1;
                    else wrong[0] += 1;
                }
            });
        });
        score = (correct[0] * 1.0 / (correct[0] + wrong[0])) * 100;
        final_score = (int) score;
        candidature.setQuizPass(quiz_orig.getRequiredToSuccess() <= final_score);
        cr.save(candidature);
        return final_score;
    }

    @Override
    public Quiz getQuiz(Long candId) {
        Quiz quiz = cr.findById(candId).get().getQuiz();
        return quiz;
    }
}