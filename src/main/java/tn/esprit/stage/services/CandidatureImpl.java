package tn.esprit.stage.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.stage.entities.*;
import tn.esprit.stage.repositories.CandidatureRep;
import tn.esprit.stage.repositories.ContactPersonRep;
import tn.esprit.stage.repositories.QuizRepository;
import tn.esprit.stage.repositories.SendingInstitutionRep;

@Service
public class CandidatureImpl implements ICandidatureImpl {

    @Autowired
    CandidatureRep crep;
    @Autowired
    QuizRepository qrep;
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
    @Autowired
    IEmailingServiceImpl Es;

    @Override
    public Candidature addCandidature(Candidature cand) {

        //ContactPerson cnp = cprep.findById(idcp).get();

//		ConfirmationPreselection cp = new ConfirmationPreselection();
		Student s = ss.addStudent(cand.getStudent());
//		cp.setCpstudent(s);
		cand.setStudent(s);
        cand.setConfirmed(false);
        cand.setPreselected(false);
        ris.addReceivingInstitution(cand.getReceivinginstitution(), cand.getReceivinginstitution().getContactperson());
        sis.addSendingInstitution(cand.getSendinginstitution());
        return crep.save(cand);
    }
    @Override
    public Candidature affectSConactPerson(Long idCand, Long idSCP) {

        ContactPerson cnp = cprep.findById(idSCP).get();
        Candidature c = crep.findById(idCand).get();

        c.getSendinginstitution().setContactperson(cnp);
        return crep.save(c);
    }
    @Override
    public void preselectCandidature(Candidature cand) throws Exception {
        crep.preselectStudent(cand.getId(), cand.getStudent().getId());
        Quiz quiz = new Quiz();
        Candidature candidature = crep.findById(cand.getId()).get();
        candidature.setQuiz(qrep.save(quiz));
        Es.PreselectionMail(candidature);
        crep.save(candidature);
    }
    @Override
    public List<Candidature> retrieveStudentCandidatures(Candidature cand) {
        return crep.retrieveStudentCandidatures(cand.getStudent().getId());
    }
    @Override
    public void confirmCandidature(Candidature cand) throws Exception {
        Candidature candidature= crep.findById(cand.getId()).get();
        candidature.setConfirmationD(new Date());
        crep.confirmStudent(cand.getId(), cand.getStudent().getId());
        Es.ConfirmationMail(candidature);
        crep.save(candidature);
    }
    @Override
    public void removeConfirmation(Candidature cand) {
        crep.removeConfirmation(cand.getId(), cand.getStudent().getId());
    }
    @Override
    public void removeSelection(Candidature cand) {
        crep.removeSelection(cand.getId(), cand.getStudent().getId());
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
