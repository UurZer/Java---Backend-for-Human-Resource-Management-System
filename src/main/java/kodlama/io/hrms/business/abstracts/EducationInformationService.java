package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.EducationInformation;

public interface EducationInformationService {
	
	Result Add(EducationInformation educationInformation);
	DataResult<List<EducationInformation>> GetAll();
	
}
