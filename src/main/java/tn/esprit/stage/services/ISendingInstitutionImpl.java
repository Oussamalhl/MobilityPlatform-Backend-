package tn.esprit.stage.services;

import tn.esprit.stage.entities.ContactPerson;
import tn.esprit.stage.entities.SendingInstitution;

public interface ISendingInstitutionImpl {
	
	SendingInstitution addSendingInstitution(SendingInstitution si,ContactPerson cp);
	SendingInstitution setContactPerson(SendingInstitution si,ContactPerson cp);

}
