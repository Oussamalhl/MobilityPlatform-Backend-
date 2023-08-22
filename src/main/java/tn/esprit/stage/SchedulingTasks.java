package tn.esprit.stage;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tn.esprit.stage.entities.ConfirmationPreselection;
import tn.esprit.stage.entities.EmailDetails;
import tn.esprit.stage.repositories.CandidatureRep;
import tn.esprit.stage.repositories.ConfirmationPreselectionRep;
import tn.esprit.stage.services.ICandidatureImpl;
import tn.esprit.stage.services.IConfirmationPreselectionImpl;
import tn.esprit.stage.services.IEmailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class SchedulingTasks {
	@Autowired
	IEmailsService es;
	@Autowired
	ICandidatureImpl cs ;
	@Autowired
	CandidatureRep crep;
	@Autowired
	ConfirmationPreselectionRep cprep;
	@Autowired
	IConfirmationPreselectionImpl cps;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private static final Logger log = LoggerFactory.getLogger(SchedulingTasks.class);
	
/*
	@Scheduled(fixedRate=30000)
	public void checkConfirmations(){
		int i;
		EmailDetails details = new EmailDetails();
		List<ConfirmationPreselection> cpList = cps.showAllConfirmationPreselection();
		System.out.println(cpList.size());
		for (i=0;i<cpList.size()-1;i++){
			if (cpList.get(i).getConfirmed()){
				System.out.println(i);
				details.setMsgBody("Congrats to "+cpList.get(i).getCpstudent().getFirstName());
				details.setRecipient(cpList.get(i).getCpstudent().getEmail());
				details.setSubject("confirmation "+cpList.get(i).getCpstudent().getId());
				System.out.println(details);

			}
		}
	}*/
	
	/*@Scheduled(fixedRate=5000)
	public void showTime(){
		log.info("The time is now {}", dateFormat.format(new Date()));
		
	}*/
	

}
