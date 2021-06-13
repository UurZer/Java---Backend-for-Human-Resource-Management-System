package kodlama.io.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.AdvertisementDao;
import kodlama.io.hrms.entities.concretes.Advertisement;

@Service
public class AdvertisementManager implements AdvertisementService{

	private AdvertisementDao advertisementDao;
	
	@Autowired
	public AdvertisementManager(AdvertisementDao advertisementDao) {
		super();
		this.advertisementDao = advertisementDao;
	}

	@Override
	public DataResult<Advertisement> getByTitle_TitleId(int titleId) {
		return new SuccessDataResult<Advertisement>(this.advertisementDao.getByTitle_TitleId(titleId));
	}

	@Override
	public Result Add(Advertisement advertisement) {
		this.advertisementDao.save(advertisement);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public DataResult<List<Advertisement>> getByStatusTrue(boolean status) {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByStatus(status));
	}

	@Override
	public DataResult<List<Advertisement>> findAllByOrderByDateAscAndStatusTrue(boolean status,Date application_deadline) {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.findAllByOrderByapplicationDeadline(status));
	}

	@Override
	public DataResult<List<Advertisement>> getByStatusTrueAndEmployer_EmployerId(boolean status, int employerId) {
		return new SuccessDataResult<List<Advertisement>>(this.advertisementDao.getByEmployer_EmployerId(employerId));
	}
	@Override
	public Result ChangeStatus(Advertisement advertisement,boolean status) {
		 Advertisement result = this.advertisementDao.getByid(advertisement.getId());
		 
		 result.setStatus(status);
		 this.advertisementDao.save(result);
		 return new SuccessResult("İş durumu değiştirildi.");
	}
	@Override
	public DataResult<Advertisement> getByStatusTrueAndAdvertisement_AdvertisementId(boolean status, int advertisementId) {
		
		return new SuccessDataResult<Advertisement>(this.advertisementDao.getByid(advertisementId));
	}

}