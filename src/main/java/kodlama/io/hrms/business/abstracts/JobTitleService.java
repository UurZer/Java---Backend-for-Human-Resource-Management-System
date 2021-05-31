package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobTitle;


public interface JobTitleService {
	 DataResult<List<JobTitle>> getAll();
	 Result Delete(JobTitle jobTitle);
	 Result Add(JobTitle jobTitle);
}
