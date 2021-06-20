package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EducationInformationService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EducationInformationDao;
import kodlama.io.hrms.entities.concretes.EducationInformation;

@Service
public class EducationInformationManager implements EducationInformationService {

	private EducationInformationDao educationInformationDao;
	
	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}
	
	@Override
	public Result Add(EducationInformation educationInformation) {
		
		if(educationInformation.getEndDate() == null)
			educationInformation.setStatus("devam ediyor");
		
		this.educationInformationDao.save(educationInformation);
		
		return new SuccessResult("Eğitim bilgisi eklendi.");
	}

}
