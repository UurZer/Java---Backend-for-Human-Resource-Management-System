package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="foreign_languages")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 

public class ForeignLanguage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="language_id",unique=true)
	private int languageId;
	
	@Column(name="language_name",nullable=false)
	private String languageName;
	
	@Column(name="language_level",nullable=false)
	private int languageLevel;
	
	@ManyToOne()
	@Column(name="resume_id")
	private Resume resume;
	
	
	
	
	
	
}
