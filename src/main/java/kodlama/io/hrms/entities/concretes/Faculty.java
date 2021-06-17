package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="faculties")
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="faculty_id",unique=true)
	private int facultyId;
	
	@Column(name="faculty_name")
	private int facultyName;
	
	@Column(name="status")
	private int status;
	
	@OneToMany(mappedBy = "faculty")
	List<University> university;
	
	
	
	
}
