package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.stage.entities.ContactPerson;
@Repository
public interface ContactPersonRep extends CrudRepository<ContactPerson,Long> {

}
