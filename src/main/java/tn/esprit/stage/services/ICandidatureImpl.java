package tn.esprit.stage.services;

import java.util.List;

import tn.esprit.stage.entities.Candidature;

public interface ICandidatureImpl {
	
	Candidature addCandidature(Candidature cand);
	List<Candidature> showAllCandidature();
	Candidature UpdateCandidature(Candidature cand);
	void deleteCandidature(Long id);
	Candidature showCandidature(Long id);
	void preselectCandidature(Candidature cand) throws Exception;
	void confirmCandidature(Candidature cand) throws Exception;
	List<Candidature> retrieveStudentCandidatures(Candidature cand);
	Candidature affectSConactPerson(Long idCand, Long idSCP);
	void removeConfirmation(Candidature cand);
	void removeSelection(Candidature cand);
}
