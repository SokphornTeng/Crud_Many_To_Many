package Many2Many.Many2Many.Model.Response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import Many2Many.Many2Many.Model.Entity.StudentEntity;
import Many2Many.Many2Many.Model.Entity.SubjectEntity;

public class studentResponse implements Serializable{

	private Long id;
	private String name;
	private Integer grade;
	private List<subjectResponse> subject;
	
	public static studentResponse methodResponseStudent(StudentEntity stud) {
		
		ArrayList<subjectResponse> subj = new ArrayList<subjectResponse>(Collections.emptyList());
        if(stud.getSubject() != null) {
        	for(SubjectEntity subject : stud.getSubject()) {
        		subj.add(subjectResponse.subjectMethodResponse(subject));
        	}
        }
		
		return new studentResponse(
				stud.getId(),
				stud.getName(),
				stud.getGrade(),
				subj
				);
	}
	
	public studentResponse(Long id, String name, Integer grade, List<subjectResponse> subject) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.subject = subject;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public List<subjectResponse> getSubject() {
		return subject;
	}
	public void setSubject(List<subjectResponse> subject) {
		this.subject = subject;
	}
	
	
}
