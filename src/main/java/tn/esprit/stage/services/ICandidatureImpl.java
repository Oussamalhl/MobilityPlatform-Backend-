package tn.esprit.stage.services;

import java.util.List;

import tn.esprit.stage.entities.Candidature;

public interface ICandidatureImpl {
	
	Candidature addCandidature(Candidature cand, Long idcp);
	List<Candidature> showAllCandidature();
	Candidature UpdateCandidature(Candidature cand);
	void deleteCandidature(Long id);
	Candidature showCandidature(Long id);

}
