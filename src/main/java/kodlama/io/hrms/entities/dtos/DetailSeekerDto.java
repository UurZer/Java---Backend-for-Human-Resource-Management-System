package kodlama.io.hrms.entities.dtos;

import java.util.List;

import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.EducationInformation;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.ProgrammingSkill;
import kodlama.io.hrms.entities.concretes.Resume;
import kodlama.io.hrms.entities.concretes.WorkExperience;

public class DetailSeekerDto {
	public DetailSeekerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailSeekerDto(JobSeeker jobSeeker, List<EducationInformation> educationInformation, List<ForeignLanguage> foreignLanguage,
			List<ProgrammingSkill> programmingSkill, City city, List<WorkExperience> workExperience,
			List<Resume> resumes) {
		super();
		this.candidate = candidate;
		this.schools = schools;
		this.languages = languages;
		this.programmingLanguages = programmingLanguages;
		this.city = city;
		this.jobExperiences = jobExperiences;
		this.resumes = resumes;
	}

	Candidate candidate;
	List<School> schools;
	List<Language> languages;
	List<ProgrammingLanguage> programmingLanguages;
	City city;
	List<JobExperience> jobExperiences;
	List<Resume> resumes;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public List<School> getSchools() {
		return schools;
	}

	public void setSchools(List<School> schools) {
		this.schools = schools;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<ProgrammingLanguage> getProgrammingLanguages() {
		return programmingLanguages;
	}

	public void setProgrammingLanguages(List<ProgrammingLanguage> programmingLanguages) {
		this.programmingLanguages = programmingLanguages;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<JobExperience> getJobExperiences() {
		return jobExperiences;
	}

	public void setJobExperiences(List<JobExperience> jobExperiences) {
		this.jobExperiences = jobExperiences;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}
}
