package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SalaryScaleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.SalaryScaleDao;
import kodlama.io.hrms.entities.concretes.SalaryScale;

@Service
public class SalaryScaleManager implements SalaryScaleService {

	SalaryScaleDao salaryScaleDao; 
	
	public SalaryScaleManager(SalaryScaleDao salaryScaleDao) {
		super();
		this.salaryScaleDao = salaryScaleDao;
	}

	@Override
	public DataResult<List<SalaryScale>> GetAll() {
		return new SuccessDataResult<List<SalaryScale>>(this.salaryScaleDao.findAll());
	}

}
