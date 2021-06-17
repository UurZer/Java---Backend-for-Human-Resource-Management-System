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
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="education_information")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 
public class EducationInformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="education_information_id",unique=true)
	private int educationInformationId;
	
	@ManyToOne()
	@JoinColumn(name="university_id",nullable = false)
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="faculty_id",nullable = false)
	private Faculty faculty;
	
	@Column(name="starting_date",nullable = false)
	private Date startingDate; 
	

	@Column(name="end_date",nullable = true)
	private Date endDate;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;

	
}
