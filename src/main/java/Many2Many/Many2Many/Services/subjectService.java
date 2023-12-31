package Many2Many.Many2Many.Services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Many2Many.Many2Many.Model.Entity.StudentEntity;
import Many2Many.Many2Many.Model.Entity.SubjectEntity;
import Many2Many.Many2Many.Model.Request.subjectRequest;
import Many2Many.Many2Many.Repo.SubjectRepo;

@Service
public class subjectService {
	
    private SubjectRepo subjectRepository;
    @Autowired
	public subjectService(SubjectRepo subjectRepository) {
		super();
		this.subjectRepository = subjectRepository;
	}
    
    public SubjectEntity createData(subjectRequest reqSubj) throws Exception {
    	
    	SubjectEntity newSubj = reqSubj.subjectMethodReq();
    	
        if(this.subjectRepository.existsBySubjectName(newSubj.getSubjectName()))
        	throw new Exception("This subject already exist");
        
        try {
        	return this.subjectRepository.save(newSubj);
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
    
  public SubjectEntity updateData(Long id, subjectRequest reqSubj) throws Exception {
    	
    	SubjectEntity newSubj = this.subjectRepository.findById(id).orElseThrow(() -> new Exception());
    	
    	if(!Objects.equals(newSubj.getSubjectName(), reqSubj.getSubjectName()))
        if(this.subjectRepository.existsBySubjectName(reqSubj.getSubjectName()))
        	throw new Exception("This subject already exist");
        
    	newSubj.setSubjectName(reqSubj.getSubjectName());
        try {
        	return this.subjectRepository.save(newSubj);
		} catch (Exception e) {
			throw new Exception(e);
		}
    }

  
  public List<SubjectEntity>  listAllData(){
  	return this.subjectRepository.findAll();
  }
  
  public SubjectEntity  findByOne(Long id) throws Exception{
  	return this.subjectRepository.findById(id).orElseThrow(() -> new Exception());
  }
  
  public SubjectEntity  delete(Long id) throws Exception{
	  SubjectEntity dele =  this.subjectRepository.findById(id).orElseThrow(() -> new Exception());
  	 this.subjectRepository.deleteById(dele.getId());
  	 return dele;
  }

}
