package kodlama.io.hrms.entities.concretes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="advertisements")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 
public class Advertisement {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="advertisement_id",unique=true)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="title_id")
	private JobTitle jobTitle;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="scale_id")
	private SalaryScale salaryScale;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="is_verified")
	private boolean isVerified;

	@Column(name="way_of_working")
	private String wayOfWorking;
	
	@Column(name="working_time")
	private String workingTime;

	@Column(name="created_date")
	private LocalDate createdDate;


	public String getWayOfWorking() {
		return wayOfWorking;
	}

	public void setWayOfWorking(String wayOfWorking) {
		this.wayOfWorking = wayOfWorking;
	}

	public String getWorkingTime() {
		return workingTime;
	}

	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public SalaryScale getSalaryScale() {
		return salaryScale;
	}

	public void setSalaryScale(SalaryScale salaryScale) {
		this.salaryScale = salaryScale;
	}

	public int getNumberOfOpenPositions() {
		return numberOfOpenPositions;
	}

	public void setNumberOfOpenPositions(int numberOfOpenPositions) {
		this.numberOfOpenPositions = numberOfOpenPositions;
	}

	public Date getApplicationDeadline() {
		return applicationDeadline;
	}

	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
