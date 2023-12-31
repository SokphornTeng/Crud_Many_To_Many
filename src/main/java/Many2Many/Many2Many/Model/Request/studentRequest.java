package Many2Many.Many2Many.Model.Request;

import java.io.Serializable;
import java.util.List;

import Many2Many.Many2Many.Model.Entity.StudentEntity;

public class studentRequest implements Serializable{

	private String name;
	private Integer grade;
	private List<Long> subjectId;
	
	public StudentEntity  studentReqMethod() {
		StudentEntity stu = new StudentEntity();
		stu.setName(this.name);
		stu.setGrade(this.grade);
		
		return stu;
	}
	

	public studentRequest(String name, Integer grade, List<Long> subjectId) {
		super();
		this.name = name;
		this.grade = grade;
		this.subjectId = subjectId;
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
	public List<Long> getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(List<Long> subjectId) {
		this.subjectId = subjectId;
	}
	
	
	
}
