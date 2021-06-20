package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService {
	Result Add(WorkExperience workExperience);
}
