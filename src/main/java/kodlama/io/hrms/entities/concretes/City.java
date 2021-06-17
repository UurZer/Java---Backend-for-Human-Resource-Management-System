package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cities")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements","university"})
public class City {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id",unique = true)
	private int id;
	
	@Column(name="code",unique = false)
	private String code;
	
	@Column(name="name",unique = false)
	private String name;
	

	@OneToMany(mappedBy = "city")
	private List<Advertisement> Advertisements;

	@OneToMany(mappedBy = "city")
	private List<University> university;
	

	public List<University> getUniversity() {
		return this.university;
	}

	public void setUniversity(List<University> university) {
		this.university = university;
	}

	public List<Advertisement> getAdvertisements() {
		return Advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		Advertisements = advertisements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
