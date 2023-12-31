package Many2Many.Many2Many.Services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Many2Many.Many2Many.Model.Entity.StudentEntity;
import Many2Many.Many2Many.Model.Entity.SubjectEntity;
import Many2Many.Many2Many.Model.Request.studentRequest;
import Many2Many.Many2Many.Repo.StudentRepo;
import Many2Many.Many2Many.Repo.SubjectRepo;

@Service
public class studentService {

	private StudentRepo studentRepository;
	private SubjectRepo subjectRepository;
    @Autowired
	public studentService(StudentRepo studentRepository, SubjectRepo subjectRepository) {
		super();
		this.studentRepository = studentRepository;
		this.subjectRepository = subjectRepository;
	}
	
    public StudentEntity addData(studentRequest stuReq) {
//    	StudentEntity entityStu = this.studentRepository.save(stuReq.studentReqMethod());
    	StudentEntity entityStu = stuReq.studentReqMethod();
    	
    	// check validate of subject id in student request
    	List<SubjectEntity> sub1 = this.subjectRepository.findAllById(stuReq.getSubjectId());
    	Set<SubjectEntity> sub2 = Set.copyOf(sub1);
    	entityStu.setSubject(sub2);
    	return this.studentRepository.save(entityStu);
    }
	
    public StudentEntity  updateData(Long id, studentRequest stuReq) throws Exception {
    	StudentEntity entityStu = this.studentRepository.findById(id).orElseThrow(() -> new Exception());
    	
    	// check validate of subject id in student request
    	List<SubjectEntity> sub1 = this.subjectRepository.findAllById(stuReq.getSubjectId());
    	Set<SubjectEntity> sub2 = Set.copyOf(sub1);
    	
    	entityStu.setSubject(sub2);
    	entityStu.setGrade(stuReq.getGrade());
    	entityStu.setName(stuReq.getName());
    	return this.studentRepository.save(entityStu);
    }
    
    public List<StudentEntity>  listAllData(){
    	return this.studentRepository.findAll();
    }
    public StudentEntity  findByOne(Long id) throws Exception{
    	return this.studentRepository.findById(id).orElseThrow(() -> new Exception());
    }
    
    public StudentEntity  delete(Long id) throws Exception{
    	StudentEntity dele =  this.studentRepository.findById(id).orElseThrow(() -> new Exception());
    	 this.studentRepository.deleteById(dele.getId());
    	 return dele;
    }
}
