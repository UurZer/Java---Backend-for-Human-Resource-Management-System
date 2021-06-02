package kodlama.io.hrms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kodlama.io.hrms.business.abstracts.AdvertisementService;
import kodlama.io.hrms.business.concretes.AdvertisementManager;
import kodlama.io.hrms.core.utilities.validations.EmailVerificationManager;
import kodlama.io.hrms.core.utilities.validations.EmailVerificationService;
import kodlama.io.hrms.core.utilities.validations.MernisVerificationManager;
import kodlama.io.hrms.core.utilities.validations.MernisVerificationService;

@Configuration
public class AppConfiguration<T> {
	@Bean
    public EmailVerificationService<T> mailVerificationService(){
        return new EmailVerificationManager<T>();
    }

    @Bean
    public MernisVerificationService<T> mernisVerificationService(){
        return new MernisVerificationManager<T>();
    }
    

}
