package tn.esprit.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.stage.entities.ContactPerson;
import tn.esprit.stage.entities.SendingInstitution;
import tn.esprit.stage.repositories.ContactPersonRep;
import tn.esprit.stage.repositories.SendingInstitutionRep;

@Service
public class SendingInstitutionImpl implements ISendingInstitutionImpl {
	
	@Autowired
	SendingInstitutionRep sirep;
	@Autowired
	ContactPersonRep cprep;

	@Override
	public SendingInstitution addSendingInstitution(SendingInstitution si,ContactPerson cp) {
		
		si.setContactperson(cp);

		// TODO Auto-generated method stub
		return sirep.save(si);
	

	}
	@Override
	public SendingInstitution setContactPerson(SendingInstitution si,ContactPerson cp) {

		// TODO Auto-generated method stub
		return sirep.save(si);


	}
}
