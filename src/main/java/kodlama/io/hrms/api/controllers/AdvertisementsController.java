package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.AdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Advertisement;

@RestController//Bu sınıfın Controller olduğunu söylüyoruz
@RequestMapping("/api/advertisements")//Route
@CrossOrigin
public class AdvertisementsController {
	
	private AdvertisementService advertisementService;

	@Autowired
	public AdvertisementsController(AdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}
	
	@PostMapping("/add")
	public Result Add(@RequestBody Advertisement advertisement) {
		return this.advertisementService.Add(advertisement);
	}
	
	@GetMapping("/findAllByOrderByDateAscAndStatusTrue")
	public DataResult<List<Advertisement>> findAllByOrderByDateAscAndStatusTrue() {
		return this.advertisementService.findAllByOrderByDateAscAndStatusTrue();
	}
	
	@GetMapping("/getByStatusTrueAndEmployer_EmployerId")
	public DataResult<List<Advertisement>> getByStatusTrueAndEmployer_EmployerId(@RequestParam int employerId,@RequestParam("status") boolean status) {
		return this.advertisementService.getByStatusAndEmployer_EmployerId(status,employerId);
	}
	
	@GetMapping("/getByTitle_TitleId")
	public DataResult<List<Advertisement>> getByTitle_TitleId(@RequestParam("titleId") int titleId) {
		return this.advertisementService.getByTitle_TitleId(titleId);
	}
	
	@GetMapping("/getById")
	public DataResult<Advertisement> getById(@RequestParam("id") int id) {
		return this.advertisementService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Advertisement>> getAll() {
		return this.advertisementService.getAll();
	}
	
	@PostMapping("/changeStatus")
	public Result changeStatus(@RequestBody Advertisement advertisement,boolean status) {
		return this.advertisementService.ChangeStatus(advertisement,status);
	}
	
	@GetMapping("findByIsVerifiedTrueAndStatusTrue")
	public DataResult<List<Advertisement>> findByIsVerifiedTrueAndStatusTrue(){
		return this.advertisementService.findByIsVerifiedTrueAndStatusTrue();
	}
}
