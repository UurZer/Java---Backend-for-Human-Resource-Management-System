package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.validations.EmailVerificationService;
import kodlama.io.hrms.core.utilities.validations.MernisVerificationService;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.JobTitle;
import kodlama.io.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	@Autowired
	public UserDao userDao;
	public EmailVerificationService<User> emailVerificationService;
	public MernisVerificationService<User> mernisVerificaionService;
	
	public UserManager(UserDao userDao,EmailVerificationService<User> emailVerificationService,
			MernisVerificationService<User> mernisVerificaionService ) {
		super();
		this.userDao = userDao;
		this.emailVerificationService= emailVerificationService;
		this.mernisVerificaionService=mernisVerificaionService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>
		("Data Listelendi",this.userDao.findAll());
	}

	@Override
	public Result Delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult();
	}

	@Override
	public Result Add(User user) {
		if(findAllByEmail(user.getEmail())) {
			if(emailVerificationService.checkIfRealEmail(user)) {
				if(mernisVerificaionService.checkIfRealPerson(user)) {
					this.userDao.save(user);
				}
				else
					return new ErrorResult("Böyle Tc'ye ait kişi yok.");
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

}
