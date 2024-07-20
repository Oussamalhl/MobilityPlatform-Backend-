package tn.esprit.stage.services;

import tn.esprit.stage.entities.EmailDetails;

public interface IEmailsService {
	
	String sendSimpleMail(EmailDetails details);
	String sendMailWithAttachment(EmailDetails details);

}
