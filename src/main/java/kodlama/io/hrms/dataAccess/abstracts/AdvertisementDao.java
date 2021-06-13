package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlama.io.hrms.entities.concretes.Advertisement;



public interface AdvertisementDao extends JpaRepository<Advertisement,Integer>{

	Advertisement getByTitle_TitleId(int titleId);
	
	List<Advertisement> getByStatus(boolean status);//Req 8 : Sistemdeki tüm aktif iş ilanları listelenebilmelidir.

	List<Advertisement> findAllByOrderByapplicationDeadline(boolean status);//Req 9 : Sistemdeki tüm aktif iş ilanları tarihe göre listelenebilmelidir.
	
	List<Advertisement> getByEmployer_EmployerId(int employerId);//Req 10 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.

	Advertisement getByid(int advertisementId);//Req 11 : Sistemde bir firmaya ait tüm aktif iş ilanları listelenebilmelidir.
	

}
