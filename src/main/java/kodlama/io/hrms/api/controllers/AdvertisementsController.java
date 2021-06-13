package kodlama.io.hrms.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Advertisement;

@RestController//Bu sınıfın Controller olduğunu söylüyoruz
@RequestMapping("/api/advertisements")//Route
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
	public DataResult<List<Advertisement>> findAllByOrderByDateAscAndStatusTrue(@RequestParam("status") boolean status,@RequestParam("applicationDeadline") Date applicationDeadline) {
		return this.advertisementService.findAllByOrderByDateAscAndStatusTrue(status,applicationDeadline);
	}
	
	@GetMapping("/getByStatusTrueAndEmployer_EmployerId")
	public DataResult<List<Advertisement>> getByStatusTrueAndEmployer_EmployerId(@RequestParam("status") boolean status,@RequestParam int employerId) {
		return this.advertisementService.getByStatusTrueAndEmployer_EmployerId(status,employerId);
	}
	
	@GetMapping("/getByTitle_TitleId")
	public DataResult<Advertisement> getByTitle_TitleId(@RequestBody int titleId) {
		return this.advertisementService.getByTitle_TitleId(titleId);
	}
	
	
	
}
