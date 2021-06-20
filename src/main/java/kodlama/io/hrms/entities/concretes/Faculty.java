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
@Table(name="faculties")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","universityDepartment"})
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="faculty_id",unique=true)
	private int facultyId;
	
	@Column(name="faculty_name")
	private String facultyName;
	
	@Column(name="status")
	private int status;

	@OneToMany(mappedBy="faculty")
	private List<UniversityDepartment> universityDepartment;

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<UniversityDepartment> getUniversityDepartment() {
		return universityDepartment;
	}

	public void setUniversityDepartment(List<UniversityDepartment> universityDepartment) {
		this.universityDepartment = universityDepartment;
	}

	

	
}
