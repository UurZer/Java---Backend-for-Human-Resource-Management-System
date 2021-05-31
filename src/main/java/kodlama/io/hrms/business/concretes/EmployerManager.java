package kodlama.io.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.validations.EmailVerificationService;
import kodlama.io.hrms.core.utilities.validations.MernisVerificationService;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{


	public EmployerDao employerDao;

	public UserDao userDao;
	public EmailVerificationService<Employer> emailVerificationService;
	public MernisVerificationService<Employer> mernisVerificaionService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserDao userDao,EmailVerificationService<Employer> emailVerificationService,
			MernisVerificationService<Employer> mernisVerificationService) {
		super();
		this.employerDao=employerDao;
		this.userDao = userDao;
		this.emailVerificationService=emailVerificationService;
		this.mernisVerificaionService=mernisVerificationService;
	}
	public EmployerManager() {}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result Add(Employer employer) {
		
		if(findAllByEmail(employer.getEmail())) {
			if(emailVerificationService.checkIfRealEmail(employer)) {
				if(checkIfEqualEmailAndDomain(employer.getEmail(),employer.getWebSite())) {
					this.employerDao.save(employer);
				}
				else
					return new ErrorResult("Böyle domaine ait mail yok.");
			}
			else
				return new ErrorResult("Böyle bir email yok.");
		}
		else
			return new ErrorResult("Bu email üzerine zaten kayıt var.");
	
		return new SuccessResult();
	}

	public boolean findAllByEmail(String email){

		for (var iterable_element : this.getAll().getData()) {
			if(iterable_element.getEmail()==email)
				return false;
		}
		return true;
	}
	
	private boolean checkIfEqualEmailAndDomain(String email, String website) {

		String[] webAdressKeywords = { "www", "http://www", "https://www" };

		String[] emailDomain = email.split("@",2);
		String domain = "";
		String[] websiteDomain = website.split("\\.",2);
	
		if (Arrays.asList(webAdressKeywords).contains(websiteDomain[0])) {
			domain = websiteDomain[1];
		} else {
			domain = website;
		}

		if (!emailDomain[1].equals(domain)) {
			return false;
		}
		return true;
	}
}
