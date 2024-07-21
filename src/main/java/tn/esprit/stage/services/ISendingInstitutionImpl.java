package tn.esprit.stage.services;

import tn.esprit.stage.entities.ContactPerson;
import tn.esprit.stage.entities.SendingInstitution;

public interface ISendingInstitutionImpl {
	SendingInstitution showSendingInstitution(Long id);
	SendingInstitution addSendingInstitution(SendingInstitution si);
	SendingInstitution setContactPerson(SendingInstitution si,ContactPerson cp);

}
