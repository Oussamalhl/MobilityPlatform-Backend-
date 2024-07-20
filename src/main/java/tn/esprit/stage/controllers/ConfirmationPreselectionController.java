package tn.esprit.stage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.stage.entities.ConfirmationPreselection;
import tn.esprit.stage.repositories.ConfirmationPreselectionRep;
import tn.esprit.stage.services.ConfirmationPreselectionImpl;

import java.util.List;

@RestController
public class ConfirmationPreselectionController {
    @Autowired
    ConfirmationPreselectionImpl cps;
    @Autowired
    ConfirmationPreselectionRep cprep;

    @PutMapping("/preselectStudent")
    public ResponseEntity<?> preselectStudent(@RequestBody ConfirmationPreselection cp){
        ConfirmationPreselection cp1 = cprep.findById(cp.getId()).get();

        cps.preselectStudent(cp1,cp1.getCpstudent());
        return ResponseEntity.ok("");

    }

    @PutMapping("/confirmStudent")
    public ResponseEntity<?> confirmStudent(@RequestBody ConfirmationPreselection cp){
        ConfirmationPreselection cp1 = cprep.findById(cp.getId()).get();

        cps.confirmStudent(cp1,cp1.getCpstudent());
        return ResponseEntity.ok("");

    }
    @GetMapping("/getcps")
    public List<ConfirmationPreselection> getAllConfirmationsPreselections(){

        return cps.showAllConfirmationPreselection();

    }
    @GetMapping("/getconfpres")
    public ConfirmationPreselection getConfirmationsPreselections(@RequestParam Long id){

        return cps.showConfirmationPreselection(id);

    }

}
