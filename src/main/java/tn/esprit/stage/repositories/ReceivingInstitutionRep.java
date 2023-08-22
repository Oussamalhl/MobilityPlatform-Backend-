package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.stage.entities.ReceivingInstitution;
@Repository
public interface ReceivingInstitutionRep extends CrudRepository<ReceivingInstitution,Long> {

}
