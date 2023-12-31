package Many2Many.Many2Many.Model.Response;

import java.io.Serializable;

import Many2Many.Many2Many.Model.Entity.SubjectEntity;

public class subjectResponse implements Serializable{

	private Long id;
	private String subjectName;
	
	public subjectResponse(Long id, String subjectName) {
		super();
		this.id = id;
		this.subjectName = subjectName;
	}
	public static subjectResponse subjectMethodResponse(SubjectEntity sub) {
		return new subjectResponse(sub.getId(), sub.getSubjectName());
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}
