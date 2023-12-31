package Many2Many.Many2Many.Model.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40, nullable = false)
	private String name;
	@Column(nullable = false)
	private Integer grade;
	
	@ManyToMany
	@JoinTable(name="stu_subj", joinColumns = @JoinColumn(name="stud_id"), inverseJoinColumns = @JoinColumn(name="subj_id"))
	@OrderBy("name asc")
	private Set<SubjectEntity> subject;

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

	public Set<SubjectEntity> getSubject() {
		return subject;
	}

	public void setSubject(Set<SubjectEntity> subject) {
		this.subject = subject;
	}
	
	
}
