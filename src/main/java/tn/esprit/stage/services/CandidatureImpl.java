package tn.esprit.stage.services;

import java.time.LocalDate;
import java.util.Date;
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
    ContactPersonRep cprep;
    @Autowired
    SendingInstitutionRep sirep;


    @Override
    public Candidature addCandidature(Candidature cand, Long idcp) {

        ContactPerson cnp = cprep.findById(idcp).get();

//		ConfirmationPreselection cp = new ConfirmationPreselection();
		Student s = ss.addStudent(cand.getStudent());
//		cp.setCpstudent(s);
		cand.setStudent(s);
        cand.setConfirmed(false);
        cand.setPreselected(false);
        ris.addReceivingInstitution(cand.getReceivinginstitution(), cand.getReceivinginstitution().getContactperson());
        sis.addSendingInstitution(cand.getSendinginstitution(), cnp);
        return crep.save(cand);
    }

    @Override
    public void preselectCandidature(Candidature cand) {
        crep.preselectStudent(cand.getId(), cand.getStudent().getId());
    }
    @Override
    public List<Candidature> retrieveStudentCandidatures(Candidature cand) {
        return crep.retrieveStudentCandidatures(cand.getStudent().getId());
    }
    @Override
    public void confirmCandidature(Candidature cand) {
        LocalDate localDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);
        cand.setConfirmationD(date);
        crep.confirmStudent(cand.getId(), cand.getStudent().getId());
    }

    @Override
    public List<Candidature> showAllCandidature() {
        return (List<Candidature>) crep.findAll();
    }

    @Override
    public Candidature UpdateCandidature(Candidature cand) {
        return crep.save(cand);
    }

    @Override
    public void deleteCandidature(Long id) {
        crep.deleteById(id);
    }

    @Override
    public Candidature showCandidature(Long id) {
        return crep.findById(id).get();

    }
}
