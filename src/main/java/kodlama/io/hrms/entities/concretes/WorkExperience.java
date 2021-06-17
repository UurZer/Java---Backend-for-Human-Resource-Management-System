package kodlama.io.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="work_experiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 

public class WorkExperience {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="experience_id",unique=true)
	private int experienceId;
	
	@Column(name="company_name" ,nullable=false)
	private String companyName;
	
	@Column(name="job_title" ,nullable=false)
	private String jobTitle;
	
	@Column(name="starting_date" ,nullable=false)
	private Date startingDate;
	

	@Column(name="end_date" ,nullable=true)
	private Date endDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private List<Resume> resume;

	public int getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(int experienceId) {
		this.experienceId = experienceId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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

	public List<Resume> getResume() {
		return resume;
	}

	public void setResume(List<Resume> resume) {
		this.resume = resume;
	}
	
}
