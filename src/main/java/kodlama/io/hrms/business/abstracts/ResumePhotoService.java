package kodlama.io.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.Result;



public interface ResumePhotoService {
	
	Result Add(MultipartFile multipartFile)throws IOException;
	
}
