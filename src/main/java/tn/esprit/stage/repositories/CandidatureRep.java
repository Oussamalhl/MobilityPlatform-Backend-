package tn.esprit.stage.repositories;
import org.springframework.data.jpa.repository.Modifying;
import tn.esprit.stage.entities.Candidature;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CandidatureRep extends CrudRepository<Candidature,Long> {
	@Query(value ="SELECT id FROM candidature",nativeQuery = true)
	List<Long> retrieveCandidatures();

	@Query(value ="SELECT * FROM candidature where student_id=?1",nativeQuery = true)
	List<Candidature> retrieveStudentCandidatures(Long student_id);
	@Modifying
	@Transactional
	@Query(value = "update candidature set preselected=true where id=?1 and student_id=?2", nativeQuery = true)
	void preselectStudent(Long id, Long student_id);
	@Modifying
	@Transactional
	@Query(value = "update candidature set confirmed=true where id=?1 and student_id=?2", nativeQuery = true)
	void confirmStudent(Long id, Long student_id);
	@Modifying
	@Transactional
	@Query(value = "update candidature set confirmed=false where id=?1 and student_id=?2", nativeQuery = true)
	void removeConfirmation(Long id, Long student_id);
	@Modifying
	@Transactional
	@Query(value = "update candidature set preselected=false where id=?1 and student_id=?2", nativeQuery = true)
	void removeSelection(Long id, Long student_id);
//	@Modifying
//	@Transactional
//	@Query(value = "update enrollment_student set preselected=true where candidature_id=?1 and student_id=?2", nativeQuery = true)
//	void preselectStudent(Long candidature_id, Long student_id);

}
