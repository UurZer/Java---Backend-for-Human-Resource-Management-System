package kodlama.io.hrms.entities.concretes;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="resumes")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 
public class Resume {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resume_id",unique=true)
	private int resumeId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="letter_id")
	private CoverLetter coverLetter;

	@ManyToOne
	@JoinColumn(name="photo_id")
	private ResumePhoto resumePhoto;

	
	@OneToMany(mappedBy ="resume",cascade = CascadeType.ALL)
	private List<EducationInformation> educationInformation;
	
	@OneToMany(mappedBy ="resume",cascade = CascadeType.ALL)
	private List<WorkExperience> workExperience;
	
	@OneToMany(mappedBy ="resume",cascade = CascadeType.ALL)
	private List<ForeignLanguage> foreignLanguage;
	
	@OneToMany(mappedBy ="resume",cascade = CascadeType.ALL)
	private List<SocialMedia> socialMedia;
	
	@OneToMany(mappedBy ="resume",cascade = CascadeType.ALL)
	private List<ProgrammingSkill> programmingSkill;
	
	public int getResumeId() {
		return resumeId;
	}

	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CoverLetter getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(CoverLetter coverLetter) {
		this.coverLetter = coverLetter;
	}

	public ResumePhoto getResumePhoto() {
		return resumePhoto;
	}

	public void setResumePhoto(ResumePhoto resumePhoto) {
		this.resumePhoto = resumePhoto;
	}



	public List<EducationInformation> getEducationInformation() {
		return educationInformation;
	}

	public void setEducationInformation(List<EducationInformation> educationInformation) {
		this.educationInformation = educationInformation;
	}

	public List<WorkExperience> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(List<WorkExperience> workExperience) {
		this.workExperience = workExperience;
	}

	public List<ForeignLanguage> getForeignLanguage() {
		return foreignLanguage;
	}

	public void setForeignLanguage(List<ForeignLanguage> foreignLanguage) {
		this.foreignLanguage = foreignLanguage;
	}

	public List<SocialMedia> getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(List<SocialMedia> socialMedia) {
		this.socialMedia = socialMedia;
	}

	public List<ProgrammingSkill> getProgrammingSkill() {
		return programmingSkill;
	}

	public void setProgrammingSkill(List<ProgrammingSkill> programmingSkill) {
		this.programmingSkill = programmingSkill;
	}

	
	
	

}
