package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.ResumePhoto;



public interface ResumePhotoDao  extends JpaRepository<ResumePhoto,Integer>{

}
