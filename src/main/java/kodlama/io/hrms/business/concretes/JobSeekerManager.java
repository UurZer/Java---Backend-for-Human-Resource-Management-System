package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	

		JobSeekerDao jobSeekerDao;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao=jobSeekerDao;
	}
	public JobSeekerManager() {}
	@Override
	public DataResult<List<JobSeeker>> getAll() {
	
		return new SuccessDataResult<List<JobSeeker>>("Listelendi",this.jobSeekerDao.findAll());
	}

	@Override
	public Result Add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		
		return new SuccessResult();
		/*if(this.checkIfİsThereUser(jobSeeker.getUser().getUserId()))
		{
			if(!this.checkIfUserAlreadySeeker(jobSeeker.getUser().getUserId()))
			{
				this.jobSeekerDao.save(jobSeeker);							
				return new SuccessResult("İş arayanlara eklendi");
			}
			return new SuccessResult("Zaten bu kullanıcı iş arayanlardan");
		}
		else
			return new SuccessResult("Böyle bir kullanıcı yok.");
		*/
	}
	
//	private boolean checkIfİsThereUser(int userId) 
//	{
//		return this.userService.getAll().getData().stream()
//				.filter(u -> u.getUserId() == userId)
//				.findFirst().isPresent();
//	}
	
//	private boolean checkIfUserAlreadySeeker(int userId){
//
//		return this.getAll().getData().stream()
//				.filter(u -> u.getUser().getUserId() == userId)
//				.findFirst().isPresent();
//	}
	
	@Override
	public DataResult<JobSeeker> getBySeekerId(int seekerId) {
		return new SuccessDataResult<JobSeeker>("İş arayan listelendi.",this.jobSeekerDao.getBySeekerId(seekerId));
	}

}
