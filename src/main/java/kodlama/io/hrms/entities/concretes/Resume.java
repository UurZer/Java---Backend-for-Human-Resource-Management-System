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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="resume")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 

public class Resume {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="advertisement_id",unique=true)
	private int resume_id;
	
	@OneToMany(mappedBy ="resume")
	@JoinColumn(name="education_information_id")
	private List<EducationInformation> educationInformation;
	
	@OneToMany(mappedBy ="resume")
	@JoinColumn(name="work_experience_id")
	private List<WorkExperience> workExperience;
	
	@OneToMany()
	@JoinColumn(name="language_id",nullable = false)
	private List<ForeignLanguage> foreignLanguage;
	
	@OneToMany()
	@JoinColumn(name="social_media_id",nullable = true)
	private List<SocialMedia> socialMedia;
}
