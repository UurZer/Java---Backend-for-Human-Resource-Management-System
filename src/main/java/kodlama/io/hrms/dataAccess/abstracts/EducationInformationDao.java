package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.EducationInformation;



public interface EducationInformationDao extends JpaRepository<EducationInformation,Integer>{
	
}
