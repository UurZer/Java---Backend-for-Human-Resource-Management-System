package kodlama.io.hrms.business.abstracts;


import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Advertisement;

public interface AdvertisementService {
	DataResult<List<Advertisement>> getByTitle_TitleId(int titleId);
	
	Result Add(Advertisement advertisement);		
	
	DataResult<List<Advertisement>> getByStatusTrue(boolean status);//Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.
	
	DataResult<List<Advertisement>> findAllByOrderByDateAscAndStatusTrue();//Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.
	
	DataResult<List<Advertisement>> getByStatusAndEmployer_EmployerId(boolean status,int employerId);//Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.
	
	DataResult<Advertisement> getByStatusTrueAndAdvertisement_AdvertisementId(boolean status,int advertisementId);//Req 11 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.
	
	Result ChangeStatus(Advertisement advertisement,boolean status);
	
	DataResult<List<Advertisement>> getAll();
	
	DataResult<List<Advertisement>> findByIsVerifiedTrueAndStatusTrue();
	
	DataResult<Advertisement> getById(int id);
 }
