package tn.esprit.stage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.stage.entities.Candidature;
import tn.esprit.stage.entities.Student;
import tn.esprit.stage.repositories.StudentRep;

@Service
public class StudentImpl implements IStudentImpl {
	@Autowired 
	StudentRep srep;
	
	@Override
	public Student addStudent(Student stud) {
	
		// TODO Auto-generated method stub
		return srep.save(stud);
	}

	@Override
	public List<Student> showAllStudent() {
		// TODO Auto-generated method stub
		return ( List<Student>) srep.findAll() ;
	}
	@Override
	public Student showStudent(Long id) {

		// TODO Auto-generated method stub
		return srep.findById(id).get();
	}
}
