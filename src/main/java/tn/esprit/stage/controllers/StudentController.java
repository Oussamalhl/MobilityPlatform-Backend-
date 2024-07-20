package tn.esprit.stage.controllers;

import java.util.List;
import java.util.Set;

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
	@GetMapping("/ShowStudents")
	public List<Student> showAllCandidature(){	
		return ss.showAllStudent();			
	}
	@GetMapping("/ShowStud")
	public Student showStudent(@RequestParam Long id){
		return ss.showStudent(id);
	}
//	@GetMapping("/showstudcand")
//	public Set<Candidature> showStudentsCands(@RequestParam Long id){
//		Set<Candidature> listcand;
//		Student s = new Student();
//		s=ss.showStudent(id);
//		listcand=s.getCandidatures();
//
//		return listcand;
//	}
}
