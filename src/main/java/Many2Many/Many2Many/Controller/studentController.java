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
import Many2Many.Many2Many.Model.Request.studentRequest;
import Many2Many.Many2Many.Model.Response.studentResponse;
import Many2Many.Many2Many.Services.studentService;

@RestController
@RequestMapping("/api/student")
public class studentController {

	private studentService stuService;
    @Autowired
	public studentController(studentService stuService) {
		super();
		this.stuService = stuService;
	}
	@PostMapping
    public ResponseEntity<studentResponse> createDataStud(@RequestBody studentRequest stuReq){
    	StudentEntity student = this.stuService.addData(stuReq);
    	return ResponseEntity.ok(studentResponse.methodResponseStudent(student));
    }
	@PutMapping("/{id}")
    public ResponseEntity<studentResponse> updateDataStud(@PathVariable Long id, @RequestBody studentRequest stuReq) throws Exception{
    	StudentEntity student = this.stuService.updateData(id, stuReq);
    	return ResponseEntity.ok(studentResponse.methodResponseStudent(student));
    }
    @GetMapping
    public ResponseEntity<List<studentResponse>> getDataAll(){
    	List<studentResponse> getAll = this.stuService.listAllData().stream().map(studentResponse::methodResponseStudent).toList();
    	return ResponseEntity.ok(getAll);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<studentResponse> deleteData(@PathVariable Long id) throws Exception{
    	StudentEntity student = this.stuService.delete(id);
    	return ResponseEntity.ok(studentResponse.methodResponseStudent(student));
    }
    @GetMapping("/{id}")
    public ResponseEntity<studentResponse> findByOne(@PathVariable Long id) throws Exception{
    	StudentEntity student = this.stuService.findByOne(id);
    	return ResponseEntity.ok(studentResponse.methodResponseStudent(student));
    }
}
