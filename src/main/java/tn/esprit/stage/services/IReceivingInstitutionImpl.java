package tn.esprit.stage.services;

import tn.esprit.stage.entities.ContactPerson;
import tn.esprit.stage.entities.ReceivingInstitution;

public interface IReceivingInstitutionImpl {
	
	ReceivingInstitution addReceivingInstitution(ReceivingInstitution ri,ContactPerson cp);
	ReceivingInstitution showReceivingInstitution(Long id);

}
