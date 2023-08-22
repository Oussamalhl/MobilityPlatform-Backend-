package tn.esprit.stage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.stage.entities.*;
import tn.esprit.stage.repositories.CandidatureRep;
import tn.esprit.stage.repositories.ContactPersonRep;
import tn.esprit.stage.repositories.SendingInstitutionRep;

@Service
public class CandidatureImpl implements ICandidatureImpl {
	
	@Autowired
	CandidatureRep crep;
	@Autowired
	StudentImpl ss;
	@Autowired
	ReceivingInstitutionImpl ris;
	@Autowired
	SendingInstitutionImpl sis;
	@Autowired
	ConfirmationPreselectionImpl cps;
	@Autowired
	ContactPersonRep cprep;
	@Autowired
	SendingInstitutionRep sirep;
	
	
	@Override
	public Candidature addCandidature(Candidature cand, Long idcp) {

		ContactPerson cnp =cprep.findById(idcp).get();
		System.out.println(cnp);
		System.out.println(cand);

		ConfirmationPreselection cp = new ConfirmationPreselection();
		Student s = ss.addStudent(cand.getStudent());
		cp.setCpstudent(s);
		cps.addConfirmation(cp,s);

		ris.addReceivingInstitution(cand.getReceivinginstitution(),cand.getReceivinginstitution().getContactperson());
		sis.addSendingInstitution(cand.getSendinginstitution(),cnp);

		
		// TODO Auto-generated method stub
		return crep.save(cand);
	}
	@Override
	public List<Candidature> showAllCandidature() {
		// TODO Auto-generated method stub
		return ( List<Candidature>) crep.findAll() ;
	}
	@Override
	public Candidature UpdateCandidature(Candidature cand) {
		// TODO Auto-generated method stub
		return crep.save(cand);
	}
	@Override
	public void deleteCandidature(Long id) {
		// TODO Auto-generated method stub
		crep.deleteById(id);
	}
	@Override
	public Candidature showCandidature(Long id) {
		// TODO Auto-generated method stub
		return crep.findById(id).orElse(null);

}
}
