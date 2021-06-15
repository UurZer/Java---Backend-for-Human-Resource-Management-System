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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class Employer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_id",unique = true)
	private int employerId;
	
	@Column(name="company_name",unique = false)
	private String companyName;
	
	@Column(name="web_addres",unique = false)
	private String webSite;
	
	@Column(name="email",unique = false)
	private String email;

	@Column(name="phone_number",unique = false)
	private String phoneNumber;
	
	@Column(name="password",unique = false)
	private String password;
	
	@OneToMany(mappedBy = "employer")
	private List<Advertisement> Advertisements;

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Advertisement> getAdvertisements() {
		return Advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		Advertisements = advertisements;
	}

	
}
