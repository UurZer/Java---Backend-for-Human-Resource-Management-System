package kodlama.io.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EducationInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.EducationInformation;

@RestController//Bu sınıfın Controller olduğunu söylüyoruz
@RequestMapping("/api/educationinformations")//Route
@CrossOrigin
public class EducationInformationsController {

	private EducationInformationService educationInformationService;

	@Autowired
	public EducationInformationsController(EducationInformationService educationInformationService) {
		super();
		this.educationInformationService = educationInformationService;
	}
	
	@PostMapping(value="/add")
	private Result Add(@RequestBody EducationInformation educationInformation)
	{
		return this.educationInformationService.Add(educationInformation);
	}
	
	@GetMapping(value="/getall")
	private Result GetAll()
	{
		return this.educationInformationService.GetAll();
	}
}
