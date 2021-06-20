package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.WorkExperienceService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkExperienceDao;
import kodlama.io.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{

	private WorkExperienceDao workExperienceDao;
	
	@Autowired
	public WorkExperienceManager( WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}


	@Override
	public Result Add(WorkExperience workExperience) {
		if(workExperience.getEndDate() == null)
			workExperience.setStatus("devam ediyor");
		this.workExperienceDao.save(workExperience);
		
		return new SuccessResult("İş tecrübesi eklendi.");
	}

	
}
