package kodlama.io.hrms.api.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import kodlama.io.hrms.business.abstracts.ResumePhotoService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;




@RestController//Bu sınıfın Controller olduğunu söylüyoruz
@RequestMapping("/api/resumephotos")//Route
public class ResumePhotosController {

	private ResumePhotoService resumePhotoService;

	@Autowired
	public ResumePhotosController(ResumePhotoService resumePhotoService) {
		super();
		this.resumePhotoService = resumePhotoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestPart("photoUrl") MultipartFile multipartFile) throws IOException{
     	
		this.resumePhotoService.Add(multipartFile);
		return new SuccessResult("Resim Eklendi");
	}
}
