package tn.esprit.stage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.stage.entities.ConfirmationPreselection;
@Repository
public interface ConfirmationPreselectionRep extends CrudRepository<ConfirmationPreselection,Long> {
}
