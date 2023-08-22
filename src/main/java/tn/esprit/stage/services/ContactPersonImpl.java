package tn.esprit.stage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.stage.entities.Candidature;
import tn.esprit.stage.entities.ContactPerson;
import tn.esprit.stage.repositories.ContactPersonRep;

import java.util.List;

@Service
public class ContactPersonImpl implements IContactPersonImpl {
	
	@Autowired
	ContactPersonRep cprep;

	
	@Override
	public ContactPerson addContactPerson(ContactPerson cp) {
		// TODO Auto-generated method stub
		return cprep.save(cp);
}
	@Override
	public List<ContactPerson> showAllContactPerson() {
		// TODO Auto-generated method stub
		return ( List<ContactPerson>) cprep.findAll();
	}

	@Override
	public ContactPerson showContactPerson(Long id) {
		// TODO Auto-generated method stub
		return cprep.findById(id).orElse(null);

	}
}
