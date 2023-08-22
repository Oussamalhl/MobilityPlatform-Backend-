package tn.esprit.stage.services;

import tn.esprit.stage.entities.Candidature;
import tn.esprit.stage.entities.ConfirmationPreselection;
import tn.esprit.stage.entities.EmailDetails;

public interface IEmailsService {
	
	String sendSimpleMail(EmailDetails details);
	String sendMailWithAttachment(EmailDetails details);
	String sendConfirmationMail(EmailDetails details, ConfirmationPreselection cp);

}
