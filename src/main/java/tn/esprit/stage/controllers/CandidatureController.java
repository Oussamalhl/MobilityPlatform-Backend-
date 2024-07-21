package tn.esprit.stage.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import tn.esprit.stage.entities.Candidature;
import tn.esprit.stage.entities.ContactPerson;
import tn.esprit.stage.entities.ReceivingInstitution;
import tn.esprit.stage.entities.SendingInstitution;
import tn.esprit.stage.repositories.CandidatureRep;
import tn.esprit.stage.repositories.SendingInstitutionRep;
import tn.esprit.stage.services.ICandidatureImpl;
import tn.esprit.stage.services.IContactPersonImpl;
import tn.esprit.stage.services.IReceivingInstitutionImpl;
import tn.esprit.stage.services.ISendingInstitutionImpl;


@RestController
public class CandidatureController {

    @Autowired
    ICandidatureImpl cs;
    @Autowired
    CandidatureRep crep;
    @Autowired
    IContactPersonImpl cps;
    @Autowired
    ISendingInstitutionImpl sis;
    @Autowired
    IReceivingInstitutionImpl ris;
    @Autowired
    SendingInstitutionRep sirep;

    @PostMapping("/addCand")
    public Candidature addCandidature(@RequestBody Candidature c) {

        return cs.addCandidature(c);
    }
    @PostMapping("/affSCP")
    public Candidature affectSContactPerson(@RequestParam Long idCand, @RequestParam Long idSCP) {
        return cs.affectSConactPerson(idCand, idSCP);
    }
    @PostMapping("/confCand")
    public Candidature confirmCandidature(@RequestBody Candidature c) {
        cs.confirmCandidature(c);
        return c;
    }

    @PostMapping("/presCand")
    public Candidature preselectCandidature(@RequestBody Candidature c) {
        cs.preselectCandidature(c);
        return c;
    }
    @PostMapping("/reConfCand")
    public Candidature removeConfirmation(@RequestBody Candidature c) {
        cs.removeConfirmation(c);
        return c;
    }

    @PostMapping("/rePresCand")
    public Candidature removeSelection(@RequestBody Candidature c) {
        cs.removeSelection(c);
        return c;
    }
    @PostMapping("/studCands")
    public List<Candidature> studentCandidature(@RequestBody Candidature c) {
        return cs.retrieveStudentCandidatures(c);
    }

    @GetMapping("/getReceivInst")
    public ReceivingInstitution getReceivingInstitution(@RequestParam Long id) {
        return ris.showReceivingInstitution(id);
    }

    @GetMapping("/getSendInst")
    public SendingInstitution getSendingInstitution(@RequestParam Long id) {
        return sis.showSendingInstitution(id);
    }

    @GetMapping("/getCand")
    public Candidature getCandidatures(@RequestParam Long id) {
        return cs.showCandidature(id);
    }

    @GetMapping("/ShowCand")
    public List<Candidature> showAllCandidature() {
        System.out.println(crep.retrieveCandidatures());
        return cs.showAllCandidature();
        //return crep.retrieveCandidatures();
    }

    @GetMapping("/showcps")
    public List<ContactPerson> showAllContactPerson() {
        return cps.showAllContactPerson();
    }

    @GetMapping("/showcp")
    public ContactPerson showContactPerson(@RequestParam Long id) {
        return cps.showContactPerson(id);
    }

	/*@PutMapping("/setcp")
	public SendingInstitution setContactPerson(@RequestParam Long id){
		SendingInstitution si = sirep.findById(id).get();
		return  sis.setContactPerson(cps.showContactPerson(id)).setSendinginstitution();
	}*/


}
