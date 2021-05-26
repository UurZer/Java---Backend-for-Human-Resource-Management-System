package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employers {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employer_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site")
	private String webSite;
	
	@Column(name="email")
	private String email;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="password")
	private String password;

	
}
