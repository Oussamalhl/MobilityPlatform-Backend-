package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.stage.entities.SendingInstitution;
@Repository
public interface SendingInstitutionRep extends CrudRepository <SendingInstitution,Long> {

}
