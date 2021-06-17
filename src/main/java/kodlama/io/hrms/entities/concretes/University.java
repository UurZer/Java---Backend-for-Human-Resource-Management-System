package kodlama.io.hrms.entities.concretes;

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
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="universities")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"}) 

public class University {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="university_id",unique=true)
	private int universityId;
	
	@Column(name="university_name")
	private String universityName;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="status")
	private int status;

}
