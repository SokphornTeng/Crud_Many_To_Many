package Many2Many.Many2Many.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Many2Many.Many2Many.Model.Entity.StudentEntity;
import Many2Many.Many2Many.Model.Entity.SubjectEntity;
import Many2Many.Many2Many.Model.Request.subjectRequest;
import Many2Many.Many2Many.Model.Response.studentResponse;
import Many2Many.Many2Many.Model.Response.subjectResponse;
import Many2Many.Many2Many.Services.subjectService;

@RestController
@RequestMapping("/api/subject")
public class subjectController {

	private subjectService subjService;
    @Autowired
	public subjectController(subjectService subjService) {
		super();
		this.subjService = subjService;
	}
	
    @PostMapping
    public ResponseEntity<subjectResponse> createMethod(@RequestBody subjectRequest reqSubj) throws Exception{
    	
    	SubjectEntity entitySubj = this.subjService.createData(reqSubj);
    	return ResponseEntity.ok(subjectResponse.subjectMethodResponse(entitySubj));
    }
    @PutMapping("/{id}")
    public ResponseEntity<subjectResponse> updatesMethod(@PathVariable Long id, @RequestBody subjectRequest reqSubj) throws Exception{
    	
    	SubjectEntity entitySubj = this.subjService.updateData(id, reqSubj);
    	return ResponseEntity.ok(subjectResponse.subjectMethodResponse(entitySubj));
    }
    @GetMapping
    public ResponseEntity<List<subjectResponse>> getDataAll(){
    	List<subjectResponse> getAll = this.subjService.listAllData().stream().map(subjectResponse::subjectMethodResponse).toList();
    	return ResponseEntity.ok(getAll);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<subjectResponse> deleteData(@PathVariable Long id) throws Exception{
    	SubjectEntity student = this.subjService.delete(id);
    	return ResponseEntity.ok(subjectResponse.subjectMethodResponse(student));
    }
    @GetMapping("/{id}")
    public ResponseEntity<subjectResponse> findByOne(@PathVariable Long id) throws Exception{
    	SubjectEntity student = this.subjService.findByOne(id);
    	return ResponseEntity.ok(subjectResponse.subjectMethodResponse(student));
    }
}
