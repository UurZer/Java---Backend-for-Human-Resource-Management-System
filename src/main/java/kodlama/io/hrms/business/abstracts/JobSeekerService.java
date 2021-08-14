package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeeker;


public interface JobSeekerService {
	 DataResult<List<JobSeeker>> getAll();
	 DataResult<JobSeeker> getBySeekerId(int seekerId);
	 Result Add(JobSeeker jobSeeker);
}
