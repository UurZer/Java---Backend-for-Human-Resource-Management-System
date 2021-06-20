package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Resume;



public interface ResumeDao extends JpaRepository<Resume,Integer>{

	
}
