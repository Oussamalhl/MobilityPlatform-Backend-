package tn.esprit.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.stage.entities.Candidature;
import tn.esprit.stage.entities.ConfirmationPreselection;
import tn.esprit.stage.entities.Student;
import tn.esprit.stage.repositories.ConfirmationPreselectionRep;
import tn.esprit.stage.repositories.StudentRep;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ConfirmationPreselectionImpl implements IConfirmationPreselectionImpl{
    @Autowired
    StudentRep srep;
    @Autowired
    StudentImpl ss;
    @Autowired
    ConfirmationPreselectionRep cprep;

    @Override
    public ConfirmationPreselection addConfirmation(ConfirmationPreselection cp, Student s){
        //cp.setCpstudent(s);
        cp.setConfirmed(false);
        cp.setPreselected(false);
        return cprep.save(cp);
    }
    @Override
    public ConfirmationPreselection confirmStudent(ConfirmationPreselection cp, Student s){
        cp.setConfirmed(true);
        LocalDate localDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);
        cp.setConfirmationD(date);
        return cprep.save(cp);

    }
    @Override
    public ConfirmationPreselection preselectStudent(ConfirmationPreselection cp, Student s){
        cp.setPreselected(true);
        LocalDate localDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);
        cp.setPreselectectionD(date);
        return cprep.save(cp);

    }

    @Override
    public List<ConfirmationPreselection> showAllConfirmationPreselection() {
        return ( List<ConfirmationPreselection>) cprep.findAll() ;
    }

    @Override
    public ConfirmationPreselection showConfirmationPreselection(Long id) {
        return cprep.findById(id).orElse(null);
    }

}
