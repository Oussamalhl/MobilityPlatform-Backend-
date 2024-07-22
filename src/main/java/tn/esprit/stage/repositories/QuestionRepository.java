package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stage.entities.Question;
@Repository
public interface QuestionRepository extends CrudRepository<Question,Long> {
}
