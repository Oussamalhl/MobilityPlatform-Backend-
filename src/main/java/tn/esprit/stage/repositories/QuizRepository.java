package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stage.entities.Quiz;

@Repository
public interface QuizRepository extends CrudRepository<Quiz,Long> {
}
