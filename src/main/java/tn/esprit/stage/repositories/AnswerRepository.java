package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stage.entities.Answer;
@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long> {
}
