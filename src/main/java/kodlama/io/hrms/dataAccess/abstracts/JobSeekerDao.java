package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{
	
	JobSeeker getBySeekerId(int seekerId);
	
}
