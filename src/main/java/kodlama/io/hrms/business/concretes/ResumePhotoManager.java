package kodlama.io.hrms.business.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.business.abstracts.ResumePhotoService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ResumePhotoDao;
import kodlama.io.hrms.entities.concretes.ResumePhoto;

@Service
public class ResumePhotoManager implements ResumePhotoService {

	private ResumePhotoDao resumePhotoDao;
	
	@Autowired
	public ResumePhotoManager(ResumePhotoDao resumePhotoDao) {
		super();
		this.resumePhotoDao = resumePhotoDao;
	}

	@Override
	public Result Add(MultipartFile multipartFile) throws IOException {
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "uur**",
				"api_key", "****************",
				"api_secret", "***********************"));
				
		     	String fileName = multipartFile.getOriginalFilename();
		     	String prefix = fileName.substring(fileName.lastIndexOf("."));
		     	 
		     	File file = null;
		     	 
		     	file = File.createTempFile(fileName, prefix);
		     	multipartFile.transferTo(file);
			
				File myFile = new File(file.toURI());
				Map uploadResult = cloudinary.uploader().upload(myFile, ObjectUtils.emptyMap());
				
				ResumePhoto resumePhoto =new ResumePhoto();
				resumePhoto.setPhotoUrl(uploadResult.get("url").toString());
		
				this.resumePhotoDao.save(resumePhoto);
		
		return new SuccessResult("Resim Eklendi");
	}

}
