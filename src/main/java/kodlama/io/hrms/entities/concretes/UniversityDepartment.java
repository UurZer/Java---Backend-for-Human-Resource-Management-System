package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="university_departments")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","educationInformation"}) 
public class UniversityDepartment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id",unique = true)
	private int departmendId;
	
	@Column(name="department_name",unique = true)
	private String departmentName;
	
	@ManyToOne()
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@OneToMany(mappedBy="universityDepartment")
	private List<EducationInformation> educationInformation;
	
	@Column(name="status",unique = true)
	private int status;

	public int getDepartmendId() {
		return departmendId;
	}

	public void setDepartmendId(int departmendId) {
		this.departmendId = departmendId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<EducationInformation> getEducationInformation() {
		return educationInformation;
	}

	public void setEducationInformation(List<EducationInformation> educationInformation) {
		this.educationInformation = educationInformation;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
