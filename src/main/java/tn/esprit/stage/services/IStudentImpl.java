package tn.esprit.stage.services;

import java.util.List;

import tn.esprit.stage.entities.Student;

public interface IStudentImpl {
	
	Student addStudent(Student stud);
	List<Student> showAllStudent();
	Student showStudent(Long id);

}
