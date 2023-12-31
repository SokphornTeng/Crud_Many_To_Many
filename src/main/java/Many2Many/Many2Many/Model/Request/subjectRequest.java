package Many2Many.Many2Many.Model.Request;

import java.io.Serializable;

import Many2Many.Many2Many.Model.Entity.SubjectEntity;

public class subjectRequest implements Serializable {

     private String subjectName;

	public subjectRequest(String subjectName) {
		super();
		this.subjectName = subjectName;
	}
	
	public SubjectEntity subjectMethodReq(){
		SubjectEntity subj = new SubjectEntity();
		subj.setSubjectName(this.subjectName);
		return subj;
	}
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
       
}
