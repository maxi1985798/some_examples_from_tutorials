package springmvc.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springmvc.java.service.EmailService;
import springmvc.java.service.ServiceManager;
import springmvc.java.service.impl.EmailServiceImpl;
import springmvc.java.service.impl.ServiceManagerImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public EmailService emailService() {
		return new EmailServiceImpl();
	}
	
	@Bean
	public ServiceManager serviceManager() {
		return new ServiceManagerImpl();
	}
}
