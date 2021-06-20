package kodlama.io.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="education_informations")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resume"}) 
public class EducationInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="education_information_id",unique=true)
	private int educationInformationId;
	
	@Column(name="status",nullable = true)
	public String status;

	@ManyToOne()
	@JoinColumn(name="university_id",nullable = false)
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="department_id",nullable = false)
	private UniversityDepartment universityDepartment;
	
	@Column(name="starting_date",nullable = false)
	private Date startingDate; 
	

	@Column(name="end_date",nullable = true)
	private Date endDate;

	@ManyToOne()
	@JoinColumn(name="resume_id")
	private Resume resume;

	public int getEducationInformationId() {
		return educationInformationId;
	}

	public void setEducationInformationId(int educationInformationId) {
		this.educationInformationId = educationInformationId;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public UniversityDepartment getUniversityDepartment() {
		return universityDepartment;
	}

	public void setUniversityDepartment(UniversityDepartment universityDepartment) {
		this.universityDepartment = universityDepartment;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	
	
}
