package tn.esprit.stage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.stage.entities.Candidature;
import tn.esprit.stage.entities.Student;
import tn.esprit.stage.services.StudentImpl;

@RestController
public class StudentController {
	@Autowired
	StudentImpl ss;
	@GetMapping("/ShowStudent")
	public List<Student> showAllCandidature(){	
		return ss.showAllStudent();			
	}

	@GetMapping("/showstudcand")
	public List<Candidature> showStudentsCands(@RequestParam Long id){
		List<Candidature> listcand;
		Student s = new Student();
		s=ss.showStudent(id);
		listcand=s.getCandidature();

		return listcand;
	}
}
