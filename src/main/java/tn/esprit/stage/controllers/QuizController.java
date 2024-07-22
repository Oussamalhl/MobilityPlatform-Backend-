package tn.esprit.stage.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stage.entities.Quiz;
import tn.esprit.stage.services.AnswerService;
import tn.esprit.stage.services.QuestionService;
import tn.esprit.stage.services.QuizService;

@RestController
public class QuizController {
    @Autowired
    QuizService qs;
    @Autowired
    QuestionService qqs;
    @Autowired
    AnswerService as;

    @GetMapping("/{idCand}/getQuiz")
    public Quiz getQuiz(@PathVariable Long idCand){
        return qs.getQuiz(idCand);
    }

    @GetMapping("/{idCand}/viewQuiz")
    public Quiz getQuizV(@PathVariable Long idCand){
        return qs.getQuiz(idCand);
    }

    @PostMapping("/{idCand}/setQuiz")
    public Quiz updateCandidatureQuiz(@PathVariable Long idCand, @RequestBody Quiz q){
        return qs.addQuiz(q, idCand);
    }

    @PostMapping("/{idCand}/submitQuizAnswers")
    public int addAnswer(@RequestBody Quiz q,@PathVariable Long idCand){
        return qs.submitQuizAnswers(q,idCand);
    }
}
