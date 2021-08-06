package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SalaryScaleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.SalaryScale;


@RestController//Bu sınıfın Controller olduğunu söylüyoruz
@RequestMapping("/api/salaryscales")//Route
@CrossOrigin
public class SalaryScalesController {

	SalaryScaleService salaryScalesService;

	public SalaryScalesController(SalaryScaleService salaryScalesService) {
		super();
		this.salaryScalesService = salaryScalesService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<SalaryScale>> getAll(){
		return this.salaryScalesService.GetAll();
	}
}
