package tn.esprit.stage.repositories;
import tn.esprit.stage.entities.Candidature;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CandidatureRep extends CrudRepository<Candidature,Long> {
	@Query(value ="SELECT id FROM candidature",nativeQuery = true)
	public List<Long> retrieveCandidatures();
	

}
