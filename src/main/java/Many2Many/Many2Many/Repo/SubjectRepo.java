package Many2Many.Many2Many.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Many2Many.Many2Many.Model.Entity.SubjectEntity;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity, Long> {
   
	boolean existsBySubjectName(String subjectName);
	
}
