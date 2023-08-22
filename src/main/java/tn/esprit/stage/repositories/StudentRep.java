package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.stage.entities.Student;
@Repository
public interface StudentRep extends CrudRepository <Student,Long> {

}
