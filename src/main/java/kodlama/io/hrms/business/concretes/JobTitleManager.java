package kodlama.io.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobTitleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobTitleDao;
import kodlama.io.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	@Autowired//
	public JobTitleDao jobTitleDao;


	public JobTitleManager() {}
	
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>
		("Data Listelendi",this.jobTitleDao.findAll());
	}
	
	@Override
	public Result Delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult();
	}

	@Override
	public Result Add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return  new SuccessResult("Yeni iş posizyonu eklendi");
	}
	
}
