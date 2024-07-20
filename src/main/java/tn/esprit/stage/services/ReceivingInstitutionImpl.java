package tn.esprit.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.stage.entities.ContactPerson;
import tn.esprit.stage.entities.ReceivingInstitution;
import tn.esprit.stage.entities.SendingInstitution;
import tn.esprit.stage.repositories.ContactPersonRep;
import tn.esprit.stage.repositories.ReceivingInstitutionRep;

@Service
public class ReceivingInstitutionImpl implements IReceivingInstitutionImpl {
	
	@Autowired
	ReceivingInstitutionRep rirep;
	@Autowired
	ContactPersonRep cprep;

	@Override
	public ReceivingInstitution showReceivingInstitution(Long id) {

		// TODO Auto-generated method stub
		return rirep.findById(id).get();
	}

	@Override
	public ReceivingInstitution addReceivingInstitution(ReceivingInstitution ri,ContactPerson cp) {
		
		
		cprep.save(cp);
		// TODO Auto-generated method stub
		return rirep.save(ri);
	

	}
}