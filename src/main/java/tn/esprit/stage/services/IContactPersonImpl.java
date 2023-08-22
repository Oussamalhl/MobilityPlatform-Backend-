package tn.esprit.stage.services;

import tn.esprit.stage.entities.ContactPerson;

import java.util.List;

public interface IContactPersonImpl {

	ContactPerson addContactPerson(ContactPerson cp);
	List<ContactPerson> showAllContactPerson();
	ContactPerson showContactPerson(Long id);
}
