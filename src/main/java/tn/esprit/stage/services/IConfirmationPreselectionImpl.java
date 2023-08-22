package tn.esprit.stage.services;

import tn.esprit.stage.entities.ConfirmationPreselection;
import tn.esprit.stage.entities.Student;

import java.util.List;

public interface IConfirmationPreselectionImpl {
    ConfirmationPreselection addConfirmation(ConfirmationPreselection cp, Student s);
    ConfirmationPreselection confirmStudent(ConfirmationPreselection cp, Student s);
    ConfirmationPreselection preselectStudent(ConfirmationPreselection cp, Student s);
    List<ConfirmationPreselection> showAllConfirmationPreselection();

    ConfirmationPreselection showConfirmationPreselection(Long id);
}
